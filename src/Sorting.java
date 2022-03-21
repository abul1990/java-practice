import java.util.Arrays;

public class Sorting {

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11, 3, 75, 21, 33, 27};
        //missingNumber(new int[]{4, 3, 1, 0});
        //System.out.println("Array");
        //printArray(arr);
        //selectionSort(arr);
        //System.out.println("Selection Sort");
        //printArray(arr);
        //System.out.println("Bubble Sort");
        //bubbleSort(arr);
        //System.out.println("Insertion Sort");
        //insertionSort(arr);
        //printArray(arr);
        /*System.out.println("Merge Sort");
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);*/
        /*System.out.println("Quick Sort");
        quickSort(arr, 0, arr.length - 1);
        printArray(arr);*/
        System.out.println("Heap Sort");
        heapSort(arr);
        printArray(arr);
    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        //Time: O(n2) Space: O(1) not stable
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    static void bubbleSort(int[] arr) {
        //Time: O(n2) / O(n) Space: O(1)
        int i, j, temp, n = arr.length;
        /*boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (!swapped) {
                break;
            }
        }*/

        //#Approach 2
        int len = arr.length;

        for (i = 0; i < len; i++) {
            for (j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(" >> " + Arrays.toString(arr));

        //return arr;
    }

    static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    /* Function to merge the subarrays of a[] */
    // Time: O(n*logn) Space: O(n)
    /*static void merge(int[] a, int beg, int mid, int end) {
        int i, j, k;
        int n1 = mid - beg + 1;
        int n2 = end - mid;

        int LeftArray[] = new int[n1], RightArray[] = new int[n2]; //temporary arrays

        *//* copy data to temp arrays *//*
        for (i = 0; i < n1; i++) {
            LeftArray[i] = a[beg + i];
        }
        for (j = 0; j < n2; j++) {
            RightArray[j] = a[mid + 1 + j];
        }

        i = 0; *//* initial index of first sub-array *//*
        j = 0; *//* initial index of second sub-array *//*
        k = beg;  *//* initial index of merged sub-array *//*

        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                a[k] = LeftArray[i];
                i++;
            } else {
                a[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            a[k] = LeftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = RightArray[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] a, int beg, int end) {
        if (beg < end) {
            int mid = (beg + end) / 2;
            mergeSort(a, beg, mid);
            mergeSort(a, mid + 1, end);
            merge(a, beg, mid, end);
        }
    }*/

    // A utility function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /* This function takes last element as pivot, places
       the pivot element at its correct position in sorted
       array, and places all smaller (smaller than pivot)
       to left of pivot and all greater elements to right
       of pivot */
    static int partition(int[] arr, int low, int high) {

        // pivot
        int pivot = arr[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (arr[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    /* The main function that implements QuickSort
              arr[] --> Array to be sorted,
              low --> Starting index,
              high --> Ending index
     */
    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void heapSort(int[] arr) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n/2-1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        printArray(arr);

        // One by one extract an element from heap
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // To heapify a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Prints the array
    static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    void merge(int[] sequence, int left, int middle, int right) {
        int[] result = new int[right - left];
        int i, j;
        int k = 0;

        for (i = left, j = middle; i < middle && j < right; ) {
            if (sequence[i] < sequence[j]) {
                result[k++] = sequence[i];
                i++;
            } else {
                result[k++] = sequence[j];
                j++;
            }
        }

        while (i < middle) {
            result[k++] = sequence[i];
            i++;
        }

        while (j < right) {
            result[k++] = sequence[j];
            j++;
        }

        for (i = left; i < right; i++) {
            sequence[i] = result[i - left];
        }
    }

    void split(int[] sequence, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            split(sequence, left, middle);
            split(sequence, middle, right);
            merge(sequence, left, middle, right);
        }
    }

    int[] solution(int[] sequence) {

        split(sequence, 0, sequence.length);

        return sequence;
    }

    static int missingNumber(int[] arr) {

        //#Approach 1
        int n = arr.length;
        int sum = (n * (n + 1)) / 2;

        for (int j : arr) {
            sum -= j;
        }
        return sum;

        /*//#Approach 2
        int result = arr.length;

        for (int i = 0; i < arr.length; i++) {
            result = result ^ i;
            result = result ^ arr[i];
        }
        return result;*/

    }


}
