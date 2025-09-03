package org.example;

/**
 * @author HONGFR
 * @version 1.0
 * @date 9/3/2025 8:40 PM
 */
public class Item {
    // barcode, name , price
    private String barcode;
    private String name;
    private Integer price;

    public Item(String barcode, String name, Integer price) {
        this.barcode = barcode;
        this.name = name;
        this.price = price;
    }

    public String getBarcode() {
        return barcode;
    }
    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}
