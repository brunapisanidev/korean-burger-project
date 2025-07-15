
public class Main {
    public static void main(String[] args) {

        //Regular order, where the basic restaurant order is called.
        //Here, there is no change in drink or side size, nor are any extras added.
        MealOrder defaultOrder = new MealOrder("BASE", "COKE","ONIONS");
        defaultOrder.printItemizedList();

        System.out.println("\n" + "===".repeat(10) + "\n");

        //Order without changing the meat type yet, but we changed the drink size to a larger one.
        //You will notice a price difference.
        MealOrder order1 = new MealOrder("BASE","COKE","ONIONS");
        order1.setDrinkSize("LARGE");
        order1.printItemizedList();

        System.out.println("\n" + "===".repeat(10) + "\n");

        //Here is an order where we change the meat type, as well as the sizes of drinks, sides, and add extras.
        MealOrder order2 = new MealOrder("BULGOGI", "COKE","FRIES");
        order2.setMeatType("BULGOGI");
        order2.addBurguerToppings("KIMCHI","MOZZARELLA CHEESE", "GOCHUJANG MAYO");
        order2.setDrinkSize("LARGE");
        order2.setSideSize("SMALL");
        order2.printItemizedList();

    }
}