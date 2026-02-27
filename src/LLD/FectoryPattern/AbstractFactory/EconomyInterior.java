package LLD.FectoryPattern.AbstractFactory;

public class EconomyInterior implements CarInterior {
    @Override
    public void addComponents() {
        System.out.println("Adding economy interior components");
    }
}
