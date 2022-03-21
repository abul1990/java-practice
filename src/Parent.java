import java.util.*;
import java.util.function.DoubleBinaryOperator;

public class Parent {

    public String value ="Parent";

    public String getValue() {
        return value;
    }

    {
        System.out.print("A");
    }
    static {
        System.out.print("B");
    }

}



class Child extends Parent{

    public Integer divide() {
        try {
            return 1/0;
        }
        finally {
            System.out.println("final");
        }
    }

    public String value ="Child";

    public String getValue() {
        return value;
    }

    {
        System.out.print("C");
    }
    static {
        System.out.print("D");
    }

    public static void main(String[] args) {

        Child child = new Child();
        try {
            System.out.println(child.divide());
        } catch (Exception ex) {
            System.out.println("Exception");
        }


        /*Parent parent =new Child();
        System.out.println(parent.value + "& " +parent.getValue());*/

        /*Child child= new Child();

        ArrayList<Double> dl = new ArrayList<>();
        ArrayList<Number> nl = new ArrayList<>();

        add(dl);
        add(nl);

        System.out.println(dl.toString());
        System.out.println(nl.toString());*/

        List<String> list = new ArrayList<>();
        list.add("foo");

        List<String> l2 = list;
        System.out.println("l1 " + list);
        System.out.println("l2 " + l2);
        List<String> l3 = new ArrayList<>(l2);
        System.out.println("l3 " + l3);

        l2.clear();
        System.out.println("l1 " + list);
        System.out.println("l2 " + l2);
        System.out.println("l3 " + l3);
        l2.add("bar");
        l3.add("baz");

        System.out.println("l1 " + list);
        System.out.println("l2 " + l2);
        System.out.println("l3 " + l3);

        Set<Integer> set = new HashSet<>();

        set.add(3);
        set.add((int)3.0);
        set.add(2);
        set.add(2);
        set.add(new Integer(2));
        set.add(Integer.parseInt("2"));

        System.out.println(set);

    }

    public static void add(ArrayList<? super Double> list){
        list.add(Math.PI);
    }
}


