package DecoratorPattern.Pizza;

public class TomatoSauce extends ToppingDecorator{

    public TomatoSauce(IPizza newPizza){
        super(newPizza);

        System.out.println("+ Salsa de Tomate");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Salsa de Tomate";
    }

    public double getCost(){
        return tempPizza.getCost() + 1500;
    }
}
