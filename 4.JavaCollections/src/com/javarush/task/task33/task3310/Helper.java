package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by k-terra on 29.05.2019.
 */
public class Helper {
    public static String generateRandomString(){
        return new BigInteger(130, new SecureRandom()).toString(36);
    }
    public static void printMessage(String message){
        System.out.println(message);
    }
}
