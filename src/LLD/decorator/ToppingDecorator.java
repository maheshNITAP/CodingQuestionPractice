package LLD.decorator;

public  abstract class ToppingDecorator implements BasePizza {
    protected BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

}
