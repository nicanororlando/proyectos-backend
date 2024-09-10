package DecoratorPattern.Pizza;

public class PlainPizza implements IPizza{

    @Override
    public String getDescription(){
        return "Masa a la piedra";
    }

    @Override
    public double getCost(){
        return 7000;
    }
}
