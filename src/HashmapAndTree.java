import java.util.LinkedList;
import java.util.*;

public class HashmapAndTree {
    public static void main(String[] args) {
        /*String[][] dishes = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};

        System.out.println(" >> " + Arrays.deepToString(groupingDishes(dishes)));*/

        /*String[] strings = {"aaa", "aaa", "aaa"};
        String[] patterns = {"aaa", "bbb", "aaa"};
        System.out.println(" >> " + areFollowingPatterns(strings, patterns));*/

        /*int[] nums = {0, 1, 2, 3, 5, 2};
        System.out.println(" >> " + containsCloseNums(nums, 3));*/

        possibleCoinSums();

    }

    static String[][] groupingDishes(String[][] dishes) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < dishes.length; i++) {
            String[] arr = dishes[i];
            for (int j = 1; j < arr.length; j++) {
                List<String> list;
                if (!map.containsKey(arr[j])) {
                    list = new LinkedList<>();
                } else {
                    list = map.get(arr[j]);
                }
                list.add(dishes[i][0]);
                map.put(arr[j], list);
            }
        }

        Map<String, List<String>> map2 = new TreeMap<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() >= 2) {
                Collections.sort(map.get(key));
                map2.put(key, map.get(key));
            }
        }

        String[][] result = new String[map2.size()][];
        List<String> l = new LinkedList<>(map2.keySet());

        for (int i = 0; i < l.size(); i++) {
            List<String> temp = map2.get(l.get(i));
            temp.add(0, l.get(i));
            String[] row = temp.toArray(new String[temp.size()]);
            result[i] = row;
        }

        return result;
    }

    static boolean areFollowingPatterns(String[] strings, String[] patterns) {

        if (strings.length != patterns.length) {
            return false;
        }

        Map<String, String> map = new Hashtable<>();

        for (int i = 0; i < strings.length; i++) {
            String pattern = patterns[i];
            if (map.containsKey(pattern)) {
                if (!map.get(pattern).equals(strings[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(strings[i])) {
                    return false;
                }
            }
            map.put(pattern, strings[i]);
        }
        return true;

    }

    static boolean containsCloseNums(int[] nums, int k) {

        Map<Integer, Integer> map = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int j = map.get(nums[i]);
                if ((i - j) <= k) {
                    return true;
                }
                map.put(nums[i], i);
            }
        }
        return false;

    }

    static int possibleCoinSums() {

        int[] coins = {10, 50, 100};
        int[] quantity = {1, 2, 1};

        Set<Integer> table = new HashSet<>();
        table.add(0);
        for (int i = 0; i < quantity.length; i++) {
            List<Integer> sums = new ArrayList<>(table);
            for (Integer k : sums) {
                for (int l = 1; l <= quantity[i]; l++) {
                    table.add(k + l * coins[i]);
                }
            }
        }
        return table.size() - 1;
    }

    String swapLexOrder(String str, int[][] pairs) {

        // If 1 can swap with 3, and 3 can swap with 4, then 1 can eventually swap with 4. Transitive.
        // For this reason we can build a graph -- connected components that have all the positions of possible
        // would-be swaps.
        // We end up just putting the sorted letters (vertices) in the positions that would be possible to swap them to.

        // 1. Build adjacency list (beginner/intermediate graph theory)
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
        for (int[] pair : pairs) {
            var A_vertex = pair[0];
            var B_vertex = pair[1];

            if (!adjacencyLists.containsKey(A_vertex)) {
                adjacencyLists.put(A_vertex, new ArrayList<>());
            }

            if (!adjacencyLists.containsKey(B_vertex)) {
                adjacencyLists.put(B_vertex, new ArrayList<>());
            }

            adjacencyLists.get(A_vertex).add(B_vertex);
            adjacencyLists.get(B_vertex).add(A_vertex);
        }

        // 2. Create connected components (beginner/intermediate graph theory). I'm using breadth-first search for no reason in particular. This solution could use BFS or DFS -- queue or stack respectively. Just flip a coin.
        var visited = new HashSet<>();
        Set<List<Integer>> connectedComponents = new HashSet<>();
        for (Integer vertex : adjacencyLists.keySet()) {
            if (visited.contains(vertex)) {
                continue;
            }

            List<Integer> currentConnectedComponent = new ArrayList<>();
            connectedComponents.add(currentConnectedComponent);
            Deque<Integer> vertexQueue = new ArrayDeque<>();
            vertexQueue.add(vertex);

            while (vertexQueue.size() != 0) {
                var currentVertex = vertexQueue.remove();

                if (visited.contains(currentVertex)) {
                    continue;
                }

                for (var adjacentVertex : adjacencyLists.get(currentVertex)) {
                    vertexQueue.add(adjacentVertex);
                }

                currentConnectedComponent.add(currentVertex);
                visited.add(currentVertex);
            }
        }

        // 3. Get characters in connected component (connected component = valid swap positions -- connected by swaps) then sort letters in reverse order, then place back into those positions.
        char[] newString = str.toCharArray();
        List<Character> vertexCharacters = new ArrayList<>();
        for (var connectedComponent : connectedComponents) {
            Collections.sort(connectedComponent);
            for (var index : connectedComponent) {
                vertexCharacters.add(newString[index - 1]);
            }

            Collections.sort(vertexCharacters);
            Collections.reverse(vertexCharacters);

            for (var index : connectedComponent) {
                newString[index - 1] = vertexCharacters.get(0);
                vertexCharacters.remove(0);
            }
        }

        return new String(newString);

    }
}
