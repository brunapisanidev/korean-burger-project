public class Item {

    private String name;
    //definimos size como Medium, isso vai significar que quando a bebida não for trocada, a bebida saí de "graça"
    private String size = "MEDIUM";
    private double price;
    private String type;

    public Item(String type, String name, double price) {
       this.type = type;
        this.name = name;
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public double getBasePrice() {
        return price;
    }

    //Method to return the price of side & drinks based on the size.
    public double getAdjustedPrice() {
        return switch (size) {
            case "SMALL" -> getBasePrice() - 0.50;
            case "LARGE" -> getBasePrice() + 1.00;
            default -> getBasePrice();
        };
    }
    //Returns the formatted name differently for drinks or sides.
    //If it's a hamburger, it returns only the name without formatting.
    public String getName() {
        if (type.equals("SIDE") || type.equals("DRINK")) {
            return size + " " + name + ":";
        }
        return name;
    }

    public void printItem() {
        System.out.printf("%-20s %6.2f%n", getName(), getAdjustedPrice());
    }
}





