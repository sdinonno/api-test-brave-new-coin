Feature: BraveNewCoin API scenarios.

  Rule: When I send a POST request to the endpoint, I receive a token I can use to make further authentication calls.

    Scenario: As a user, I can retrieve a token when making a valid POST request
      Given I have a valid API Key for the "<uri>" URI
      When I send a POST request with a valid body to the "endpoint" endpoint
      Then I can validate I receive a valid token in the response

    Scenario: As a user, when I use an invalid API key, I get an HTTP Code Status 403
      Given I have an invalid API key for the "<uri>" URI
      When I send a POST request with a valid body to the "endpoint" endpoint
      Then I receive an HTTP Code Status "codeStatus"

    Scenario: As a user, when I send the POST request without "gran_type", I get an HTTP Code Status 400
      Given I have a valid API Key for the "<uri>" URI
      When I send a POST request without "grant_type" in it's body
      Then I receive an HTTP Code Status "codeStatus"
