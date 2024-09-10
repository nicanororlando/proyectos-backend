package DecoratorPattern.Pizza;

abstract class ToppingDecorator implements IPizza{

    protected IPizza tempPizza;

    public ToppingDecorator(IPizza newPizza){
        tempPizza = newPizza;
    }

    @Override
    public String getDescription(){
        return tempPizza.getDescription();
    }

    @Override
    public double getCost(){
        return tempPizza.getCost();
    }
}
