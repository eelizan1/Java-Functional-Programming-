package beyondfunctions;

import java.util.function.Consumer;

public class callbacks {
    public static void main(String[] args) {
        // 3rd param is the callback function taken in as a Consumer fuction with a default message
        hello("John", null, value -> {
            System.out.println("no last name provided for " + value);
        });

        // 3rd param is a runnable function (similiar to js)
        helloRunnable("John", null, () -> {
            System.out.println("no last name provided");
        });
    }

    // Consumer<String> callback - will take an input if not null the return, otherwise have a default message
    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            // invoke callback if there's no last name
            callback.accept(firstName);
        }
    }

    // use on arguments in callbacks
    static void helloRunnable(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            // invoke callback if there's no last name
            callback.run();
        }
    }
}
