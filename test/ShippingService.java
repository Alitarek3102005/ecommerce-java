import java.util.List;

public class ShippingService {
    public static double  calculateShippingCost(Cart cart) {
        double totalWeight = 0.0;
        for (CartThing item : cart.getItems()) {
            if (item.getProduct() instanceof Shippable shippableItem) {
                totalWeight += shippableItem.getWeight() * item.getQuantity();
            }
        }
        return totalWeight * 5.0;
    }
     public static void process(List<Shippable> items) {
        System.out.println("Shipping Items:");
        for (Shippable s : items) {
            System.out.println("- " + s.getName() + " | " + s.getWeight() + "kg");
        }
    }

}
