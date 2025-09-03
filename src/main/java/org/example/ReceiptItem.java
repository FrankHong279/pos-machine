package org.example;

/**
 * @author HONGFR
 * @version 1.0
 * @date 9/3/2025 9:09 PM
 */
public class ReceiptItem {
    private String name;
    private Integer quantity;
    private Integer unitPrice;
    private Integer subtotal;
    public ReceiptItem(String name, Integer quantity, Integer unitPrice, Integer subtotal) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }
}
