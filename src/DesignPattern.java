public class DesignPattern {
    public static void main(String[] args) {
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        System.out.println(obj1 == obj2);
        System.out.println(obj1.equals(obj2));

        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        FactoryRegistry factory = new FactoryRegistry();
        factory.getObject("FactoryClass1").getClassObject();
        factory.getObject("FactoryClass2").getClassObject();
        factory.getObject("FactoryClass3").getClassObject();


    }
}

class Singleton {
    private static Singleton INSTANCE = null;

    private Singleton() {
    }

    //synchronized - performance issue
    public static Singleton getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton.class) { //Thread safety and lazy
                if (INSTANCE == null) { //Double check
                    INSTANCE = new Singleton();
                }
            }

        }
        return INSTANCE;
    }

    //to defeat and prevent from serialization
    protected Object readResolve() {
        return INSTANCE;
    }
}

interface FactoryDesignInterface {
    String type(); // can be used in springboot to isolate object type

    void getClassObject();
}

class FactoryClass1 implements FactoryDesignInterface {

    @Override
    public String type() {
        return "FactoryClass1";
    }

    @Override
    public void getClassObject() {
        System.out.println("Factory class 1 object");
    }
}

class FactoryClass2 implements FactoryDesignInterface {

    @Override
    public String type() {
        return "FactoryClass2";
    }

    @Override
    public void getClassObject() {
        System.out.println("Factory class 2 object");
    }
}

class FactoryClass3 implements FactoryDesignInterface {

    @Override
    public String type() {
        return "FactoryClass3";
    }

    @Override
    public void getClassObject() {
        System.out.println("Factory class 3 object");
    }
}

class FactoryRegistry {

    public FactoryDesignInterface getObject(String type) {
        if (type.equalsIgnoreCase("FactoryClass1")) {
            return new FactoryClass1();
        } else if (type.equalsIgnoreCase("FactoryClass2")) {
            return new FactoryClass2();
        } else if (type.equalsIgnoreCase("FactoryClass3")) {
            return new FactoryClass3();
        }
        return null;
    }

}
