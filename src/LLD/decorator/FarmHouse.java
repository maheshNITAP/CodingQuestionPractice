package LLD.decorator;

public class FarmHouse implements BasePizza {


    @Override
    public String getDescription() {
        return "FarmHouse Toppings";
    }

    @Override
    public double getCost() {
        return 300; // Additional cost for FarmHouse toppings
    }
}
