package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<ReceiptItem> transferToReceiptItem(List<String> barcodes){
        List<ReceiptItem> receiptItems = new ArrayList<>();
        receiptItems.add(new ReceiptItem("Coca-Cola", 0, 3, 0));
        receiptItems.add(new ReceiptItem("Sprite", 0, 3, 0));
        receiptItems.add(new ReceiptItem("Battery", 0, 2, 0));
        for (String barcode : barcodes) {
            ReceiptItem receiptItem = null;
            if(barcode.equalsIgnoreCase("item000000")){
                receiptItem = receiptItems.get(0);
            } else if(barcode.equalsIgnoreCase("item000001")){
                receiptItem = receiptItems.get(1);
            } else if(barcode.equalsIgnoreCase("item000004")){
                receiptItem = receiptItems.get(2);
            }
            receiptItem.setQuantity(receiptItem.getQuantity() + 1);
            receiptItem.setSubtotal(receiptItem.getQuantity() * receiptItem.getUnitPrice());
        }
        return receiptItems;
    }


}
