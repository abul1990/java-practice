import java.util.*;

public class CodeSignal {

    public static void main(String[] args) {

        System.out.println(" >> " + prefixPalindrome("aachodoc"));
        //robberHouse(new int[]{1, 3, 1, 3, 100});
        System.out.println(" >> " + Arrays.toString(composeRanges(new int[]{1, 3})));
        //firstNonRepeatingChar("ngrhhqbhnsipkcoqjyviikvxbxyphsnjpdxkhtadltsuxbfbrkof");
        //int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //rotateImage(a);
        /*char[][] grid = {{'.', '.', '.', '1', '4', '.', '.', '2', '.'},
                {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
                {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
                {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
                {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '7', '.'}};
        boolean result = sudokuPuzzle(grid);
        System.out.println("puzzle >> " + result);*/

        char[][] solution = {{'B', '5'}, {'L', '8'}, {'A', '6'}, {'C', '7'}, {'K', '0'}, {'U', '1'}, {'E', '9'}, {'P', '4'}};

        boolean result = cryptAlgorithm(new String[]{"BLACK", "BLUE", "APPLE"}, solution);
        System.out.println("crypt >> " + result);
    }

    int solution(int year) {
        if (year <= 100) {
            return 1;
        } else if (year % 100 == 0) {
            return year / 100;
        } else {
            return year / 100 + 1;
        }
    }

    boolean isPalindrome(String inputString) {
        StringBuilder sb = new StringBuilder("");
        for (int i = inputString.length() - 1; i >= 0; i--) {
            sb.append(inputString.charAt(i));
        }
        return sb.toString().equals(inputString);
    }

    int firstDuplicate(int[] a) {
        Set<Integer> temp = new HashSet<>();

        for (int j : a) {
            if (temp.contains(j)) {
                return j;
            } else {
                temp.add(j);
            }
        }
        return -1;

    }

    static char firstNonRepeatingChar(String s) {
        /*int occur = 0;
        for (int i = 0; i < s.length(); i++) {
            occur = s.replace(Character.toString(s.charAt(i)), "").length();
            if (s.length() - occur == 1) {
                return s.charAt(i);
            }
        }

        return '_';

*/

        /*HashMap<Character, Integer> charHashMap = new LinkedHashMap<>();
        char result = '_';

        for (int i = 0; i < s.length(); i++) {
            if (charHashMap.containsKey(s.charAt(i))) {
                charHashMap.put(s.charAt(i), charHashMap.get(s.charAt(i)) + 1);
            } else {
                if (i == s.length() - 1) {
                    return s.charAt(i);
                }
                charHashMap.put(s.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charHashMap.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }
        return result;*/

        for (char i : s.toCharArray()) {
            if (s.indexOf(i) == s.lastIndexOf(i)) {
                return i;
            }
        }
        return '_';
    }

    static int[][] rotateImage(int[][] a) {

        int[][] result = new int[a.length][a.length];
        int row = 0;
        int column = 0;

        /*int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
                int temp = a[i][j];
                a[i][j] = a[n - 1 - j][i];
                a[n - 1 - j][i] = a[n - 1 - i][n - 1 - j];
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                a[j][n - 1 - i] = temp;
            }
        }*/


        for (int i = a.length - 1; i >= 0; i--) {
            row = 0;
            for (int j = 0; j < a.length; j++) {
                result[row][column] = a[i][j];
                row++;
            }
            column++;
        }

        System.out.println("matrix >> " + result);

        return result;

    }

    static boolean sudokuPuzzle(char[][] grid) {

        Set<Character> row = new HashSet<>();

        for (char[] chars : grid) {
            row.clear();
            for (int j = 0; j < grid.length; j++) {
                if (chars[j] != '.') {
                    if (row.contains(chars[j])) {
                        return false;
                    } else {
                        row.add(chars[j]);
                    }
                }
            }
        }

        for (int j = 0; j < grid.length; j++) {
            row.clear();
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] != '.') {
                    if (row.contains(grid[i][j])) {
                        return false;
                    } else {
                        row.add(grid[i][j]);
                    }
                }
            }
        }

        for (int j = 0; j < grid.length; j = j + 3) {
            for (int i = 0; i < grid.length; i = i + 3) {
                if (!check3Box(grid, i, j)) {
                    return false;
                }
            }
        }

        /*int rowStart = 0;
        int rowEnd = 3;
        int columnStart = 0;
        int columnEnd = 3;


        while (rowEnd <= 9) {
            for (int i = rowStart; i < rowEnd; i++) {
                row.clear();
                for (int j = columnStart; j < columnEnd; j++) {
                    if (grid[i][j] != '.') {
                        if (row.contains(grid[i][j])) {
                            return false;
                        } else {
                            row.add(grid[i][j]);
                        }
                    }
                    columnStart = columnStart + 3;
                    columnEnd = columnEnd + 3;
                }
            }
            rowStart = rowStart + 3;
            rowEnd = rowEnd + 3;
        }*/

        return true;

    }

    static boolean check3Box(char[][] grid, int row, int column) {
        Set<Character> box = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = column; j < column + 3; j++) {
                if (grid[i][j] != '.') {
                    if (box.contains(grid[i][j])) {
                        return false;
                    } else {
                        box.add(grid[i][j]);
                    }
                }
            }
        }
        return true;
    }

    static boolean cryptAlgorithm(String[] crypt, char[][] solution) {

        //int twoWordSum = 0;
        //int sum = 0;
        String[] words = new String[crypt.length];

        for (int w = 0; w < crypt.length; w++) {
            StringBuilder sum = new StringBuilder("");
            for (int i = 0; i < crypt[w].length(); i++) {
                for (char[] chars : solution) {
                    if (i == 0 && chars[0] == crypt[w].charAt(i) && chars[1] == '0' && 1 != crypt[w].length()) {
                        return false;
                    }
                    if (chars[0] == crypt[w].charAt(i)) {
                        sum.append(Character.getNumericValue(chars[1]));
                        break;
                    }
                }
            }
            words[w] = sum.toString();
        }
        return Long.parseLong(words[0]) + Long.parseLong(words[1]) == Long.parseLong(words[2]);
    }

    static int robberHouse(int[] nums) {

        int result = 0;
        int resultOther = 0;

        for (int i = 0; i < nums.length; i++) {
            resultOther = Math.max(nums[i] + result, result = resultOther);
        }

        return resultOther;

    }

    static String[] composeRanges(int[] nums) {


        int start = 0;
        List<String> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] + 1 != nums[i + 1]) {
                if (nums[start] == nums[i]) {
                    list.add(String.valueOf(nums[start]));
                } else {
                    list.add(nums[start] + "->" + nums[i]);
                }
                start = i + 1;
            } else if (i == nums.length - 1 && start == i) {
                list.add(String.valueOf(nums[i]));
            } else if (i == nums.length - 1) {
                list.add(nums[start] + "->" + nums[i]);
            }
        }
        return list.stream().toArray(String[]::new);

    }

    static String prefixPalindrome(String s) {

        String prefix = String.valueOf(s.charAt(0));
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                prefix += String.valueOf(s.charAt(i));
            } else {
                break;
            }
        }

        if (prefix.length() < 2) {
            return s;
        } else {
            s = s.replace(prefix, "");
        }

        return isPalindrom(s) ? "" : s;

    }

    static boolean isPalindrom(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString().equals(s);
    }

}
