package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostDiscussions {

    public static Response getPostDiscussions(){
        return given()
                .spec(Specification.users)
                .when()
                .get("/");
    }
}
