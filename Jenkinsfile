pipeline {
    agent {
            label "Permanent"
        }
    stages {
        stage('Checkouts') {
            steps {
                git url: 'https://github.com/Ahmodiyy/computation.git', branch: 'main'
            }
        }
        stage("Compiles") {
                steps {
                    //bat "chmod +x gradlew"
                    bat "java -version"
                    bat "./gradlew --version"
                    bat "./gradlew clean"
                    bat "./gradlew compileJava"
            }
        }
        stage("Test") {
                steps {
                    bat "./gradlew test"
            }
        }
        stage("Code Coverage") {
            steps {
                bat "./gradlew jacocoTestReport"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                bat "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("CheckStyle") {
              steps {
                bat "./gradlew checkstyleMain"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/checkstyle',
                    reportFiles: 'main.html',
                    reportName: 'Checkstyle Report'
                ])
            }
        }
    }
    post {
        always {
            mail to: 'codeble101@gmail.com',
                 subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Your build completed check : ${env.BUILD_URL}"
                 slackSend channel: '#slackah', color: 'good', message: "The pipeline ${currentBuild.fullDisplayName}"
        }
    }
}