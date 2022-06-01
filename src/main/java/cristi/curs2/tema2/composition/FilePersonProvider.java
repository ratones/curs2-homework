package cristi.curs2.tema2.composition;

import cristi.curs2.tema2.Person;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FilePersonProvider implements PersonProvider{
    private final String inputFile;

    @Override
    public List<Person> readPersons() {
        try {
            return Files.lines(Path.of(inputFile)).map(this::toPerson).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Person toPerson(String s) {
        String[] infos = s.split(",");
        return Person.builder()
                .fName(infos[0])
                .lName(infos[1])
                .age(Integer.parseInt(infos[2]))
                .build();
    }
}
