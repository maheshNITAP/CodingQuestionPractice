package LLD.FectoryPattern.AbstractFactory;

public class LuxuryInterior implements CarInterior {
    @Override
    public void addComponents() {
        System.out.println("Adding luxury interior components");
    }
}
