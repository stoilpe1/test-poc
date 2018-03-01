package com.testPoc.base;

import java.util.UUID;

public class RandomIdGenerator {

    public static String getRandomId(int maxLength) {        
        UUID genuuid = UUID.randomUUID();
        String randomId = genuuid.toString().substring(0, maxLength);
        return randomId;       
    }
}
