package cristi.curs2.tema1;

public class GravityMain {
    public static void main(String[] args) {
        for(Gravity g: Gravity.values()){
            System.out.println("Your mass on %s is %s kg.".formatted(g.name(),g.getMassOnPlanet(123)));
        }
    }
}
