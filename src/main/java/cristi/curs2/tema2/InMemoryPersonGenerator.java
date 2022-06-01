package cristi.curs2.tema2;

import java.util.List;

public class InMemoryPersonGenerator extends PersonReportGenerator{
    @Override
    List<Person> getPersons() {
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
