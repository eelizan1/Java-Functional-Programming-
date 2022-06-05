package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Alice", Gender.FEMALE)
        );

        declareative(people);
        imperative(people);
        predicate(people);
    }

    private static void declareative(List<Person> people) {
       List<Person> females = new ArrayList<>();
       for (Person person : people) {
           if (person.gender.equals(Gender.FEMALE))
               females.add(person);
       }

        System.out.println("Declarative: ");
       for (Person female : females) {
           System.out.println(female);
       }
    }

    private static void imperative(List<Person> people) {
        System.out.println("Imerative: ");
        people.stream()
            .filter(person -> person.gender.equals(Gender.FEMALE)) // filters all females
            .collect(Collectors.toList()) // collects to a list
            .forEach(System.out::println); // prints each item in the list
    }

    private static void predicate(List<Person> people) {
        Predicate<Person> personPredicate = person -> person.gender.equals(Gender.FEMALE);

        System.out.println("Predicate: ");
        people.stream()
            .filter(personPredicate) // filters all females
            .collect(Collectors.toList()) // collects to a list
            .forEach(System.out::println); // prints each item in the list
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override public String toString() {
            return "Person{" + "name='" + name + '\'' + ", gender=" + gender + '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
