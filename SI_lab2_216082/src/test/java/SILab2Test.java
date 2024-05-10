import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SILab2Test {

    @Test
    public void testCheckCart_AllItemsNull() {
        List<Item> allItems = null;
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 100));
    }

    @Test
    public void testCheckCart_EmptyItemList() {
        List<Item> allItems = new ArrayList<>();
        boolean result = SILab2.checkCart(allItems, 100);
        assertTrue(result);
    }

    @Test
    public void testCheckCart_SingleItem_ValidData() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", "12345", 200, 0.1f));
        boolean result = SILab2.checkCart(allItems, 250);
        assertTrue(result);
    }

    @Test
    public void testCheckCart_SingleItem_NullName() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item(null, "12345", 200, 0.1f));
        boolean result = SILab2.checkCart(allItems, 250);
        assertTrue(result);
    }

    @Test
    public void testCheckCart_SingleItem_NullBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", null, 200, 0.1f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 250));
    }

    @Test
    public void testCheckCart_SingleItem_InvalidBarcode() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", "abc", 200, 0.1f));
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems, 250));
    }

    @Test
    public void testCheckCart_SingleItem_Discount() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", "12345", 200, 0.2f));
        boolean result = SILab2.checkCart(allItems, 200);
        assertTrue(result);
    }

    @Test
    public void testCheckCart_SingleItem_PriceGreaterThan300_DiscountGreaterThan0_BarcodeStartsWith0() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", "01234", 400, 0.1f));
        boolean result = SILab2.checkCart(allItems, 350);
        assertTrue(result);
    }

    @Test
    public void testCheckCart_SingleItem_PriceGreaterThan300_DiscountGreaterThan0_BarcodeDoesNotStartWith0() {
        List<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Test", "12345", 400, 0.1f));
        boolean result = SILab2.checkCart(allItems, 350);
        assertTrue(result);
    }
}