package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostGames {

    public static Response getPostGames(){
        return given()
                .spec(Specification.games)
                .when()
                .get("/");
    }
}
