package fp;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;


public class Persons {

    private List<Person> persons = List.of(
            new Person(1, "Alice", 22),
            new Person(2, "Bob", 20),
            new Person(3, "Carol", 21));

    @Test
    public void findsPersonById() {

        Person personWithId2 = persons.stream()
                .filter(person -> person.getId() == 2)
                .findFirst()
                .orElse(null);

        System.out.println(personWithId2);
    }

    @Test
    public void removePersonById() {

        List<Person> personsWithoutId2 = persons.stream()
                .filter(person -> person.getId() != 2)
                .toList();

        System.out.println(personsWithoutId2);
    }

    @Test
    public void findsPersonNames() {

        String names = persons.stream()
                .map(Person -> Person.getName())
                .collect(Collectors.joining(", "));

        System.out.println(names);
    }

    @Test
    public void reverseSortedByAge() {

        List<Person> reverseSortedByAge = persons.stream()
                // Another solution: sorted(Comparator.reverseOrder(Comparator.comparing(p -> p.getAge())))
                .sorted((p1, p2) -> p2.getAge().compareTo(p1.getAge()))
                .collect(Collectors.toList());

        System.out.println(reverseSortedByAge);

    }

}
