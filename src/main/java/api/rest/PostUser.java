package api.rest;

import api.specs.Specification;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PostUser {

    public static Response getPostUser(){
        return given()
                .spec(Specification.users)
                .when()
                .get("?filter=ALL");
    }

    public static Response getUserActivities(){
        return  given()
                .spec(Specification.internship)
                .when()
                .get("/articlecom.javarush.article.about.internship");
    }
}
