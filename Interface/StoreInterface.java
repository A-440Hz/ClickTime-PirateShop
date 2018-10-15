public class StoreInterface {

    /**
     * Originally wanted a PQ for speed but realized int[] is the easiest way to display the quantity of multiple
     * copies of the same item. The reason this works so well is that the item id corresponds to the array index.
      */
    private int[] cart = new int[6];

    //These are instantiated up here so total $ saved can be recorded.
    private double dvdSavings = 0, bluraySavings = 0, bulkSavings = 0;


    /**
     * Adds one item to the cart. Preferably implemented on the website by clicking a right arrow.
     */
    public void addItem(int id) {
        cart[id]++;
    }

    /**
     * Removes one item from the cart. Preferably implemented on the website by clicking a left arrow.
     */
    public void rmvItem(int id) {
        Item tempItm = Items.itemSet.get(id);
        if (cart[id] > 0) {
            cart[id]--;
        } else {
            // This message can be avoided while implementing HTML/CSS buttons (I think).
            // The idea is to have the left arrows grayed out when the inventory count is 0.
            System.out.println(tempItm.name + " not in cart.");
        }

    }

    // These methods are redundant but may be useful with future additions.
    public void addItem(Item itm){
        addItem(itm.id);
    }
    public void rmvItem(Item itm) {
        rmvItem(itm.id);
    }

    // returns total items in cart.
    public int totalItems() {
        int items = 0;
        for (int i : cart) {
            items = items + i;
        }
        return items;
    }

    private boolean bulkDiscount() {
        return totalItems() > 99;
    }

    private boolean dvdDiscount() {
        return cart[0] !=0 && cart[1] !=0 && cart[2] != 0;
    }

    private boolean blurayDiscount() {
        return cart[3] !=0 && cart[4] !=0 && cart[5] != 0;
    }

    /**
     * Calculates the total cost by summing DVD, BluRay cost, checking for individual discounts, and then
     * checking for total discount.
     */
    public double totalCost() {
        double costDVD = 0, costBlu = 0, cost = 0;
        for (int i = 0; i < 3; i++) {
            costDVD += cart[i] * Items.itemSet.get(i).price;
        }
        for (int i = 3; i < cart.length; i++) {
            costBlu += cart[i] * Items.itemSet.get(i).price;
        }
        // Customer gets 10% discount for buying all 3 DVDs
        if (dvdDiscount()) {
            double temp = costDVD * 0.9;
            dvdSavings = costDVD - temp;
            costDVD = temp;

        }
        // Customer gets 15% discount for buying all 3 BluRays
        if (blurayDiscount()) {
            double temp = costBlu * 0.85;
            bluraySavings = costBlu - temp;
            costBlu = temp;
        }
        cost = costDVD + costBlu;
        if (bulkDiscount()) {
            double temp = cost * 0.95;
            bulkSavings = cost - temp;
            cost = temp;
        }
        return cost;

    }

    /**
     * Visualization method used purely for the unit tests. Refreshes totalCost().
     */
    public void displayCart() {
        if (cart == null) {
            System.out.println("Your cart is empty.");
        }
        else {
            String s;
            System.out.println("Your cart contains:");
            for (int i = 0; i < cart.length; i++) {
                // This String s plural shenanigan makes me happy but it is slightly slower than having
                // multiple print statements.
                if (cart[i] == 1) {  s = "y";  } else {  s = "ies";  }
                System.out.println(cart[i] + " cop" + s + " of " + Items.itemSet.get(i).name + ".");
            }

            System.out.println("               ...for a total of " + totalItems() + " items.");
            System.out.println("The total price is $" + totalCost());

            if (dvdDiscount()) {
                System.out.println("Congrats! Your DVD discount saved you $" + dvdSavings);
            }
            if (blurayDiscount()) {
                System.out.println("Nice! Your Blu Ray discount saved you $" + bluraySavings);
            }
            if (bulkDiscount()) {
                System.out.println("Sweet! Your Bulk discount saved you $" + bulkSavings);
            }

        }
    }


}
