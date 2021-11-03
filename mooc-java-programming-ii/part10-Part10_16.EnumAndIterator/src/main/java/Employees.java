import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Employees {
    private List<Person> employees;

    public Employees() {
        employees = new ArrayList<>();
    }

    public void add(Person personToAdd) {
        employees.add(personToAdd);
    }

    public void add(List<Person> peopleToAdd) {
        peopleToAdd.forEach(employees::add);
    }

    public void print() {
        employees.forEach(System.out::println);
    }

    public void print(Education education) {
        Iterator<Person> personIterator = employees.iterator();
        while (personIterator.hasNext()) {
            Person nextPerson = personIterator.next();
            if (nextPerson.getEducation() == education) {
                System.out.println(nextPerson);
            }
        }
    }

    public void fire(Education education) {
        Iterator<Person> personIterator = employees.iterator();
        while (personIterator.hasNext()) {
            Person nextPerson = personIterator.next();
            if (nextPerson.getEducation() == education) {
                personIterator.remove();
            }
        }
    }
}
