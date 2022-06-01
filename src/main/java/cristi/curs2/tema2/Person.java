package cristi.curs2.tema2;

import lombok.Builder;

@Builder
public record Person(String fName, String lName, int age) {

}
