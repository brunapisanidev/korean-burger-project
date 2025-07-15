public class Extra extends Item {

    public Extra(String type, String name, double price) {
        super(type, name, price);
    }
    //Method to return the price of an Extra.
    //We created a dedicated Extra class to centralize the management of available extras.
    public static double getExtraPrice(String extraName) {
        return switch (extraName) {
            case "GOCHUJANG MAYO", "MOZZARELLA CHEESE" -> 1.0;
            case "BACON", "GANJANG YANGPA BOKKEUM", "KIMCHI" -> 1.5;
            case "OI MUCHIM", "YANGSANGCHU" -> 2.0;
            default -> 0.0;
        };
    }
    @Override
    public double getAdjustedPrice() {
        return super.getBasePrice();
    }

    @Override
    public String getName() {
        return super.getName() + ":";
    }

    //Method to ensure that no one tries to assign a size to extras.
    @Override
    public void setSize(String size) {
        throw new UnsupportedOperationException("Extras doesn't have size!");
    }

    @Override
    public void printItem() {
        System.out.printf("%-20s %6.2f%n", getName(), getAdjustedPrice());
    }
}
