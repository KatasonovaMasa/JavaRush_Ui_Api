package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostService {
    public static Response getPostCount(String filter){
        return given()
                .spec(Specification.request)
                .queryParam("filter", filter)
                .when()
                .get("posts/count");
    }
}
