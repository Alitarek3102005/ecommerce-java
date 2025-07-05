import java.util.*;
public class Cart {
    private List<CartThing> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(CartThing item,int quantity) {
        if(quantity>item.getProduct().getQuantity()) {
            System.out.println("Not enough stock for " + item.getProduct().getName() + ". Available quantity: " + item.getProduct().getQuantity());
            return;
        }
        items.add(new CartThing(item.getProduct(), quantity));
    }

    public void removeItem(CartThing item) {
        items.remove(item);
    }

    public List<CartThing> getItems() {
        return items;
    }

    public double getSubTotalPrice() {
        double total = 0.0;
        for (CartThing item : items) {
            total += item.getSubTotalPrice();
        }
        return total;
    }
    
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Items in your cart:");
            for (CartThing item : items) {
                System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity() + ", Price: " + item.getProduct().getPrice() + ", Total: " + item.getSubTotalPrice());
            }
            System.out.println("Total Price: " + getSubTotalPrice());
        }
    }
    public void editBalance(Customer customer) {
        double totalPrice = getSubTotalPrice()+ ShippingService.calculateShippingCost(this);
        if (customer.getBalance() >= totalPrice) {
            customer.deductBalance(totalPrice);
            System.out.println("Purchase successful! Your new balance is: " + customer.getBalance());
            items.clear();
        } else {
            System.out.println("Insufficient balance. Please add funds to your account.");
        }
    }
    public List<Shippable> getShippableItems() {
        List<Shippable> shippableItems = new ArrayList<>();
        for (CartThing item : items) {
            if (item.getProduct() instanceof Shippable shippableItem) {
                shippableItems.add(shippableItem);
            }
        }
        return shippableItems;
    }
    
}
