package LLD.FectoryPattern.AbstractFactory;

public class EconomyExterior implements CarExterior {
    @Override
    public void addComponents() {
        System.out.println("Adding economy exterior components");
    }
}
