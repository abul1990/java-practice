import java.util.*;
import java.util.stream.IntStream;

public class LinkedList {

    public static void main(String[] args) {
        SinglyLinkedListNode a1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode a2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode a3 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode a4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode a5 = new SinglyLinkedListNode(5);
        //SinglyLinkedListNode a6 = new SinglyLinkedListNode(6);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        //a5.next = a6;


        SinglyLinkedListNode b1 = new SinglyLinkedListNode(100);
        SinglyLinkedListNode b2 = new SinglyLinkedListNode(100);
        SinglyLinkedListNode b3 = new SinglyLinkedListNode(100);
        //SinglyLinkedListNode b4 = new SinglyLinkedListNode(9999);
        /*SinglyLinkedListNode b5 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode b6 = new SinglyLinkedListNode(3);*/

        b1.next = b2;
        b2.next = b3;


        //displaySLL(deleteSSLByElement(a1, 3));
        /*displaySLL(a1);
        System.out.println();
        displaySLL(b1);
        System.out.println();
        displaySLL(addTwoLinkedListNumbers(a1, b1));
        displaySLL(a1);
        System.out.println();*/
        //displaySLL(reverseKAlone(a1, 1));
        reOrderSSL(a1, 2);
    }

    public List<Integer> dynamicArray() {

        int n = 100;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(0, List.of(1, 345255357, 205970905));
        queries.add(1, List.of(1, 570256166, 75865401));
        queries.add(2, List.of(1, 94777800, 645102173));
        queries.add(3, List.of(1, 227496730, 16649450));
        queries.add(4, List.of(1, 82987157, 1486734305));


        List<Integer> result = new ArrayList<>();
        Integer lastAnswer = 0;
        List<List<Integer>> arr = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> arr.add(i, List.of()));

        for (List<Integer> query : queries) {
            int idx = (query.get(1) ^ lastAnswer) % n;
            if (query.get(0) == 1) {
                List<Integer> temp = new ArrayList<>(arr.get(idx));
                temp.add(query.get(2));
                arr.set(idx, new ArrayList<>(temp));
            } else {
                result.add(arr.get(idx).get(query.get(2) % arr.get(idx).size()));
                lastAnswer = result.get(result.size() - 1);
            }
        }
        System.out.println(" >> " + Collections.max(result));
        return result;

    }

    public void hourGlass() {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(0, List.of(0, -4, -6, 0, -7, -6));
        arr.add(1, List.of(-1, -2, -6, -8, -3, -1));
        arr.add(2, List.of(-8, -4, -2, -8, -8, -6));
        arr.add(3, List.of(-3, -1, -2, -5, -7, -4));
        arr.add(4, List.of(-3, -5, -3, -6, -6, -6));
        arr.add(5, List.of(-3, -6, 0, -8, -6, -7));

        int result = 0;

        for (int i = 0; i < arr.size() - 2; i++) {
            for (int j = 0; j < arr.size() - 2; j++) {
                int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                if (i == 0 && j == 0) {
                    result = sum;
                }
                System.out.println("sum >> " + sum);
                System.out.println("result >> " + result);
                if (sum > result) {
                    result = sum;
                }
            }
        }

        System.out.println("result >> " + result);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> result = new ArrayList<>();

        for (String query : queries) {
            result.add(0);
            for (String str : strings) {
                if (query.equals(str)) {
                    result.set(result.size() - 1, result.get((result.size() - 1)) + 1);
                }
            }
        }
        result.stream().max((o1, o2) -> o1).get();
        return result;


    }

    public static long arrayManipulation() {
        int n = 4000;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(List.of(1079, 1125, 924038));
        queries.add(List.of(166, 3656, 968856));
        queries.add(List.of(3370, 3694, 682059));
        queries.add(List.of(3206, 3587, 542835));
        queries.add(List.of(3290, 3765, 944837));
        List<Long> resultList = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> resultList.add(i, 0L));
        long result = 0;
        int[] indexRange = new int[2];
        long value = 0L;

        /*for (List<Integer> intList : queries) {
            System.out.println("before >> "  + resultList);
            int a = intList.get(0);
            int b = intList.get(1);
            int k = intList.get(2);
            value = resultList.get(a - 1) + k;
            resultList.set(a - 1, value);
            resultList.set(b, resultList.get(b) - k);
            System.out.println("after >> "  + resultList);
        }
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < resultList.size(); i++) {
            sum = sum + resultList.get(i);
            max = Math.max(sum, max);
        }
        System.out.println("result >> "  + resultList);
        System.out.println("max >> "  + max);
        return max;*/

        for (List<Integer> intList : queries) {
            for (int i = intList.get(0); i <= intList.get(1); i++) {
                value = resultList.get(i - 1) + intList.get(2);
                resultList.set(i - 1, value);
                result = Math.max(value, result);
            }
        }
        System.out.println(" >> " + result);
        return result;
    }

    public void oddAndEvenArray() {
        //int[] arr = {1, 2, 3, 4, 5, 6};
        //int[] arr = {2, 1, 4, 3, 6, 5};
        int[] arr = {1, 3, 5, 2, 4, 6};
        int temp;

        System.out.println("before >> " + Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] % 2 != 0) {
                    for (int j = i; j < arr.length; j++) {
                        if (arr[j] % 2 == 0) {
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            break;
                        }
                    }
                }
            } else {
                if (arr[i] % 2 == 0) {
                    for (int j = i; j < arr.length; j++) {
                        if (arr[j] % 2 != 0) {
                            temp = arr[i];
                            arr[i] = arr[j];
                            arr[j] = temp;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("after >> " + Arrays.toString(arr));

    }

    public void sumOfTwoNumbers() {
        int n = 9;
        for (int i = 1; i < n; i++) {
            System.out.println("numbers: " + i + ", " + (9 - i));
        }
    }

    private static class SinglyLinkedListNode {

        private int data;
        private SinglyLinkedListNode next;

        public SinglyLinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

    }

    private void addToSinglyLinkedList() {
        SinglyLinkedListNode head = new SinglyLinkedListNode(10);
        SinglyLinkedListNode first = new SinglyLinkedListNode(20);
        SinglyLinkedListNode second = new SinglyLinkedListNode(30);
        SinglyLinkedListNode third = new SinglyLinkedListNode(40);
        SinglyLinkedListNode fourth = new SinglyLinkedListNode(50);
        SinglyLinkedListNode fifth = new SinglyLinkedListNode(60);

        //Link SLL
        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        displaySLL(head);
        System.out.println();
        displaySLLReverse(head);
        System.out.println();
        int length = lengthSSL(head);
        System.out.println("length -> " + length);
        middleSSL(head, length);
        searchSSL(head, 50);
        insertToSSLByIndex(head, 35, 4);
        //deleteSSLByElement(head, 50);
        displaySLL(head);
        System.out.println();
        deleteSSLByIndex(head, 4);
        displaySLL(head);
        System.out.println();
        reverseSSL(head);
        displaySLL(head);
        System.out.println();
    }

    private static void displaySLL(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        /*while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }*/
        //recursive
        if (current != null) {
            System.out.print(current.data + "->");
            displaySLL(current.next);
        }
    }

    private void displaySLLReverse(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        //recursive
        if (current != null) {
            displaySLLReverse(current.next);
            System.out.print(current.data + "->");
        }
    }

    private static SinglyLinkedListNode reverseSSL(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        Stack<Integer> temp = new Stack<>();

        while (current != null) {
            temp.push(current.data);
            current = current.next;
        }
        current = head;
        while (current != null) {
            current.data = temp.pop();
            current = current.next;
        }
        return head;
    }

    private int lengthSSL(SinglyLinkedListNode head) {
        SinglyLinkedListNode current = head;
        //recursive
        if (current != null) {
            return 1 + lengthSSL(current.next);
        }
        return 0;
    }

    private void middleSSL(SinglyLinkedListNode head, int length) {
        SinglyLinkedListNode current = head;
        int idx = length % 2 == 0 ? length / 2 : length / 2 + 1;
        int counter = 1;
        while (current != null) {
            if (idx == counter) {
                System.out.println("middle idx " + idx + " value " + current.data);
            }
            current = current.next;
            counter++;
        }
    }

    private void searchSSL(SinglyLinkedListNode head, int element) {
        SinglyLinkedListNode current = head;
        int idx = 1;
        while (current != null) {
            if (element == current.data) {
                System.out.println("Element found at " + idx + " value " + current.data);
                break;
            }
            idx++;
            current = current.next;
        }
    }

    private SinglyLinkedListNode insertToSSLByIndex(SinglyLinkedListNode head, int element, int idx) {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(element);
        if (head == null) {
            return newNode;
        }
        for (int i = 1; i < idx - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    private static SinglyLinkedListNode deleteSSLByElement(SinglyLinkedListNode head, int element) {
        /*SinglyLinkedListNode current = head;
        int idx = 1;
        while (current != null) {
            if (element == current.data) {
                System.out.println("Delete found at " + idx + " value " + current.data);
                if (current.next != null) {
                    current.data = current.next.data;
                    if (current.next.next != null) {
                        current.next = current.next.next;
                        current = current.next;
                    }
                }
            }
            idx++;
            current = current.next;
        }*/

        //return head;

        if (head == null) {
            return head;
        }
        while (head.data == element) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }

        SinglyLinkedListNode c = head;
        while (c.next != null) {
            if ((int) (c.next.data) == element) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return head;
    }

    private SinglyLinkedListNode deleteSSLByIndex(SinglyLinkedListNode head, int index) {
        SinglyLinkedListNode current = head;
        int counter = 0;
        while (counter < index - 1) {
            current = current.next;
            counter++;
        }
        current.next = current.next.next;
        return head;

        /*int k = index-1;
        SinglyLinkedListNode temp = head;
        while(k != 0){
            temp = temp.next;
            k--;
        }
        temp.next = temp.next.next;
        return head;*/

    }

    static boolean isListPalindrome(SinglyLinkedListNode l) {
        SinglyLinkedListNode reverse = l;
        Stack<Integer> temp = new Stack<>();

        while (reverse != null) {
            temp.push(reverse.data);
            reverse = reverse.next;
        }
        while (l != null) {
            if (l.data == temp.pop()) {
                reverse = reverse.next;
            } else {
                return false;
            }
        }
        return true;
    }

    static SinglyLinkedListNode addTwoLinkedListNumbers(SinglyLinkedListNode a, SinglyLinkedListNode b) {

        SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        SinglyLinkedListNode reva = reverseSSL(a);
        SinglyLinkedListNode revb = reverseSSL(b);
        SinglyLinkedListNode c = result;
        int carry = 0;
        while (reva != null || revb != null) {
            int a1 = (reva != null) ? reva.data : 0;
            int b1 = (revb != null) ? revb.data : 0;

            int sum = a1 + b1 + carry;
            carry = sum / 10000;
            int lastDigit = sum % 10000;
            c.next = new SinglyLinkedListNode(lastDigit);
            if (reva != null) {
                reva = reva.next;
            }
            if (revb != null) {
                revb = revb.next;
            }
            c = c.next;
        }

        if (carry > 0) {
            c.next = new SinglyLinkedListNode(carry);
        }

        displaySLL(result.next);
        System.out.println();
        return reverseSSL(result.next);
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        if (head1.data < head2.data) {
            head1.next = mergeLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeLists(head1, head2.next);
            return head2;
        }
    }

    static SinglyLinkedListNode reverseKAlone(SinglyLinkedListNode l, int k) {
        SinglyLinkedListNode current = l;
        int i = 0;
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }

        current = l;
        SinglyLinkedListNode prev = null, next = null;

        while (current != null && i < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        count -= k;

        if (next != null && count > k) {
            l.next = reverseKAlone(next, k);
        } else {
            l.next = current;
        }

        return prev;




        /*SinglyLinkedListNode result = new SinglyLinkedListNode(0);
        result.next = l;
        int count = 0;

        SinglyLinkedListNode temp = l;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        temp = result;
        while (temp.next != null) {
            if (count < k) {
                break;
            }
            int nodes = k - 1;
            SinglyLinkedListNode tempNext = temp.next;
            SinglyLinkedListNode first = temp.next;
            SinglyLinkedListNode second = first.next;
            while (nodes-- > 0) {
                SinglyLinkedListNode next = second.next;
                second.next = first;
                first = second;
                second = next;
            }
            count -= k;
            temp.next = first;
            tempNext.next = second;
            temp = tempNext;
        }

        return result.next;*/
    }

    static SinglyLinkedListNode reOrderSSL(SinglyLinkedListNode l, int n) {

        if (l == null || n == 0) {
            return l;
        }
        int count = 0;
        SinglyLinkedListNode current = l;
        SinglyLinkedListNode tail = null;
        SinglyLinkedListNode newHead = null;
        while (current != null) {
            tail = current;
            current = current.next;
            count++;
        }
        if (n >= count) {
            return l;
        }
        int acc = 0;
        int mark = count - n - 1;
        current = l;

        while (acc < mark) {
            current = current.next;
            acc++;
        }
        tail.next = l;
        newHead = current.next;
        current.next = null;
        return newHead;
    }

    public static SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode reverseL1 = reverse(l1);
        SinglyLinkedListNode reverseL2 = reverse(l2);

        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        SinglyLinkedListNode current = dummy;
        int carry = 0;

        while (reverseL1 != null || reverseL2 != null) {
            int sum = carry;
            if (reverseL1 != null) {
                sum += reverseL1.data;
                reverseL1 = reverseL1.next;
            }
            if (reverseL2 != null) {
                sum += reverseL2.data;
                reverseL2 = reverseL2.next;
            }

            carry = sum / 10;
            current.next = new SinglyLinkedListNode(sum % 10);
            current = current.next;
        }

        if (carry > 0) {
            current.next = new SinglyLinkedListNode(carry);
        }

//        SinglyLinkedListNode result = dummy.next;

        return dummy.next;

    }

    public static SinglyLinkedListNode addTwoNumbersSol(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        SinglyLinkedListNode dummyHead = new SinglyLinkedListNode(0);
        SinglyLinkedListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            carry = sum / 10;
            tail.next = new SinglyLinkedListNode(sum % 10);
            tail = tail.next;
        }

        return dummyHead.next;
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode node) {
        SinglyLinkedListNode reverse = null;
        SinglyLinkedListNode next;
        while (node != null) {
            next = node.next;
            node.next = reverse;
            reverse = node;
            node = next;
        }
        return reverse;
    }
}
