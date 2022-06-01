package cristi.curs2.tema2.composition;

import cristi.curs2.tema2.Person;

import java.util.List;

public class InMemoryPersonProvider implements PersonProvider{
    @Override
    public List<Person> readPersons() {
        return List.of(
                new Person("Cristi", "Mardare", 49),
                new Person("Ion", "Vasile", 21),
                new Person("George", "Ionescu", 72),
                new Person("Adrian", "Georgescu", 41),
                new Person("Mihai", "Marin", 18),
                new Person("Marius", "", 61),
                new Person("Alexandru", "", 50)
        );
    }
}
