package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {
    public static void main(String[] args) {
        // Normal java function
        Customer maria = new Customer("Maria", "99999");
        //greetCustomer(maria);
        greetCustomerConsumerV2.accept(maria, false);
    }

    // consumer with too arguments
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
        System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + (showPhoneNumber ? customer.customerPhoneNumber : "*********"));

    // old way
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + customer.customerPhoneNumber);
    }

    // consumer way - input argument
    static Consumer<Customer> greetCustomerConsumer = customer ->
        System.out.println("Hello " + customer.customerName +
            ", thanks for registering phone number "
            + customer.customerPhoneNumber);

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }
}
