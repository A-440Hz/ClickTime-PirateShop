import java.util.HashMap;
import java.util.Map;

public class Items {
    // Below are all the available items. The ID's are arbitrary but should not be a problem.
    protected static final Item epIV = new Item("Star Wars Episode IV DVD", 20, 0);
    protected static final Item epV = new Item("Star Wars Episode V DVD", 20, 1);
    protected static final Item epVI = new Item("Star Wars Episode VI DVD", 20, 2);
    protected static final Item epIVBr = new Item("Star Wars Episode IV Blu Ray", 25, 3);
    protected static final Item epVBr = new Item("Star Wars Episode V Blu Ray", 25, 4);
    protected static final Item epVIBr = new Item("Star Wars Episode VI Blu Ray", 25, 5);

    // A map will allow easy referencing in StoreInterface.java by matching Item id to Item.
    protected static final Map<Integer, Item> itemSet = makeMap();

    /**
     * Implementation found from https://stackoverflow.com/questions/507602/.
     * Each new item will have to be added to the function below.
     */
    private static Map<Integer, Item> makeMap() {
        Map<Integer, Item> mp = new HashMap<>();
        mp.put(epIV.id, epIV);
        mp.put(epV.id, epV);
        mp.put(epVI.id, epVI);
        mp.put(epIVBr.id, epIVBr);
        mp.put(epVBr.id, epVBr);
        mp.put(epVIBr.id, epVIBr);
        return mp;
    }
}
