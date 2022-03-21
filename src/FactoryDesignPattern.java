import java.util.Hashtable;

public class FactoryDesignPattern {

    public static void main(String[] args) {
        System.out.println("----***Factory Pattern***----");
        ShapeFactory shapeFactory = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 = shapeFactory.getShape("CIRCLE");

        //call draw method of Circle
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 = shapeFactory.getShape("RECTANGLE");

        //call draw method of Rectangle
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 = shapeFactory.getShape("SQUARE");

        //call draw method of square
        shape3.draw();

        //Abstract Factory pattern

        System.out.println("----***Abstract Factory Pattern***----");

        //get shape factory
        AbstractFactory abshapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape abshape1 = shapeFactory.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        abshape1.draw();
        //get an object of Shape Square
        Shape abshape2 = shapeFactory.getShape("SQUARE");
        //call draw method of Shape Square
        abshape2.draw();
        //get shape factory
        AbstractFactory shapeFactory1 = FactoryProducer.getFactory(true);
        //get an object of Shape Rectangle
        Shape abshape3 = shapeFactory1.getShape("RECTANGLE");
        //call draw method of Shape Rectangle
        abshape3.draw();
        //get an object of Shape Square
        Shape abshape4 = shapeFactory1.getShape("SQUARE");
        //call draw method of Shape Square
        abshape4.draw();

        /*----***Prototype Pattern***-----*/
        System.out.println("----***Prototype Pattern***-----");
        ShapeCache.loadCache();

        AbShape clonedShape = ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        AbShape clonedShape2 = ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        AbShape clonedShape3 = ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());

    }

}

interface Shape {
    void draw();
}

class Rectangle extends AbShape implements Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rounded Rectangle::draw() method.");
    }
}

class Square extends AbShape implements Shape {
    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

class RoundedSquare implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rounded Square::draw() method.");
    }
}

class Circle extends AbShape implements Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

class ShapeFactory {

    //use getShape method to get object of type shape
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();

        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }

        return null;
    }
}

/*Abstract Factory pattern*/
abstract class AbstractFactory {
    abstract Shape getShape(String shapeType);
}

class AbstractShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

class RoundedShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new RoundedSquare();
        }
        return null;
    }
}

class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if (rounded) {
            return new RoundedShapeFactory();
        } else {
            return new AbstractShapeFactory();
        }
    }
}

/*----***Prototype Pattern***-----*/

abstract class AbShape implements Cloneable {
    private String id;
    protected String type;


    public abstract void draw();

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }

}

class ShapeCache {

    private static Hashtable<String, AbShape> shapeMap = new Hashtable<>();

    public static AbShape getShape(String shapeId) {
        AbShape cachedShape = shapeMap.get(shapeId);
        return (AbShape) cachedShape.clone();
    }

    // for each shape run database query and create shape
    // shapeMap.put(shapeKey, shape);
    // for example, we are adding three shapes

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");
        shapeMap.put(circle.getId(), circle);

        Square square = new Square();
        square.setId("2");
        shapeMap.put(square.getId(), square);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");
        shapeMap.put(rectangle.getId(), rectangle);
    }
}
