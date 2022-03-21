import java.util.*;

public class HeapImpl {

    int arr[] = new int[20];
    int size = 0;

    void insertNewValueMaxHeap(int newValue) {
        arr[size] = newValue;
        int index = size;
        int parent = (index - 1) / 2;

        while (parent >= 0 && arr[parent] < arr[index]) {
            int temp = arr[parent];
            arr[parent] = arr[index];
            arr[index] = temp;

            temp = parent;
            index = parent;
            parent = (temp - 2) / 2;
        }
        size++;
        System.out.println("array: " + Arrays.toString(arr));
    }

    int getMax() {
        return arr[0];
    }

    int removeMax() {
        int max = arr[0];
        arr[0] = arr[size - 1];
        arr[size - 1] = 0;
        size = size - 1;
        maxHeapify(0);
        return max;
    }

    void buildMaxHeap(int[] input) {
        this.arr = input;
        this.size = input.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }
        System.out.println("max build >> " + Arrays.toString(this.arr));
    }

    void buildMinHeap(int[] input) {
        this.arr = input;
        this.size = input.length;

        for (int i = size / 2 - 1; i >= 0; i--) {
            minHeapify(i);
        }
        System.out.println("min build >> " + Arrays.toString(this.arr));
    }

    void maxHeapify(int index) {
        int left = 2 * index + 1, right = 2 * index + 2;

        int largest = index;
        if (left < this.size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < this.size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            maxHeapify(largest);
        }
    }

    void minHeapify(int index) {
        int left = 2 * index + 1, right = 2 * index + 2;

        int largest = index;
        if (left < this.size && arr[left] < arr[largest]) {
            largest = left;
        }
        if (right < this.size && arr[right] < arr[largest]) {
            largest = right;
        }
        if (largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            minHeapify(largest);
        }
    }

    void maxHeap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        System.out.println("Before Max heap:");
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
        }
        System.out.println();
        System.out.println("After Max heap:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(heap.peek() + " ");
            heap.poll();
        }
    }

    void minHeap(int[] arr) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        System.out.println("Before Min heap:");
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            System.out.print(heap.peek() + " ");
        }
        System.out.println();
        System.out.println("After Min heap:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(heap.peek() + " ");
            heap.poll();
        }
    }

    int KthLargestMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(arr[i]);
            }
        }
        /*top k largest
        for(int i=0; i<k;i++) {
            minHeap.poll();
        }*/

        return minHeap.peek();
    }

    int KthLargestMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }

    int KthSmallestMinHeap(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    int KthSmallestMaxHeap(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            maxHeap.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(arr[i]);
            }
        }
        return maxHeap.peek();
    }


    PriorityQueue<Integer> streamHeap = new PriorityQueue<>();

    int KthLargestStream(int num, int k) {
        if (streamHeap.size() < k) {
            streamHeap.add(num);
            return streamHeap.size() == k ? streamHeap.peek() : -1;
        }
        if (num > streamHeap.peek()) {
            streamHeap.poll();
            streamHeap.add(num);
        }
        return streamHeap.peek();
    }

    List<Integer> topKFrequentElements(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue));


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.add(entry);
            } else {
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.add(entry);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        return result;
    }

    int connectRopes() {
        int[] ropes = {2, 3, 7, 4};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int rope : ropes) {
            minHeap.add(rope);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int tempCost = minHeap.poll() + minHeap.poll();
            cost = cost + tempCost;
            minHeap.add(tempCost);
        }

        System.out.println("cost >> " + cost);

        return cost;

    }

    public static void main(String[] args) {
        HeapImpl heap = new HeapImpl();
        int[] input = {7, 4, 5, 6, 3, 2, 1}; //{10, 7, 11, 30, 20, 38, 2, 45};
        int k = 6;

        heap.KthLargestMinHeap(input, k);

        //heap.connectRopes();

        //heap.topKFrequentElements(input, k);

        /*for (int j : input) {
            System.out.println(" stream: " + heap.KthLargestStream(j, k));
        }

        System.out.println("min at 3 :" + heap.KthLargestMinHeap(input, k));
        System.out.println("max at 3 :" + heap.KthLargestMaxHeap(input, k));
        System.out.println("min at 3 :" + heap.KthSmallestMaxHeap(input, k));
        System.out.println("max at 3 :" + heap.KthSmallestMaxHeap(input, k));*/

        /*heap.maxHeap(input);
        System.out.println();
        heap.minHeap(input);*/

        /*heap.buildMaxHeap(input);

        heap.buildMinHeap(input);*/

        /*heap.insertNewValueMaxHeap(input[0]);
        heap.insertNewValueMaxHeap(input[1]);
        heap.insertNewValueMaxHeap(input[2]);
        System.out.println("max: " + heap.getMax());

        heap.insertNewValueMaxHeap(input[3]);
        heap.insertNewValueMaxHeap(input[4]);
        System.out.println("max: " + heap.getMax());

        System.out.println("remove: " + heap.removeMax());*/
    }

}
