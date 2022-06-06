package streams;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class _Streams {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE),
            new Person("Bob", Gender.PREFER_NOT_TO_SAY)
        );

        people.stream()// access to the stream api
            .map(person -> person.name) // map is built upon the Function interface does transformations
            .collect(Collectors.toSet()) // collect is built upon the Supplier and BiConsumer
            .forEach(System.out::println);// takes in a consumer - takes an argument and produces nothing (void)

        // storing people's names in a set
        Set<String> names = people.stream()
            .map(person -> person.name)
            .collect(Collectors.toSet());

        // Function interface translation
        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = String::length;
        IntConsumer print = System.out::println;

        // get length of each name
        people.stream()
            .map(personStringFunction)
            .mapToInt(length)
            .forEach(print);

        boolean doesContainOnlyFemails = people.stream()
            .allMatch(person -> person.gender.equals(Gender.FEMALE)); // takes in a predicate and returns a boolean

        System.out.println(doesContainOnlyFemails);

        boolean doesContainAtleastOneFemale = people.stream()
            .anyMatch(person -> person.gender.equals(Gender.FEMALE));

        System.out.println(doesContainAtleastOneFemale);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
