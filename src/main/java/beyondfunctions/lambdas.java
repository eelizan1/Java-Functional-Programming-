package beyondfunctions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class lambdas {
    public static void main(String[] args) {
        // single return
        Function<String, String> upperCaseName = name -> name.toUpperCase();

        // multi line
        Function<String, String> upperCaseName_2 = name -> {
            // logic
            if (name.isBlank()) throw new IllegalStateException("");
            return name.toUpperCase();
        };

        // multi param
        BiFunction<String, Integer, String> nameAge = (name, age) -> {
            // logic
            if (name.isBlank()) throw new IllegalStateException("");
            return name.toUpperCase() + "age: " + age;
        };

        nameAge.apply("Alex", 20);
    }
}
