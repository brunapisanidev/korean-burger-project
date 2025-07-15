import java.sql.SQLOutput;
import java.util.Objects;

public class MealOrder {
    private Burger burger;
    private Item drink;
    private Item side;

    //Instantiates objects of type Burger and Item with default and base values,
    //These values will later be adjusted using the adjustedPrice or extraPrice methods for the extras included in the Hamburger or changes in the sizes of side and/or drink.
    public MealOrder(String burgerType, String drinkType, String sideType) {
    //Removed the burger name here because it will be set dynamically via setMeatType.
        this.burger = new Burger("BASE", "", 4.0);
//        this.burger = new Burger(burgerType, "", 4.0);
        this.drink = new Item("DRINK", drinkType, 1.0);
        this.side = new Item("SIDE",sideType,1.50);
    }
    //Returns the total amount for the entire order. This is very important.
    public double getTotalPrice() {
        return drink.getAdjustedPrice() + side.getAdjustedPrice() +
                burger.getAdjustedPrice();
    }
    //Method to enable switching the drink size.
    public void setDrinkSize(String size) {
        drink.setSize(size);
    }
    public void setSideSize(String size) {
        side.setSize(size);
    }
    //Method to enable switching the meat type.
    public void setMeatType(String type) {
        burger.setType(type);
    }
    //Method that calls the burger's addToppings method to add extras.
    //This creates a higher level of abstraction,
    //keeping the responsibility of managing extras inside the Burger class
    public void addBurguerToppings(String extra1, String extra2, String extra3) {
        burger.addToppings(extra1, extra2, extra3);
    }

    //The remaining details of the receipt are being handled here.
    public void printItemizedList() {
            burger.printItem();
            drink.printItem();
            side.printItem();
            System.out.println("-".repeat(30));
            System.out.printf("TOTAL PRICE: %5.2f%n ", getTotalPrice());
        }
    }


