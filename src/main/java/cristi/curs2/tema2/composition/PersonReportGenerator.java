package cristi.curs2.tema2.composition;

import cristi.curs2.tema2.AgeInterval;
import cristi.curs2.tema2.Person;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class PersonReportGenerator {
    private final PersonProvider personProvider;
    public void generateReport(){
        generateReport(personProvider.readPersons());
    }

    private void generateReport(List<Person> persons) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            for(AgeInterval interval: AgeInterval.values()){
                writeLine(writer, interval.getLabel(), interval.getPersonsNames(persons));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(BufferedWriter writer,String group, String name) throws IOException {
        writer.write("%s : %s".formatted(group, name));
        writer.newLine();
    }
}
