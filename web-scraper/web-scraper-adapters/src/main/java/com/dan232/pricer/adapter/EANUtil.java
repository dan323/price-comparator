// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter;

public final class EANUtil {

    private EANUtil() {
        throw new UnsupportedOperationException("Cannot be instanced");
    }

    /**
     * Validate that the given string is an EAN number.
     *
     * @param ean EAN number
     * @return true iff the number provided satisfies the EAN control
     */
    public static boolean validateEAN13(final String ean) {
        if (ean.length() != 13) {
            return false;
        } else {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                // Sum the value of odd entries
                // (except the last one) and 3 times
                // the value of even entries
                sum += (ean.charAt(i) - '0') * ((i % 2) * 2 + 1);
            }
            // The last digit correspond to the
            // additive inverse of the computed sum MOD 10
            return ean.charAt(12) == '0' + ((10 - (sum % 10)) % 10);
        }
    }

}
