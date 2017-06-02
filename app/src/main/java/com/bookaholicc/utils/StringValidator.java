package com.bookaholicc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nandhu on 17/10/16.
 */

public class StringValidator {
    public static boolean  CheckUserName(String mUserName){
        if (mUserName.length()<5){
            return false;

        }
        if (mUserName.isEmpty()){
            return false;
        }

        return true;
    }

    public static boolean checkPassword(String mUserPassword){
        if (mUserPassword.length()< 6){
            return false;
        }
        if (mUserPassword.isEmpty()){
            return false;
        }

        return true;
    }


    public static boolean checkeEMail(String eMailEnterred) {
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(eMailEnterred);
        if (matcher.matches()){
            return true;
        }
        return false;
    }

    public static boolean checkPhoneNumber(String phone) {
        String regexStr = "^[0-9]{10}$";
        return phone.matches(regexStr);
    }
}
