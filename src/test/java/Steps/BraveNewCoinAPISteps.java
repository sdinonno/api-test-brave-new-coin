package Steps;

import helpers.JsonHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.core.IsEqual.equalTo;

public class BraveNewCoinAPISteps {
    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;
    private String payloadsFolder = "src/test/resources/Payloads/";

    @Given("I have a valid API Key for the {string} URI")
    public void iSetTheRequestParams(String uri) {
        request = request.given()
                .header("X-RapidAPI-Key", "")
                .header("X-RapidAPI-Host", "")
                .contentType(ContentType.JSON)
                .baseUri(uri)
                .log().all();
    }

    @When("I send a POST request with a valid {string} payload to the {string} endpoint")
    public void sendPOSTRequest(String payload, String endpoint) {
        File requestBody = new File( payloadsFolder + payload +".json");
        response = request.when()
                .body(requestBody)
                .post(endpoint)
                .prettyPeek();
    }


    @Then("I can validate I receive a valid token in the response")
    public void iGetAValidToken() throws IOException, ParseException {
        String myToken = JsonHelper.getProperty(
                new File(payloadsFolder+"MyValidToken.json"),
                "access_token");

        response.then()
                .assertThat().statusCode(200)
                .body("access_token", equalTo(myToken));
    }


    @Given("I have an invalid API key for the {string} URI")
    public void iHaveAnInvalidAPIKeyForTheURI(String uri) {
        request = request.given()
                .header("X-RapidAPI-Key", "")
                .header("X-RapidAPI-Host", "")
                .contentType(ContentType.JSON)
                .baseUri(uri)
                .log().all();
    }

    @Then("I receive an HTTP Code Status {string}")
    public void iReceiveAnHTTPCodeStatus(String statusCode) {
        response.then()
                .assertThat()
                .statusCode(Integer.parseInt(statusCode));
    }

    @When("I send a POST request without {string} in it's body to the {string} endpoint")
    public void iSendAPOSTRequestWithoutInItSBodyToTheEndpoint(String arg0, String endpoint) {

    }
}
