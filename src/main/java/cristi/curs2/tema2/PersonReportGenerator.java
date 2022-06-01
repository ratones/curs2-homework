package cristi.curs2.tema2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public abstract class PersonReportGenerator {

    public void generateReport(){
        List<Person> persons = getPersons();
        generateReport(persons);
    }

    private void generateReport(List<Person> persons) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))){
            List<String> under30 = new ArrayList<>();
            List<String> under60 = new ArrayList<>();
            List<String> over60 = new ArrayList<>();
            for (Person person:persons){
                String name = "%s %s".formatted(person.fName(),person.lName());
                if(person.age() <= 30){
                    under30.add(name);
                }else if(person.age() > 30 && person.age() <= 50){
                    under60.add(name);
                }else{
                    over60.add(name);
                }
            }
            writeLine(writer, "1-30", String.join(",",under30));
            writeLine(writer, "30-50", String.join(",",under60));
            writeLine(writer, "50+", String.join(",",over60));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeLine(BufferedWriter writer,String group, String name) throws IOException {
        writer.write("%s : %s".formatted(group, name));
        writer.newLine();
    }

    abstract List<Person> getPersons();
}
