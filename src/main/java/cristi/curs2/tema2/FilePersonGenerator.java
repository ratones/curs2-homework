package cristi.curs2.tema2;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class FilePersonGenerator extends PersonReportGenerator {
    private final String inputFile;
    @Override
    List<Person> getPersons() {
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
