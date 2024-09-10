package DecoratorPattern.Coffee;

public class WithSugar extends CoffeeDecorator {

    // Referencia al objeto original "Coffee"
    Coffee coffee;

    public WithSugar(Coffee coffee){
        // Cuando sea llamado este objeto, tomamos el objeto EXISTENTE ("Expresso" por ejemplo)
        this.coffee = coffee;
    }

    // Misma idea aca: trabajamos sobre el objeto original y le agregamos adicionales
    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1000;
    }
}
