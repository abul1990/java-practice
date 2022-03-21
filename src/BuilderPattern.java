import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

public class BuilderPattern {
    public static void main(String[] args) {

        Vehicle car = new Vehicle.VehicleBuilder("Car Engine", "4").setAirBags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("Bike Engine", "2").build();

        System.out.println("Car >> " + car.getEngine() + ", " + car.getWheel() + ", " + car.getAirBags());
        System.out.println("Bike >> " + bike.getEngine() + ", " + bike.getWheel() + ", " + bike.getAirBags());

        /*MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        System.out.println("Total Cost: " + vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " + nonVegMeal.getCost());*/
    }

}

interface Item {
    String name();

    Packing packing();

    float price();
}

interface Packing {
    String pack();
}

class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper";
    }
}

class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }
}

abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }
}

class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}

class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}

class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}

class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getCost() {
        float cost = 0.0f;

        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems() {

        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}

class MealBuilder {

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

class Vehicle {

    @Getter
    private String engine;
    @Getter
    private String wheel;
    @Getter
    private int airBags; // optional field

    private Vehicle(VehicleBuilder vehicleBuilder) {
        this.engine = vehicleBuilder.engine;
        this.wheel = vehicleBuilder.wheel;
        this.airBags = vehicleBuilder.airBags;
    }

    static class VehicleBuilder {
        private String engine;
        private String wheel;
        private int airBags; // optional field

        public VehicleBuilder(String engine, String wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirBags(int airBags) {
            this.airBags = airBags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }

}






