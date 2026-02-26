package LLD.decorator;

public class PaneerToppings extends ToppingDecorator {

    public PaneerToppings(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Paneer Toppings";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 150; // Additional cost for Paneer toppings
    }
}
