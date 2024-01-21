package com.apiautomationpk.crud;

import com.apiautomationpk.base.BaseTest;
import com.apiautomationpk.endpoints.APIConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class TC_Integration extends BaseTest {
    //Get a Token - POST
    //Create booking
    //Update the Booking with Token and Booking ID - How to pass varible from one test to another
    // Auth - API Key
    //Cookie Based Auth
    //OAuth 2.0
    //DELETE

    //Get a Token - Extract Token


    String token;

    @Test(groups = "P0")
    public void testCreateBooking() throws JsonProcessingException {
        token = getToken();
        System.out.println(token);
    }

    @Test(groups = "P0", dependsOnMethods = {"testCreateBooking"})
    public void testCreateAndUpdateBooking() {
        System.out.println("testCreateAndUpdateBooking" + token);
        assertThat("Prashant").isEqualTo("Prashant");

    }

    @Test(groups = "P0", dependsOnMethods = {"testCreateAndUpdateBooking"})
    public void testDeleteCreatedBooking() {
        System.out.println("testDeleteCreatedBooking" + token);

        assertThat("Prashant").isEqualTo("Prashant");

    }

}
