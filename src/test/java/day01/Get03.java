package day01;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get03 {
    @Test
    public void test03() {

    /*
    Matchers ile dataları doğrula

  "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"

     */


        String url = "https://reqres.in/api/users";
        Response response = given().when().get(url);

        response.then().body("data[4].email",equalTo("charles.morris@reqres.in"),
                "data[4].first_name",equalTo("Charles"),
                "data[4].last_name", equalTo("Morris"),
                "data[4].avatar",equalTo("https://reqres.in/img/faces/5-image.jpg"));

    }
}