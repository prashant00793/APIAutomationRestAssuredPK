package com.apiautomationpk.modules;


import com.apiautomationpk.payloads.request.Booking;
import com.apiautomationpk.payloads.request.Bookingdates;
import com.apiautomationpk.utils.FakerUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadManager {
    //Java - JSON so that we can give it to .Body method

    ObjectMapper objectMapper;

    public String createPayload() throws JsonProcessingException {
    objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setFirstname(FakerUtil.getUserName());
        booking.setLastname("Kumar");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("BreakFast");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2022-01-01");
        bookingdates.setCheckout("2022-01-10");

        String paylod = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return paylod;
    }

}

