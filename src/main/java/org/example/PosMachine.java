package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HONGFR
 * @version 1.0
 * @date 9/3/2025 8:07 PM
 */
public class PosMachine {
    public static void main(String[] args) {
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");
    }

    public static boolean checkBarCode(List<String> barcodes) {
        for (String barcode : barcodes) {
            if (barcode.equalsIgnoreCase("item000000")
                    || barcode.equalsIgnoreCase("item000001")
                    || barcode.equalsIgnoreCase("item000004")){
                continue;
            }
            return false;
        }
        return true;
    }
}
