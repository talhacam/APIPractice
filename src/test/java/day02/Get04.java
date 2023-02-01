package day02;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get04 {

    /*
    http://dummy.restapiexample.com/api/v1/employees url'ine GET request'i yolladığımda gelen response'un
    status code'unun 200,
    content type'ının "application/json"
    employees sayisinin 24,
    employee'lerden birinin "Ashton Cox",
    gelen yaşlar içinde 21,61 ve 23 degerlerinden birinin oldugunu test eet

     */

    @Test
    public void test04() {
        String url = "http://dummy.restapiexample.com/api/v1/employees";
        Response response = given().when().get(url);

        response.then().assertThat().contentType(ContentType.JSON).statusCode(200);


        response.then().assertThat().body("data", hasSize(24),
                "data.employee_name", hasItem("Ashton Cox"),
                "data.employee_age",hasItems(21,61,23));


    }
}
