import java.util.HashMap;
import java.util.Map;

public class DynamicFactoryPattern {

    public static void main(String[] args) throws ClassNotFoundException {
        PersonManager pm = new PersonManager();
        pm.registerClasses("employee", Employee::new);
        pm.registerClasses("contractor", Contractor::new);
        pm.registerClasses("shareholder", ShareHolder::new);

        pm.getInstance("employee").get().display();
        pm.getInstance("contractor").get().display();
        pm.getInstance("shareholder").get().display();
    }

}

class PersonManager {

    private static final Map<String, FactoryInterface<? extends Person>> registeredClasses = new HashMap<>();

    public void registerClasses(String type, FactoryInterface<? extends Person> instance) {
        registeredClasses.put(type, instance);
    }

    public FactoryInterface<? extends Person> getInstance(String type) throws ClassNotFoundException {
        if (registeredClasses.containsKey(type)) {
            return registeredClasses.get(type);
        }
        throw new ClassNotFoundException();
    }
}

//Optional can be achieved using inbuilt interface Supplier<T>
@FunctionalInterface
interface FactoryInterface<T> {
    T get();
}

class Person {
    void display() {
        System.out.println("From Person");
    }
}

class Employee extends Person {
    void display() {
        System.out.println("From Employee");
    }
}

class ShareHolder extends Person {
    void display() {
        System.out.println("From ShareHolder");
    }
}

class Contractor extends Person {
    void display() {
        System.out.println("From Contractor");
    }
}
