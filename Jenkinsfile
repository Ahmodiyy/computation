pipeline {
    agent any

    stages {
        stage('Checkouts') {
            steps {
                git url: 'https://github.com/Ahmodiyy/computation.git', branch: 'main'
            }
        }
        stage("Compiles") {
                steps {
                    sh "chmod +x gradlew"
                    sh "java -version"
                    sh "./gradlew --version"
                    sh "./gradlew clean"
                    sh "./gradlew compileJava"
            }
        }
        stage("Test") {
                steps {
                    sh "./gradlew test"
            }
        }
        stage("Code Coverage") {
            steps {
                sh "./gradlew jacocoTestReport"
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: false,
                    keepAll: true,
                    reportDir: 'build/reports/jacoco/test/html',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Report'
                ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }
        stage("CheckStyle") {
              steps {
                sh "./gradlew checkstyleMain"
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
        }
    }
}