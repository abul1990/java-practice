import java.util.Arrays;
import java.util.Stack;

public class StackAndQueue {

    public static void main(String[] args) {
        System.out.println(" >> " + simplifyPath("/home/a/./x/../b//c/"));
        System.out.println(" >> " + decodeString("2[b3[a]]"));
        System.out.println(" >> " + Arrays.toString(nextLarger(new int[]{6, 7, 3, 8})));
        System.out.println(" >> " + Arrays.toString(minimumOnStack(new String[]{"push 10", "min", "push 5", "min", "push 8", "min", "pop", "min", "pop", "min"})));
        System.out.println(" >> " + skyMapIslands(new char[][]{
                {'0', '1', '1', '0', '1'},
                {'0', '1', '1', '1', '1'},
                {'0', '0', '0', '0', '1'},
                {'1', '0', '0', '1', '1'}}));
    }


    static String simplifyPath(String path) {

        String[] token = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < token.length; i++) {
            if (stack.size() > 0 && "..".equals(token[i])) {
                stack.pop();
            } else if (!".".equals(token[i]) && !"".equals(token[i])) {
                stack.push(token[i]);
            }
        }

        StringBuilder sb = new StringBuilder();



        Stack<String> result = new Stack<>();
        while (!stack.isEmpty()) {
            result.push(stack.pop());
        }

        while (!result.isEmpty()) {
            sb.append("/").append(result.pop());
        }

        return sb.toString();

    }

    static String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = 10 * count + (s.charAt(index) - '0');
                    index += 1;
                }
                counts.push(count);
            } else if (s.charAt(index) == '[') {
                result.push(res);
                res = "";
                index += 1;
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder(result.pop());
                int count = counts.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(res);
                }
                res = sb.toString();
                index += 1;
            } else {
                res += s.charAt(index);
                index += 1;
            }
        }
        return res;
    }

    static int[] nextLarger(int[] a) {

        int n = a.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && a[i] >= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(a[i]);
        }
        return result;

        /*int[] result = new int[a.length];
        int counter = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] < a[j]) {
                    result[counter++] = a[j];
                    break;
                } else if (j == a.length - 1) {
                    result[counter++] = -1;
                }
            }
        }
        result[counter++] = -1;

        return result;*/
    }

    static int[] minimumOnStack(String[] operations) {

        StackAndQueue obj = new StackAndQueue();

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[operations.length];
        int counter = 0;

        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i].split(" ")[0];
            switch (operation) {
                case "push":
                    stack.push(Integer.parseInt(operations[i].split(" ")[1]));
                    break;
                case "pop":
                    stack.pop();
                    break;
                case "min":
                    result[counter++] = obj.findMin(stack);
                    break;
            }

        }

        return result;

    }

    int findMin(Stack<Integer> temp) {
        int min = Integer.MAX_VALUE;
        int i = 0;
        while (temp.size() > i) {
            min = Math.min(min, temp.get(i));
            i++;
        }
        return min;
    }

    static int skyMapIslands(char[][] skyMap) {

        if (skyMap == null || skyMap.length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i < skyMap.length; i++) {
            for (int j = 0; j < skyMap[i].length; j++) {
                if (skyMap[i][j] == '1') {
                    count += dfs(skyMap, i, j);
                }

            }
        }
        return count;

    }

    static int dfs(char[][] skyMap, int i, int j) {
        if (i < 0 || i >= skyMap.length || j < 0 || j >= skyMap[i].length || skyMap[i][j] == '0') {
            return 0;
        }

        skyMap[i][j] = '0';

        dfs(skyMap, i + 1, j);
        dfs(skyMap, i - 1, j);
        dfs(skyMap, i, j + 1);
        dfs(skyMap, i, j - 1);

        return 1;
    }


}
