package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static help.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;

public class Specification {

    public static RequestSpecification request = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification discussions = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .basePath("/discussions")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification games = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .basePath("/projects")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification internship = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .basePath("/articles")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification users = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .basePath("/users")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static RequestSpecification news = with()
            .baseUri("https://javarush.com/api/1.0/rest")
            .basePath("/news")
            .log().all()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
