package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class PosMachineTest {

    @Test
    public void should_return_receipt_when_given_valid_barcodes() {
        // Given
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000000");
        barcodes.add("ITEM000001");
        barcodes.add("ITEM000004");

        String expected = "***<store earning no money>Receipt ***\n" +
                "Name: Coca-Cola, Quantity: 2, Unit price: 3 (yuan), Subtotal: 6 (yuan)\n" +
                "Name: Sprite, Quantity: 1, Unit price: 3 (yuan), Subtotal: 3 (yuan)\n" +
                "Name: Battery, Quantity: 1, Unit price: 2 (yuan), Subtotal: 2 (yuan)\n" +
                "----------------------\n" +
                "Total: 11 (yuan)\n" +
                "**********************";

        // When
        String actual = PosMachine.getReceiptFormBarcodes(barcodes);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_receipt_with_single_item_when_given_single_barcode() {
        // Given
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000000");

        String expected = "***<store earning no money>Receipt ***\n" +
                "Name: Coca-Cola, Quantity: 1, Unit price: 3 (yuan), Subtotal: 3 (yuan)\n" +
                "----------------------\n" +
                "Total: 3 (yuan)\n" +
                "**********************";

        // When
        String actual = PosMachine.getReceiptFormBarcodes(barcodes);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void should_throw_exception_when_given_invalid_barcode() {
        // Given
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000000");
        barcodes.add("INVALID_BARCODE");

        // When & Then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> PosMachine.getReceiptFormBarcodes(barcodes)
        );
        assertEquals("Barcodes are not valid", exception.getMessage());
    }

    @Test
    public void should_throw_exception_when_given_empty_list() {
        // Given
        List<String> barcodes = new ArrayList<>();

        String expected = "***<store earning no money>Receipt ***\n" +
                "----------------------\n" +
                "Total: 0 (yuan)\n" +
                "**********************";

        // When
        String actual = PosMachine.getReceiptFormBarcodes(barcodes);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void should_handle_case_insensitive_barcodes() {
        // Given
        List<String> barcodes = new ArrayList<>();
        barcodes.add("item000000");
        barcodes.add("ITEM000001");
        barcodes.add("Item000004");

        String expected = "***<store earning no money>Receipt ***\n" +
                "Name: Coca-Cola, Quantity: 1, Unit price: 3 (yuan), Subtotal: 3 (yuan)\n" +
                "Name: Sprite, Quantity: 1, Unit price: 3 (yuan), Subtotal: 3 (yuan)\n" +
                "Name: Battery, Quantity: 1, Unit price: 2 (yuan), Subtotal: 2 (yuan)\n" +
                "----------------------\n" +
                "Total: 8 (yuan)\n" +
                "**********************";

        // When
        String actual = PosMachine.getReceiptFormBarcodes(barcodes);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void should_return_receipt_with_multiple_same_items() {
        // Given
        List<String> barcodes = new ArrayList<>();
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");
        barcodes.add("ITEM000004");

        String expected = "***<store earning no money>Receipt ***\n" +
                "Name: Battery, Quantity: 5, Unit price: 2 (yuan), Subtotal: 10 (yuan)\n" +
                "----------------------\n" +
                "Total: 10 (yuan)\n" +
                "**********************";

        // When
        String actual = PosMachine.getReceiptFormBarcodes(barcodes);

        // Then
        assertEquals(expected, actual);
    }
}

