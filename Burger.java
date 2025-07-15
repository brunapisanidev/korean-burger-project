import java.util.Objects;

public class Burger extends Item {
    private Extra extra1;
    private Extra extra2;
    private Extra extra3;


    public Burger(String type, String name, double price) {
        super(type, name, price);
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public void setSize(String size) {
        throw new UnsupportedOperationException("Extras doesn't have size!");
    }

    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }

    //Method that instantiates Extras objects.
    //This allows the caller to simply pass the names of the extras as Strings,
    //without needing to create Extra objects manually in the main code.
    //The method handles object creation and price assignment internally,
    //keeping the main code cleaner and reducing the chance of errors.
    public void addToppings(String extra1, String extra2, String extra3) {
        this.extra1 = new Extra("TOPPING", extra1, Extra.getExtraPrice(extra1));
        this.extra2 = new Extra("TOPPING", extra2, Extra.getExtraPrice(extra2));
        this.extra3 = new Extra("TOPPING", extra3, Extra.getExtraPrice(extra3));
    }

    //Following the Single Responsibility Principle (SRP), we isolated the upgrade price logic
    //into its own method to improve readability, maintainability, and scalability of the code.
    public double getUpgradePrice() {
          double upgradePrice = switch (getType().toUpperCase()) {
            case "BULGOGI" -> 2.0;
            case "VEGGIE" -> 3.0;
            default -> 0.0;
        };
        return upgradePrice;
    }


    //Overrides and customizes the method that returns the adjusted price.
    //Adds an extra fee if the type of meat is changed.
    @Override
    public double getAdjustedPrice() {
        double extraPrice = ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
                ((extra2 == null) ? 0 : extra2.getAdjustedPrice()) +
                ((extra3 == null) ? 0 : extra3.getAdjustedPrice());

    //Returns the adjusted price based on the type of meat.
    //If the meat is regular/default, the method of upgradePrice will be 0 and will not impact the final calculation.
        return getBasePrice() + getUpgradePrice() + extraPrice;
    }



    // Overrides the getName method from Item to append "BURGER" to the name.
    @Override
    public String getName() {
        return super.getName() + " BURGER";
    }

    //Overrides and customizes the method. This is part of the receipt.
    //The "BASE BURGER" is always printed.
    //If the burger type is changed via the setter (e.g., to "BULGOGI"),
    //it will also print the corresponding upgrade price.
    //Otherwise, only the "BASE BURGER" is shown, without any upgrade.
    @Override
    public void printItem() {
        System.out.printf("%-20s %6.2f%n", "BASE BURGER:", getBasePrice());

        if (!"BASE".equals(getType())) {
            System.out.printf("%-20s %6.2f%n", "+ " + getType() + " UPGRADE:", getUpgradePrice());
        }
        System.out.println("-".repeat(30));

        //If the user doesn't specify an extra, it will be null and won't be printed to the console.
        if (extra1 != null) {
            extra1.printItem();
        }
        if (extra2 != null) {
            extra2.printItem();
        }
        if (extra3 != null) {
            extra3.printItem();
        }
    }
}



