package DecoratorPattern.Coffee;

public class Expresso extends Coffee {

    public Expresso() {
        description = "Expresso";
    }

    @Override
    public double getCost() {
        return 5000;
    }
}
