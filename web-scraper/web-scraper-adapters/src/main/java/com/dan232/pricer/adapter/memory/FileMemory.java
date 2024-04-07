// Copyright (c) 2024 Daniel de la Concepción Sáez
package com.dan232.pricer.adapter.memory;

import com.dan232.pricer.scraper.SavePort;
import com.dan232.pricer.scraper.model.WebProductPrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.function.Function;

/**
 * Implementation of {@link SavePort} to save data in memory.
 * FIXME: To be used only during development
 */
public class FileMemory implements SavePort {

    private static final String PRODUCT_CSV = "/web-scraper/"
            + "web-scraper-adapters/"
            + "src/main/resources/product.csv";
    private static final String PRODUCT_IN_SHOP_CSV = "/web-scraper/"
            + "web-scraper-adapters/"
            + "src/main/resources/productInShop.csv";
    private static final String COMMA_DELIMITER = ",";

    /**
     * Save product to files.
     * @param webProductPrice model to save
     * @throws IOException in case it cannot access the file
     */
    @Override
    public void save(final WebProductPrice webProductPrice) throws IOException {
        if (!isInProduct(webProductPrice.EAN())) {
            saveInProduct(webProductPrice);
        }
        if (!isInProductInShop(webProductPrice.EAN())) {
            saveInProductInShop(webProductPrice);
        }
    }

    private void saveInProductInShop(final WebProductPrice webProductPrice)
            throws IOException {
        saveInCSV(webProductPrice,
                PRODUCT_IN_SHOP_CSV,
                this::toCSVProductInShop);
    }

    private String toCSVProductInShop(final WebProductPrice webProductPrice) {
        return webProductPrice.EAN() + ","
                + webProductPrice.price() + ","
                + webProductPrice.sendPrice() + ","
                + webProductPrice.shopName() + ","
                + webProductPrice.homeSite().toString()
                + System.lineSeparator();
    }

    private void saveInProduct(final WebProductPrice webProductPrice)
            throws IOException {
        saveInCSV(webProductPrice, PRODUCT_CSV, this::toCSVProduct);
    }

    private void saveInCSV(final WebProductPrice webProductPrice,
                           final String fileName,
                           final Function<WebProductPrice, String> toCSV)
            throws IOException {
        Files.writeString(
                Paths.get(fileName),
                toCSV.apply(webProductPrice),
                StandardOpenOption.APPEND);
    }

    private String toCSVProduct(final WebProductPrice webProductPrice) {
        return webProductPrice.EAN() + ","
                + webProductPrice.productName()
                + System.lineSeparator();
    }


    private boolean isInProductInShop(final String ean)
            throws IOException {
        return isInCSVFile(ean, PRODUCT_IN_SHOP_CSV);
    }

    private boolean isInProduct(final String ean)
            throws IOException {
        return isInCSVFile(ean, PRODUCT_CSV);
    }


    private boolean isInCSVFile(final String ean, final String fileName)
            throws IOException {
        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null && !found) {
                String[] values = line.split(COMMA_DELIMITER);
                if (values[0].equals(ean)) {
                    found = true;
                }
            }
        }
        return found;
    }
}
