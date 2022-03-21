import java.sql.Time;
import java.text.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PracticeMain {
    public static void main(String[] args) {

        String input = "abcdefghijabcedfahebbcdecgh";

        String output ="";
        StringBuilder sb = new StringBuilder();

        String csv = "TestCase_Name, Code\n" +
                "GetUserList, 123\n" +
                "PostUser, 321";

        sb.append(input.charAt(0));

        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if (sb.toString().contains(Character.toString(input.charAt(j)))) {
                    if(output.length() < sb.length()){
                        output = sb.toString();
                    }
                    System.out.println(sb);
                    sb.setLength(0);
                    break;
                } else {
                    sb.append(input.charAt(j));
                }
            }
        }

        System.out.println("Longest: " + output);

        IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n + 10)
                .forEach(System.out::println);

        //oddAndEvenArray();
        //Q1
        /*String s1 = "hello";
        String s2 = new String("hello");
        String s3 = "hello";
        //s2 = s2.intern(); //copies s1 to s2 from String pool
        if (s1 == s2) { //false , s1.equals(s2) true
            System.out.println("s1 and s2 equal");
        } else {
            System.out.println("s1 and s2 not equal");
        }
        if (s1 == s3) {
            System.out.println("s1 and s3 equal");
        } else {
            System.out.println("s1 and s3 not equal");
        }

        //Q2
        String s = new String("5");
        System.out.println(1 + 10 + s + 1 + 10);

        //Q3
        String str = null;
        System.out.println(str.valueOf(10));

        //Q4
        String str1 = "abc";
        StringBuffer sb = new StringBuffer(s1);
        System.out.println(str1.equals(sb));

        //Q5
        String s15 = new String("abul");
        String s25 = new String("abul");
        System.out.println(s15 == s25); // false
        System.out.println(s15.equals(s25)); //true

        Test test = new Test();
        test.print(10);

        Derived b = new DeriDerived();

        Base po = new Base();
        //po.foo(); // BASE_FOO_CALL private method
        po.bar();

        Thread myThread = new MyThread();
        myThread.run(); // #1
        System.out.println("In main method; thread name is: " + Thread.currentThread().getName());

        Base obj = new Derived();
        ((DeriDerived)obj).bar(); // ClassCastException*/
        Base base = new Derived("Hello ");

    }

    static void oddAndEvenArray() {
        int[] arr = {3, 5, 1, 12, 6, 8, 9, 10};

        for (int i = 0; i < arr.length; i++) {
            int swapNumPos = -1;
            if (i % 2 != 0 && arr[i] % 2 == 0) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] % 2 != 0) {
                        swapNumPos = j;
                        break;
                    }
                }
            } else if (i % 2 == 0 && arr[i] % 2 != 0) {
                for (int j = i; j < arr.length; j++) {
                    if (arr[j] % 2 == 0) {
                        swapNumPos = j;
                        break;
                    }
                }
            }
            if (swapNumPos > -1) {
                int temp = arr[i];
                arr[i] = arr[swapNumPos];
                arr[swapNumPos] = temp;
            }
            System.out.println(arr[i]);
        }

        System.out.println(Arrays.toString(arr));
    }
}

class Test {
    //int, Integer, long, int..., short
    public void print(Integer i) {
        System.out.println("Integer");
    }

    public void print(int i) {
        System.out.println("int");
    }

    public void print(long i) {
        System.out.println("long");
    }

    public void print(int... i) {
        System.out.println("int...");
    }

    public void print(short i) {
        System.out.println("short");
    }
}

class Base {
    public Base() {
        System.out.println("Base");
    }

    public Base(String s) {
        System.out.print("Base: " + s);
    }


    private void foo() {
        System.out.println("In BaseClass.foo()");
    }

    void bar() {
        System.out.println("In BaseClass.bar()");
    }

}

class Derived extends Base {
    public Derived() {
        System.out.println("Derived");
    }

    public Derived(String s) {
        //super(); // Stmt-1
        super(s); // Stmt-2
        System.out.print("Derived ");
    }


    void foo() {
        System.out.println("In Derived.foo()");
    }

    void bar() {
        System.out.println("In Derived.bar()");
    }


}

class DeriDerived extends Derived {
    //by default calls super()
    public DeriDerived() {
        System.out.println("DeriDerived");
    }

    void bar() {
        System.out.println("In DeriDerived.bar()");
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("In run method; thread name is: " + Thread.currentThread().getName());
    }
}

abstract class Testabc extends Base { // #1
    public static void main(String[] args) {
        Base obj = new Base();
        obj.bar(); // #2
    }
}

class SuperClass {
    SuperClass() {
        System.out.println("superclass before");
        foo();
        System.out.println("superclass");
    }

    public void foo() {
        System.out.println("In SuperClass.foo()");
    }
}

class SubClass extends SuperClass {
    private String member;


    public SubClass() {
        member = "HI";

        System.out.println("subclass");
    }

    public void foo() {
        System.out.println("In SubClass.foo(): " + member);
    }
}

class TestRef {
    public static void main(String[] args) {
        //SuperClass reference = new SubClass();
        //reference.foo();
        //String output = isBalanced("}][}}(}][))]");
        //System.out.println(">> " + output);

        int[][] input = {{75, 65, 35, 60}, {85, 55, 45, 50}, {95, 45, 15, 80}};


        System.out.println(" >> " + Arrays.toString(studentSum(3, 4, input)));
    }

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '[' || ch == '(') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && ((ch == '}' && stack.peek() == '{') || (ch == ')' && stack.peek() == '(') || (ch == ']' && stack.peek() == '['))) {
                    stack.pop();
                } else {
                    return "NO";
                }
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    public static int[] studentSum(int input1, int input2, int[][] input3) {
        int[] output = new int[input1];


        System.out.println("len " + input3[0].length);
        int[] sum = new int[input2];
        int idx = 0;
        for (int j = 0; j < input2; j++) {
            for (int i = 0; i < input1; i++) {
                sum[j] += input3[i][j];
            }
            if (j == 0) {
                idx = 0;
            } else if (sum[j] < sum[j - 1]) {
                idx = j;
            }
        }

        int total = 0;
        for (int i = 0; i < input1; i++) {
            for (int j = 0; j < input2; j++) {
                if (idx != j) {
                    total += input3[i][j];
                }
            }
            output[i] = total;
            total = 0;
        }

        System.out.println("sum >> " + Arrays.toString(sum) + "j >> " + idx);

        return output;
    }

    public static void mairu(String input) {
        char[] ch = input.toCharArray();
    }
}

class CommonPractice {
    public static void main(String[] args) throws ParseException {
        //testTime();
        //hackerlandRadioTransmitters();
        gridlandMetro();
    }

    public static void testTime() throws ParseException {
        DateFormat formatter = new SimpleDateFormat("hh:mm:ssaa");

        Time timeValue = new Time(formatter.parse("12:01:00AM").getTime());
        System.out.println(timeValue);
    }

    public static int hackerlandRadioTransmitters() {
        List<Integer> x = new ArrayList<>();
        x.add(7);
        x.add(2);
        x.add(4);
        x.add(6);
        x.add(5);
        x.add(9);
        x.add(12);
        x.add(11);

        int k = 2;
        Collections.sort(x);
        System.out.println(x);

        int numOfTransmitters = 0;
        int i = 0;


        while (i < x.size()) {
            int loc = x.get(i) + k;
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }
            loc = x.get(--i) + k;
            System.out.println("pos >> " + x.get(i));
            numOfTransmitters++;
            while (i < x.size() && x.get(i) <= loc) {
                i++;
            }
        }

        System.out.println(" >> " + numOfTransmitters);
        return numOfTransmitters;
    }

    public static long gridlandMetro() {
        int n = 2;
        int m = 9;
        int k = 4;
        List<List<Integer>> track = List.of(List.of(2, 9, 3), List.of(2, 1, 5), List.of(2, 2, 4), List.of(2, 8, 8));

        int occupied = 0;
        int result;
        int min = 0;
        int max = 0;
        for (int i = 1; i < track.size(); i++) {
            if (i == 1) {
                min = track.get(1).get(1);
                max = track.get(1).get(2);
            }
            if (min > track.get(i).get(1)) {
                min = track.get(i).get(1);
            }
            if (max < track.get(i).get(2)) {
                max = track.get(i).get(2);
            }
            System.out.println(" i >> " + i);
            System.out.println(" min >> " + min);
            System.out.println(" max >> " + max);
            if (i < track.size() - 1 && !Objects.equals(track.get(i).get(0), track.get(i + 1).get(0))) {
                occupied = occupied + (max - min + 1);
                min = track.get(i + 1).get(1);
                max = track.get(i + 1).get(2);
            } else if (i == track.size() - 1) {
                occupied = occupied + (max - min + 1);
            }
        }
        System.out.println(" >> " + occupied);
        result = n * m - occupied;
        System.out.println(" >> " + result);

        return result;


        /*long result = 0;
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (pos < k && i + 1 == track.get(pos).get(0)) {
                if (track.get(pos).get(1) > 1) {
                    result = result + track.get(pos).get(1) - 1;
                }
                if (track.get(pos).get(2) < n) {
                    result = result + n - track.get(pos).get(2);
                }
                pos++;
            } else {
                result = result + m;
            }
        }
        System.out.println(" >> " + result);
        return result;*/

    }
}