package LLD.decorator;

public class Demo {
    public static void main(String[] args) {
        BasePizza pizza = new FarmHouse();
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());
        System.out.println("-----------------------------");

        // Adding extra toppings using decorators
        BasePizza pizza2= new CheeseToppings(new PlainPizza());
        System.out.println("Description: " + pizza2.getDescription());
        System.out.println("Cost: " + pizza2.getCost());
        System.out.println("-----------------------------");


        BasePizza pizza3= new PaneerToppings(new CheeseToppings(new FarmHouse()));
        System.out.println("Description: " + pizza3.getDescription());
        System.out.println("Cost: " + pizza3.getCost());
        System.out.println("-----------------------------");
    }
}
