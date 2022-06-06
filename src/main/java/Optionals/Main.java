package Optionals;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        // provides a check if param is null and if so will return a default value
        Object defaultValue = Optional.ofNullable(null)
            .orElseGet(() -> "default value if null");

        System.out.println(defaultValue);

        // with value
        Object value = Optional.ofNullable("hello")
            .orElseGet(() -> "default value if null");

        System.out.println(value);

        // will throw an exception if param is null
//        Object exception = Optional.ofNullable(null)
//            .orElseThrow(() -> new IllegalStateException());

        Optional.ofNullable(null)
            .ifPresentOrElse(
                email -> System.out.println("Sending email to " + email),
                () -> System.out.println("Cannot send email")); // will execute

        Optional.ofNullable("eelizanjr@gmail.com")
            .ifPresentOrElse(
                email -> System.out.println("Sending email to " + email), // will execute
                () -> System.out.println("Cannot send email"));
    }
}
