package ua.borovyk.springcourse.dao;

import org.springframework.stereotype.Component;
import ua.borovyk.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oleksandr Borovyk
 */
@Component
public class PersonDAO {
    public static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Sasha"));
        people.add(new Person(++PEOPLE_COUNT, "Artem"));
        people.add(new Person(++PEOPLE_COUNT, "Eduard"));
        people.add(new Person(++PEOPLE_COUNT, "Slavic"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);
        personToBeUpdated.setName(updatedPerson.getName());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
