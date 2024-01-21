package com.apiautomationpk.DDT;

import com.apiautomationpk.utils.UtilExcel;
import org.testng.annotations.Test;

public class LoginWithDDT {

    @Test(dataProvider = "getData", dataProviderClass = UtilExcel.class)
    public void testLoginData(String username, String password){
        System.out.println("Username__" + username);
        System.out.println("Password__" + password);

        //Rest Assured Code
    }
}
