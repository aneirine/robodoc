package com.example.robodoc.utils;

public class UtilMethods {

    public String createNominal(String str) {
        String nominal = "";
        char[] array = str.toCharArray();
        for (Character temp : array) {
            if (temp == '(') break;
            else nominal+= temp;
        }

        return nominal.trim();
    }
}
