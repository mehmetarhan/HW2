public class Customer {

    // Data filds
    private String name = "Unknown";  // Default value
    private int promotion = 100;      // Default value

    public Customer() {
        this.promotion = 70;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, int promotion) {
        this.name = name;
        this.promotion = promotion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getName() {
        return name;
    }

    public int getPromotion() {
        return promotion;
    }

}
