public class Cheese extends ExpirableProducts implements Shippable {
    private double weight;

    public Cheese(String name, double price, int quantity, double weight, String expirationDate) {
        super(name, price, quantity, expirationDate);
        this.weight = weight;
    }
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public double getWeight() {
        return weight;
    }
    
}
