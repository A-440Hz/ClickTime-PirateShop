import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoreTest {

    @Test
    private static void testMultipleItems() {
        StoreInterface si = new StoreInterface();
        System.out.println("Adding 10 DVDs of Empire Strikes Back...");
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.addItem(1);
        si.displayCart();
        System.out.println("Now we replace 2 of them with Blu Ray versions...");
        si.rmvItem(1);
        si.rmvItem(Items.epV);
        si.addItem(Items.epVBr);
        si.addItem(Items.epVBr);
        si.displayCart();
        System.out.println(" ");
        Assertions.assertEquals(10, si.totalItems());
    }

    @Test
    private static void testEmptyCart() {
        System.out.println("The total items and cost of an empty cart should be 0.");
        StoreInterface ec = new StoreInterface();
        ec.displayCart();
        System.out.println(" ");
        Assertions.assertEquals(0, ec.totalItems());
        Assertions.assertEquals(0, ec.totalCost());
    }

    @Test
    private static void testBulk() {
        System.out.println("Buying 100 Episode 4 DVDs should cost $1900. What a deal!");
        StoreInterface bk = new StoreInterface();
        for (int i = 0; i < 100; i++) {
            bk.addItem(0);
        }
        bk.displayCart();
        System.out.println(" ");
        Assertions.assertEquals(1900, bk.totalCost());
    }

    @Test
    private static void testAllDiscounts() {
        System.out.println("20 of each item should total up to $2237.25");
        StoreInterface ad = new StoreInterface();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 6; j++) {
                ad.addItem(j);
            }
        }
        ad.displayCart();
        System.out.println(" ");
        Assertions.assertEquals(2237.25, ad.totalCost());
    }

    public static void main(String[] args) {
        testMultipleItems();
        testEmptyCart();
        testBulk();
        testAllDiscounts();
    }

}
