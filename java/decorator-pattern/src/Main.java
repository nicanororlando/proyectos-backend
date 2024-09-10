import DecoratorPattern.Coffee.*;
import DecoratorPattern.Pizza.*;

public class Main {
    public static void main(String[] args) {
        // DECORATOR PATTERN COFFEE
        System.out.println("\nDecorator pattern Coffee\n");

        Coffee expresso = new Expresso();
        printCoffee(expresso);

        expresso = new WithMilk(expresso);
        printCoffee(expresso);

        expresso = new WithSugar(expresso);
        expresso = new WithSugar(expresso);
        printCoffee(expresso);

        System.out.println("\n****************************************************");

        // DECORATOR PATTERN PIZZA
        System.out.println("\nDecorator pattern Pizza \n");

        IPizza basicPizza = new PlainPizza();
        printPizza(basicPizza);

        basicPizza = new TomatoSauce(basicPizza);
        printPizza(basicPizza);

        basicPizza = new Mozzarella(basicPizza);
        printPizza(basicPizza);
    }

    private static void printCoffee (Coffee c){
        System.out.println("Cost: " + c.getCost() + ", Description: " + c.getDescription());
    }

    private static void printPizza (IPizza p){
        System.out.println("Cost: " + p.getCost() + ", Description: " + p.getDescription());
    }
}