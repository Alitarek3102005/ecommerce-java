import java.util.List;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    public double balance;
    public Customer(String name, String email, String phoneNumber, String address, double balance) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void addBalance(double amount) {
        this.balance += amount;
    }
    public void deductBalance(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance.");
        }
    }
    public void chekout(Cart cart){
        if(cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Please add items to your cart before checking out.");
            return;
        }
        
        double subtotalPrice = cart.getSubTotalPrice();
        double shippingCost =0.0;
        if (!cart.getShippableItems().isEmpty()) {
            ShippingService shippingService = new ShippingService();
            shippingCost = shippingService.calculateShippingCost(cart);
        }
        double totalAmount = subtotalPrice + shippingCost;
        
        if (this.balance >= totalAmount) {
            // this.deductBalance(totalAmount);
            cart.editBalance(this);
            System.out.println("Checkout successful! Your new balance is: " + this.balance);
        } else {
            System.out.println("Insufficient balance for checkout. Please add funds to your account.");
            return;
        }
        System.out.println("=== Checkout ===");
        System.out.println("Subtotal: $" + subtotalPrice);
        System.out.println("Shipping: $" + shippingCost);
        System.out.println("Total Paid: $" + totalAmount);
        System.out.println("Remaining Balance: $" + this.balance);
        List<Shippable> shippingItems = cart.getShippableItems();
        if (!shippingItems.isEmpty()) {
            ShippingService.process(shippingItems);
        }
    }


    }

