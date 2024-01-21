package com.apiautomationpk.utils;

import com.github.javafaker.Faker;

public class FakerUtil {

    static Faker faker = new Faker();

    public static String getUserName() {


        String name = faker.name().fullName(); // Miss Samanta Schmidt
        return name;
    }
}
