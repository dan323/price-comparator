package com.dan232.pricer.scraper;

public class EANUtil {

    public static boolean validateEAN13(String EAN) {
        if (EAN.length() != 13) {
            return false;
        } else {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                sum += (EAN.charAt(i) - '0') * ((i % 2) * 2 + 1);
            }
            return EAN.charAt(12) == '0' + ((10 - (sum % 10)) % 10);
        }
    }

}
