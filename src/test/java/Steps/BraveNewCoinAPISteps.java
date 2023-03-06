package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BraveNewCoinAPISteps {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;

    @Given("I have a valid API Key for the {string} URI")
    public void iSetTheRequestParams(String URI) {
        request = request.given()
                .header("X-RapidAPI-Key", "")
                .header("X-RapidAPI-Host", "")
                .contentType(ContentType.JSON)
                .baseUri(URI)
                .log().all();
    }

    @When("I send a POST request with a valid body to the {string} endpoint")
    public void sendPOSTRequest(String arg0) {
    }


    @Then("I can validate I receive a valid token in the response")
    public void iCanValidateIReceiveAValidTokenInTheResponse() {
    }


    @Given("I have an invalid API key for the {string} URI")
    public void iHaveAnInvalidAPIKeyForTheURI(String arg0) {
        
    }

    @Then("I receive an HTTP Code Status {string}")
    public void iReceiveAnHTTPCodeStatus(String arg0) {
    }

    @When("I send a POST request without {string} in it's body")
    public void iSendAPOSTRequestWithoutInItSBody(String arg0) {
    }
}
