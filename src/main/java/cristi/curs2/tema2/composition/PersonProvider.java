package cristi.curs2.tema2.composition;

import cristi.curs2.tema2.Person;

import java.util.List;

public interface PersonProvider {
    List<Person> readPersons();
}
