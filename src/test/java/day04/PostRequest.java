package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Country;
import pojos.CountryPost;
import utilities.GMIBankBaseUrl;

import static io.restassured.RestAssured.given;

public class PostRequest extends GMIBankBaseUrl {
    @Test
    public void test10() {
spec01.pathParam("first","tp-countries");

        CountryPost countryPost= new CountryPost("Batch81");
        System.out.println("countryPost: " + countryPost);

        Response response= given().
                headers("Authorization", "Bearer " + generateToken(),"Content-Type",ContentType.JSON).
                spec(spec01).when().body(countryPost).post("/{first}");

        response.prettyPrint();

        CountryPost actualData= response.as(CountryPost.class);
        System.out.println("actualData :" +actualData);

        Assert.assertEquals(countryPost.getName(), actualData.getName());



    }
}
