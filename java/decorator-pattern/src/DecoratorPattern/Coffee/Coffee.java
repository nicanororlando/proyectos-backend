package DecoratorPattern.Coffee;

public abstract class Coffee {
    String description = "Unkown";
    public String getDescription(){
        return description;
    };
    public abstract double getCost();
}
