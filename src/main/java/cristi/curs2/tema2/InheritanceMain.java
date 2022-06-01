package cristi.curs2.tema2;

public class InheritanceMain {
    public static void main(String[] args) {
//        InMemoryPersonGenerator generator = new InMemoryPersonGenerator();
        FilePersonGenerator generator = new FilePersonGenerator("src/main/resources/people.txt");
        generator.generateReport();
    }
}
