package day01;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Get01 {

    @Test
    public void test01() {

        String url= "http://restful-booker.herokuapp.com/booking";


        Response response= given().when().get(url);  //Request created to send end point.

        //response.prettyPrint();  //Response'daki body'i yazdırır.

        //response.prettyPeek();   // Response'daki her şeyi yazdırır.

        //response.peek();

       // response.print();  // String olarak datayı verir.
        // [{"bookingid":5219},{"bookingid":4288},{"bookingid":926},{"bookingid":5375},

        System.out.println(response.statusCode());
        System.out.println(response.statusLine());
        System.out.println(response.contentType());


        //Junit Assertleri ile API testi yapılabilir.
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.statusLine());
        Assert.assertEquals("application/json; charset=utf-8",response.contentType());

        //assertThat ile
        response.then().assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");



    }
}
