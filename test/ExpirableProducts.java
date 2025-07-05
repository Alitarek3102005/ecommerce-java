public class ExpirableProducts extends Product  {
    private String expirationDate;

    public ExpirableProducts(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

     @Override
    public boolean isExpired() {
        if (getExpirationDate() == null || getExpirationDate().isEmpty()) {
            return false;
        }
        else if (getExpirationDate().compareTo("2023-10-01") < 0) {
            return true;
        }
        return false;
    }
}
