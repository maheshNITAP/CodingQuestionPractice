package LLD.decorator;

public class PlainPizza implements BasePizza {
    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getCost() {
        return 200; // Base cost for a plain pizza
    }
}
