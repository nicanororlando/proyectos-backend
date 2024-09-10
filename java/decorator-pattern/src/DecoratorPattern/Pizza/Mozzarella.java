package DecoratorPattern.Pizza;

public class Mozzarella extends ToppingDecorator{

    public Mozzarella(IPizza newPizza){
        super(newPizza);

        System.out.println("+ Muzzarela");
    }

    public String getDescription(){
        return tempPizza.getDescription() + ", Muzzarela";
    }

    public double getCost(){
        return tempPizza.getCost() + 3000;
    }
}
