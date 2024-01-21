package com.apiautomationpk.endpoints;

import com.apiautomationpk.utils.PropertyReaderUtil;

public class APIConstants {

    //public static String BASE_URL= FillowUtils.fetchDataFromXLSX("Sheet1","BaseUrl","Value" );

    public static String BASE_URL;

    static {
        try {
            BASE_URL = PropertyReaderUtil.readkey("url");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public static String CREATE_BOOKING = "/booking";
    public static String UPDATE_BOOKING = "/booking";


}
