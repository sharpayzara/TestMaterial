package com.example.sharpay.testmaterial.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sharpay on 16-10-25.
 */
public class ValidateUtil {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private static Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private static Matcher matcher;

    public static boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static  boolean validatePassword(String password){
        return password.length() > 5;
    }
}
