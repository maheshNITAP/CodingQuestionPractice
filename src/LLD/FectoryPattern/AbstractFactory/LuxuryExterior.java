package LLD.FectoryPattern.AbstractFactory;

public class LuxuryExterior implements CarExterior {
    @Override
    public void addComponents() {
        System.out.println("Adding luxury exterior components");
    }
}
