package steps;

import config.Endpoints;
import io.cucumber.java.BeforeAll;
import io.restassured.RestAssured;

public class SetUp {

    @BeforeAll
    public static void setupBaseUri() {
        RestAssured.baseURI = Endpoints.PAGE_URL;
    }
}