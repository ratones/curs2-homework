package cristi.curs2.tema2.composition;

import cristi.curs2.tema2.Person;
import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class PersonReportGenerator {
    private final PersonProvider personProvider;
    public void generateReport(){
        generateReport(personProvider.readPersons());
    }

    private void generateReport(List<Person> persons) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            List<String> under30 = new ArrayList<>();
            List<String> under60 = new ArrayList<>();
            List<String> over50 = new ArrayList<>();
            for (Person person:persons){
                String name = "%s %s".formatted(person.fName(),person.lName());
                if(person.age() <= 30){
                    under30.add(name);
                }else if(person.age() > 30 && person.age() <= 50){
                    under60.add(name);
                }else{
                    over50.add(name);
                }
            }
            writeLine(writer, "1-30", String.join(",",under30));
            writeLine(writer, "30-50", String.join(",",under60));
            writeLine(writer, "50+", String.join(",",over50));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(BufferedWriter writer,String group, String name) throws IOException {
        writer.write("%s : %s".formatted(group, name));
        writer.newLine();
    }
}
