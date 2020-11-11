package com.sikiro.om.infrastructure.helper;


import org.springframework.util.DigestUtils;

public class EncodingHelper {

    public static String Md5(String input){
        return DigestUtils.md5DigestAsHex(input.getBytes());
    }
}
