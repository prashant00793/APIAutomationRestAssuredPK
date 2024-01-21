package com.apiautomationpk.crud;

import com.apiautomationpk.actions.AssertActions;
import com.apiautomationpk.base.BaseTest;
import com.apiautomationpk.endpoints.APIConstants;
import com.apiautomationpk.modules.PayloadManager;
import com.apiautomationpk.payloads.response.BookingRespons;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

public class TC_CreateBooking extends BaseTest {

    @Test(groups = {"qa", "P0"})
    @Owner("Prashant")
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC#01 -Verify that Create Booking works and ID is generated")

    public void testCreateBooking() throws IOException {
        //Call the Request Block
        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON).log().all();

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingRespons bookingRespons = payloadManager.JsonToObject(response.asString());
        assertThat(bookingRespons.getBookingid().toString()).isNotNull().isNotEmpty();


        //Call the payload Block
        //Call the Assertion Block
    }

    @Test(groups = {"qa", "P0"})
    @Owner("Prashant")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#02 -Verify that Create Booking with No Payload")
    public void testCreateBookingNegative() throws IOException {
        //Call the Request Block
        payloadManager = new PayloadManager();
        actions = new AssertActions();
        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON).log().all();

        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body("").post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(500);



        //Call the payload Block
        //Call the Assertion Block
    }


}
