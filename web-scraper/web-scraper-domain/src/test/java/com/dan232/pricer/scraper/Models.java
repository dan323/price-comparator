package com.dan232.pricer.scraper;

import com.dan232.pricer.scraper.model.BggUrl;
import com.dan232.pricer.scraper.model.WebProductPrice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Random;

public class Models {

    private static final Random RANDOM = new Random();

    static WebProductPrice randomWithEan(String ean, int shopCount) throws URISyntaxException, MalformedURLException {
        return new WebProductPrice(ean,
                "Product #" + RANDOM.nextInt(),
                RANDOM.nextDouble(),
                new URI("https://www.someSite.com").toURL(),
                RANDOM.nextDouble(),
                "SHOP" + shopCount,
                new URI("http://www.someSite.com/image.jpg").toURL(),
                new BggUrl(new URI("http://www.false.com").toURL(), false));
    }

    public static String randomEan() {
        StringBuilder ean = new StringBuilder();
        for (int i = 0; i < 12; i++) {
            ean.append(RANDOM.nextInt(10));
        }
        ean.append(checkDigit(ean));
        return ean.toString();
    }

    private static char checkDigit(final StringBuilder partialEan) {
        var ean = partialEan.toString();
        if (ean.length() != 12) {
            throw new IllegalArgumentException("An EAN number MUST have 13 digits");
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
            return (char) ('0' + ((10 - (sum % 10)) % 10));
        }
    }
}
