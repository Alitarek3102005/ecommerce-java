public class MobileCard extends Product {
    public MobileCard(String name, double price, int quantity) {
        super(name, price, quantity);
    }

    @Override
    public boolean isExpired() { 
        return false;
     }
}