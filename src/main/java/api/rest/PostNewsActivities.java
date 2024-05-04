package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostNewsActivities {

    public static Response getPostNewsActivities(){
        return given()
                .spec(Specification.news)
                .when()
                .get("/");
    }
}
