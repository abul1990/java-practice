import java.util.*;
import java.util.stream.Collectors;

public class HackerEarth {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int q = scanner.nextInt();

        int[][] lr = new int[q][2];*/

        sumOfFrequency(8, 4);

    }

    public static void sumOfFrequency(int n, int q) {

        int[] arr = {4, 4, 6, 5, 3, 3, 3, 9};
        int[][] lr = {{1, 4}, {2, 7}, {3, 7}, {5, 6}};

        Map<Integer, Integer> occurrence = new HashMap<>();


        for (int i = 0; i < n; i++) {
            occurrence.put(arr[i], occurrence.getOrDefault(arr[i], 0) + 1);
        }

        for (int i = 0; i < q; i++) {
            int min = lr[i][0];
            int max = lr[i][1];
            final int[] sum = {0};

            occurrence.forEach((key, value) -> {
                if (value >= min && value <= max) {
                    sum[0] = sum[0] + (value * key);
                }
            });

            System.out.println(sum[0]);

            /*List<Integer> result = occurrence.entrySet().stream()
                    .filter(entry -> entry.getValue() >= min && entry.getValue() <= max)
                    .map(entry -> (entry.getValue() * entry.getKey()))
                    .collect(Collectors.toList());

            System.out.println(result);*/

        }

    }
}
