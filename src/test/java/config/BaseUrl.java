package config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

@Deprecated
public abstract class BaseUrl {

    @BeforeAll
    static void setUpBaseUri() {
        RestAssured.baseURI = Endpoints.PAGE_URL;
    }
}
