package cristi.curs2.tema2;

import java.util.List;

public enum AgeInterval {
    YOUNG(0,30,"1-30"),
    MIDDLEAGE(31,50,"30-50"),
    SENIOR(51,200,"50+");

    private final int minAge;
    private final int maxAge;
    private final String label;

    public String getLabel() {
        return label;
    }

    AgeInterval(int minAge, int maxAge, String label) {
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.label  = label;
    }

    public String getPersonsNames(List<Person> persons){
        return String.join(",",persons.stream()
                .filter(person -> person.age() > minAge && person.age() <= maxAge)
                .map(person -> "%s %s".formatted(person.fName(), person.lName())).toList());
    }
}
