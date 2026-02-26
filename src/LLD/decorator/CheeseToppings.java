package LLD.decorator;

public class CheeseToppings extends ToppingDecorator {
    public CheeseToppings(BasePizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese Toppings";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50; // Additional cost for Cheese toppings
    }
}
