package acceptance;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepsDefinition {
    private double a;
    private double b;
    private double result;
    String server = "http://localhost:8081/compute";

    RestTemplate restTemplate = new RestTemplate();

    @Given("I have two numbers: {double} and {double}")
    public void iHaveTwoNumbersAnd(double a, double b) {
        this.a =a;
        this.b =b;
    }

    @When("the calculator sums them")
    public void theCalculatorSumsThem() {
        String url = String.format("%s/sum?a=%s&b=%s", server, a, b);
       result = restTemplate.getForObject(url, Double.class);
    }

    @Then("I receive {double} as a result")
    public void iReceiveAsAResult(double expectedResult) {
        assertEquals(expectedResult, result);
    }
}

