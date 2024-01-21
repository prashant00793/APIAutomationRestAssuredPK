package com.apiautomationpk.crud;

import com.apiautomationpk.base.BaseTest;
import com.apiautomationpk.endpoints.APIConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_CreateBooking extends BaseTest {

    @Test(groups = {"qa", "P0"})
    @Owner("Prashant")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that Create Booking works and ID is generated")

    public void testCreateBooking() throws JsonProcessingException {
        //Call the Request Block
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        response = requestSpecification.when().body(payloadManager.createPayload()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        jsonPath = JsonPath.from(response.asString());
        String bookingID = jsonPath.getString("bookingid");
        assertThat.from

        //Call the payload Block
        //Call the Assertion Block
    }

//    @Test
//    public void testCreateBooking_Postive() {
//        //Call the Request Block
//        //Call the payload Block
//        //Call the Assertion Block
//    }




}
