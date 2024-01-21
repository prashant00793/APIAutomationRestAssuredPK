package com.apiautomationpk.base;

import com.apiautomationpk.actions.AssertActions;
import com.apiautomationpk.endpoints.APIConstants;
import com.apiautomationpk.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    //Before Running any Method
    //Rest Assured . Given with Base URI and Payload

    public RequestSpecification requestSpecification;
    public AssertActions actions;

    public PayloadManager payloadManager;

    public JsonPath jsonPath;
    public Response response;

    public ValidatableResponse validatableResponse;

    @BeforeMethod
    public void setUp() {
        //Rest Base URLs of the Rest Assured
        //Base URI
        //Content Type - JSON

        payloadManager = new PayloadManager();
        actions = new AssertActions();
//        requestSpecification = RestAssured.given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON);

        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

    }


}


