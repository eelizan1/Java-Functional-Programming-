package Combinator;

import java.time.LocalDate;

import static Combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer(
            "Alice",
            "alice@gmail.com",
            "+0898787879878",
            LocalDate.of(2015, 1,1)
        );

        // old pattern
        CustomerValidatorService customerValidatorService = new CustomerValidatorService();
        boolean isValid = customerValidatorService.isValid(customer);
        System.out.println(isValid);

        // Using combinator pattern to chain methods together
        CustomerRegistrationValidator.ValidationResult result = isEmailValid()
            .and(isPhoneNumberValid())
            .and(isAnAdult())
            .apply(customer); // .apply() needs to be invoked for it to run

        System.out.println(result);
    }
}
