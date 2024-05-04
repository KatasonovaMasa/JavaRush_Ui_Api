package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostGeneralInfo {

    public static Response getPostGeneralInfo(){
        return given()
                .spec(Specification.request)
                .when()
                .get("/general/info");
    }
}
