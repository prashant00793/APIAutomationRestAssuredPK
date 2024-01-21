package com.apiautomationpk.modules;


import com.apiautomationpk.payloads.request.Auth;
import com.apiautomationpk.payloads.request.Booking;
import com.apiautomationpk.payloads.request.Bookingdates;
import com.apiautomationpk.payloads.response.BookingRespons;
import com.apiautomationpk.utils.FakerUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

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
        booking.setBookingdates(bookingdates);

        String paylaod = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return paylaod;
    }

    public String createPayloadNegative() throws JsonProcessingException {
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
        booking.setBookingdates(bookingdates);

        String paylaod = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return paylaod;
    }

    public BookingRespons JsonToObject(String jsonString) throws IOException {
        objectMapper = new ObjectMapper();
        BookingRespons bookingRespons = objectMapper.readValue(jsonString, BookingRespons.class);
        return bookingRespons;
    }

    public String setToken() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
    }

}

