public class Shopping {

    private Customer customer;
    private int day;
    private int month;
    private int calculatedPayment;
    private int discountedPayment;

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getCalculatedPayment() {
        return calculatedPayment;
    }

    public int getDiscountedPayment() {
        int disc = (calculatedPayment * customer.getPromotion() / 100);
        return disc;
    }

    public void addItem(int prize) {
        calculatedPayment += prize;
    }

    public void deleteItem(int prize) {
        calculatedPayment -= prize;
    }

}