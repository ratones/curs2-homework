package cristi.curs2.tema2.composition;

public class CompositionMain {
    public static void main(String[] args) {
        //        InMemoryPersonGenerator generator = new InMemoryPersonGenerator();
//        PersonReportGenerator generator = new PersonReportGenerator(new InMemoryPersonProvider());
        PersonReportGenerator generator = new PersonReportGenerator(new FilePersonProvider("src/main/resources/people.txt"));
        generator.generateReport();
    }
}
