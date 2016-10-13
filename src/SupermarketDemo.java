import java.util.Scanner;
import java.util.ArrayList;

public class SupermarketDemo {

    public static Scanner scanner = new Scanner(System.in); // Scanner to get user input
    public static ArrayList<Shopping> shoppings = new ArrayList<>(100);  // List of shoppings

    public static void main(String[] args) {

        System.out.println("Would you like to do shopping?(1: Y, 2: N");
        int choice = scanner.nextInt();

        while (choice == 1) {

            Shopping shopping = new Shopping();  // Setting a shopping
            shopping.setCustomer(getCustomer());   // Getting a customer
            setTime(shopping);  // Setting time of the shopping (day and month)
            addItem(shopping);  // Adding and deleting item
            shoppings.add(shopping); // Finally, adding the shopping to the list
            choice = scanner.nextInt(); // New choice
            continue;
        }

        if (choice == 2) {
            System.out.println("Goodbye!");
            printShoppingData();
        }
    }

    public static Customer getCustomer() {

        // Setting the default customers
        Customer customer = new Customer("Ali", 90);
        Customer customer1 = new Customer("Ayse");
        Customer customer2 = new Customer();

        // Asking for a choice
        System.out.println("Which customer?");
        System.out.println("1: " + customer.getName() + " %" + customer.getPromotion());
        System.out.println("2: " + customer1.getName() + " %" + customer1.getPromotion());
        System.out.println("3: " + customer2.getName() + " %" + customer2.getPromotion());

        int choice = scanner.nextInt();
        boolean isChoiceValid = (choice == 1 || choice == 2 || choice == 3);

        while (!isChoiceValid) {
            System.out.println("Invalid input\nEnter again");
            choice = scanner.nextInt();
            isChoiceValid = (choice == 1 || choice == 2 || choice == 3);
        }

        switch (choice) {

            case 1:
                return customer;
            case 2:
                return customer1;
            case 3:
                return customer2;
        }
        return new Customer();
    }

    public static void setTime(Shopping shopping) {

        // Setting day
        System.out.println("Day?");
        int day = scanner.nextInt();

        if (day > 31 || day < 1) {
            System.out.println("Day value is not valid. It is set to 1.");
            shopping.setDay(1);
        } else {
            shopping.setDay(day);
        }

        // Setting month
        System.out.println("Month?");
        int month = scanner.nextInt();

        if (month > 12 || month < 1) {
            System.out.println("Month value is not valid. It is set to 1.");
            shopping.setMonth(1);
        } else {
            shopping.setMonth(month);
        }

        if (month==2 && day>28) {
            shopping.setDay(1);
        }
    }

    public static void addItem(Shopping shopping) {

        boolean cont = true;
        while (cont) {
            System.out.println("Add Item?(1: Y, 2: N");
            int choice = scanner.nextInt();
            int amount;

            if (choice == 1 || choice == 2) {
                if (choice == 1) {
                    System.out.println("Amount");
                    amount = scanner.nextInt();
                    if(amount>0) {
                        shopping.addItem(amount);
                        cont = true;
                        continue;
                    } else {
                        System.out.println("Prize cannot be negative");
                        continue;
                    }
                } else if (choice == 2) {
                    deleteItem(shopping);
                    cont = false;
                    continue;
                }
            }

            System.out.println("Enter a valid choice");
            continue;
        }
    }

    public static void deleteItem(Shopping shopping) {

        boolean cont = true;
        while (cont) {
            System.out.println("Delete Item?(1: Y, 2: N");
            int choice = scanner.nextInt();
            int amount;

            if (choice == 1 || choice == 2) {
                if (choice == 1) {
                    System.out.println("Amount");
                    amount = scanner.nextInt();
                    if (amount > shopping.getCalculatedPayment()) {
                        System.out.println("The operation is invalid");
                        continue;
                    }
                    if (amount<0) {
                        System.out.println("Prize cannot be negative");
                        continue;
                    }
                    shopping.deleteItem(amount);
                    cont = true;
                    continue;
                } else if (choice == 2) {
                    System.out.println("Would you like to continue shopping?(1: Y, 2: N");
                    cont = false;
                    continue;
                }
            }
            System.out.println("Enter a valid choice");
            continue;
        }
    }

    public static void printShoppingData() {

        for (Shopping shopping : shoppings) {
            int index = shoppings.indexOf(shopping);
            String name = shopping.getCustomer().getName();
            int day = shopping.getDay();
            int month = shopping.getMonth();
            int calculatedPayment = shopping.getCalculatedPayment();
            int discountedPayment = shopping.getDiscountedPayment();
            System.out.println(index + "\t" + name + "\t" + day + "/" + month + "\t" + calculatedPayment + "\t" + discountedPayment);
        }
    }

}