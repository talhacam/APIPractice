package day01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get02 {
    @Test
    public void test02() {

        String url = "http://reqres.in/api/users";
        Response response = given().when().get(url);

        //Header Test
        response.then().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").contentType(ContentType.JSON);


        //Body Test

        /*
        idsi 1 olanın datalarının aşağıdaki gibi olduğunu test ediniz.

        "email": "george.bluth@reqres.in",
            "first_name": "George",
            "last_name": "Bluth",
         */


        //Matcher Class ile
        response.then().body("data[0].email", equalTo("george.bluth@reqres.in"),
                "data[0].first_name",equalTo("George"),
                "data[0].last_name",equalTo("Bluth"));



    }
}
