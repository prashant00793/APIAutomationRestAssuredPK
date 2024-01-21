package com.apiautomationpk.crud;

import com.apiautomationpk.base.BaseTest;
import com.apiautomationpk.endpoints.APIConstants;
import com.apiautomationpk.payloads.request.Booking;
import com.apiautomationpk.payloads.response.BookingRespons;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

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
    String bookingid;
    String bookingPojo;



    @Test(groups = "P0")
    public void testCreateBooking() throws IOException {
        token = getToken();
        assertThat(token).isNotNull().isNotEmpty();

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        jsonPath = jsonPath.from(response.asString());
        validatableResponse.statusCode(200);
        bookingid = jsonPath.getString("bookingid");
        System.out.println("Booking ID " + jsonPath.getString("bookingid"));

        assertThat(bookingid).isNotNull().isNotEmpty();

    }

    @Test(groups = "P0", dependsOnMethods = {"testCreateBooking"})
    public void testCreateAndUpdateBooking() throws IOException {
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" + bookingid);
        response = RestAssured.given().spec(requestSpecification).cookie("token", token)
                .when().body(payloadManager.updatePayload()).put();
        validatableResponse = response.then().log().all();
        //validatableResponse.body("lastname", Matchers.is("Mishra"));
        Booking bookingRespons = payloadManager.JsonToObjectPUT(response.asString());
        assertThat(bookingRespons.getLastname()).isEqualTo("Mishra").isNotEmpty().isNotNull();
        assertThat(bookingRespons.getFirstname()).isNotNull();
        assertThat(bookingRespons.getDepositpaid()).isNotNull();
        assertThat(bookingRespons.getBookingdates()).isNotNull();
        assertThat(bookingRespons.getTotalprice()).isNotNull();

    }

    @Test(groups = "P0", dependsOnMethods = {"testCreateAndUpdateBooking"})
    public void testDeleteCreatedBooking() {
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" + bookingid).cookie("token", token);
        ValidatableResponse validatableResponse = RestAssured.given().spec(requestSpecification).auth().basic("admin", "password123")
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);


    }

    @Test(groups = "P0", dependsOnMethods = {"testDeleteCreatedBooking"})
    public void testDeletedBookingByGet() {

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" + bookingid);
        response = RestAssured.given().spec(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(404);

    }

}
