public class ECommerce {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 10, 0.2, "2025-09-01");
        Biscuits biscuits = new Biscuits("Biscuits", 150, 5, "2025-10-01");
        MobileCard scratchCard = new MobileCard("Scratch Card", 50, 10);
        Customer customer = new Customer("Ali", "ali@example.com", "01012345678", "Cairo", 1000);
        Cart cart = new Cart();
        cart.addItem(new CartThing(cheese, 2), 2);
        cart.addItem(new CartThing(biscuits, 1), 1);
        cart.addItem(new CartThing(scratchCard, 1), 1);  
        customer.chekout(cart);
        System.out.println("END.");
    }
}
