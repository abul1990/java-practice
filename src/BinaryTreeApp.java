import java.util.*;

public class BinaryTreeApp {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();
        System.out.println("result >> " + Arrays.toString(bst.findSubstrings(new String[]{"neuroses",
                        "myopic",
                        "sufficient",
                        "televise",
                        "coccidiosis",
                        "gules",
                        "during",
                        "construe",
                        "establish",
                        "ethyl"},
                new String[]{"aaaaa",
                        "Aaaa",
                        "E",
                        "z",
                        "Zzzzz",
                        "a",
                        "mel",
                        "lon",
                        "el",
                        "An",
                        "ise",
                        "d",
                        "g",
                        "wnoVV",
                        "i",
                        "IUMc",
                        "P",
                        "KQ",
                        "QfRz",
                        "Xyj",
                        "yiHS"})));
        /*Node root = null;
        root = bst.insert(root, 3);
        root = bst.insert(root, 1);
        root = bst.insert(root, 5);
        root = bst.insert(root, 4);
        root = bst.insert(root, 6);
        *//*root = bst.insert(root, 7);
        root = bst.insert(root, 10);
        root = bst.insert(root, 14);
        root = bst.insert(root, 13);*//*

        System.out.println("BST in-order -> ");
        bst.inOrderBST(root);
        System.out.println();
        root = bst.delete(root, 1);
        System.out.println("BST pre-order -> ");
        bst.preOrderBST(root);
        //root = bst.delete(root, 14); not working
        System.out.println();
        System.out.println("BST post-order -> ");
        bst.postOrderBST(root);
        System.out.println("Found -> " + bst.findNodeInBST(root, 6));
        System.out.println(" >> " + bst.kthSmallestBST(root, 4));

        System.out.println("Restored tree");
        bst.inOrderBST(bst.reStoreTree(new int[]{4, 2, 1, 5, 3, 6}, new int[]{1, 2, 4, 3, 5, 6}));*/

        /*BinaryTree binaryTree = new BinaryTree();
        Node root = binaryTree.createNode(4);
        root.left = binaryTree.createNode(1);
        root.right = binaryTree.createNode(3);
        root.left.left = binaryTree.createNode(-2);
        root.left.left.right = binaryTree.createNode(3);
        root.right.left = binaryTree.createNode(3);
        root.right.right = binaryTree.createNode(2);
        root.right.right.left = binaryTree.createNode(-2);
        root.right.right.right = binaryTree.createNode(3);
        System.out.print("In Order -> ");
        binaryTree.inOrder(root);
        System.out.println("Path sum -> " + binaryTree.hasPathGivenSum(root, 7, 0));
        System.out.print("In Order Stack -> ");
        binaryTree.inOrderUsingStack(root);
        System.out.println();
        System.out.print("Pre Order -> ");
        binaryTree.preOrder(root);
        System.out.print("Pre Order Stack -> ");
        binaryTree.preOrderUsingStack(root);
        System.out.println();
        System.out.print("Post Order -> ");
        binaryTree.postOrder(root);
        System.out.print("Mirror Tree -> ");
        binaryTree.inOrder(binaryTree.mirrorOfTree(root));
        System.out.print("Delete Tree -> ");
        binaryTree.deleteTree(root);
        System.out.print("Identical Tree -> " + binaryTree.isIdenticalTree(root, root));
        System.out.println();
        System.out.println("Sum of nodes-> " + binaryTree.sumOfNodes(root));
        System.out.println("Num of nodes-> " + binaryTree.numOfNodes(root));
        System.out.println("Leaf of nodes-> " + binaryTree.leafNodes(root));
        System.out.println("Height of nodes-> " + binaryTree.heightOfNodes(root));
        System.out.println("Print level nodes-> ");
        binaryTree.printFromGivenLevel(root, 2);
        System.out.println();
        System.out.println("Print element level -> ");
        binaryTree.printElementsLevel(root);
        System.out.println("Print element using queue -> ");
        binaryTree.printElementsUsingQueue(root);
        System.out.println();
        System.out.println("Print element reverse -> ");
        binaryTree.printElementsLevelReverse(root);
        System.out.println("Print element reverse using queue & stack -> ");
        binaryTree.printElementsReverseUsingStack(root);
        System.out.println();
        System.out.println("Print element level using queue -> ");
        binaryTree.printElementsLevelUsingQueue(root);
        System.out.println();
        System.out.println("Print element level reverse using queue & stack -> ");
        binaryTree.printElementsLevelReverseUsingStack(root);
        System.out.println();
        System.out.println("Left view -> ");
        binaryTree.leftViewOfTree(root, 0);
        System.out.println();
        System.out.println("Right view -> ");
        binaryTree.rightViewOfTree(root, 0);*/
    }
}

class BinaryTree {
    public Node createNode(int data) {
        Node node = new Node(data);
        return node;
    }

    void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + ", ");
        inOrder(node.right);
    }

    void inOrderUsingStack(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        while (node != null) {
            nodeStack.push(node);
            node = node.left;
        }
        while (nodeStack.size() > 0) {
            Node temp = nodeStack.pop();
            System.out.print(temp.data + ", ");
            if (temp.right != null) {
                Node tempRight = temp.right;
                while (tempRight != null) {
                    nodeStack.push(tempRight);
                    tempRight = tempRight.right;
                }
            }
        }
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void preOrderUsingStack(Node node) {
        if (node == null) {
            return;
        }
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (nodeStack.size() > 0) {
            Node temp = nodeStack.pop();
            System.out.print(temp.data + ", ");
            if (temp.right != null) {
                nodeStack.push(temp.right);
            }
            if (temp.left != null) {
                nodeStack.push(temp.left);
            }
        }
    }

    void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + ", ");
    }

    int sumOfNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    int numOfNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + numOfNodes(node.left) + numOfNodes(node.right);
    }

    int leafNodes(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return leafNodes(node.left) + leafNodes(node.right);
    }

    int heightOfNodes(Node node) {
        if (node == null) {
            return -1;
        }
        return Math.max(heightOfNodes(node.left), heightOfNodes(node.right)) + 1;
    }

    void printFromGivenLevel(Node node, int level) {
        if (node == null) {
            return;
        }

        if (level == 1) {
            System.out.print(node.data + ", ");
            return;
        }
        printFromGivenLevel(node.left, level - 1);
        printFromGivenLevel(node.right, level - 1);
    }

    void printElementsLevel(Node node) {
        if (node == null) {
            return;
        }
        int height = heightOfNodes(node);
        for (int i = 0; i <= height; i++) {
            printFromGivenLevel(node, i + 1);
            System.out.println();
        }
    }

    void printElementsLevelReverse(Node node) {
        if (node == null) {
            return;
        }
        int height = heightOfNodes(node);
        for (int i = height; i >= 0; i--) {
            printFromGivenLevel(node, i + 1);
            System.out.println();
        }
    }

    void printElementsUsingQueue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(node);
        while (nodeQueue.size() > 0) {
            Node top = nodeQueue.remove();
            System.out.print(top.data + ", ");
            if (top.left != null) {
                nodeQueue.add(top.left);
            }
            if (top.right != null) {
                nodeQueue.add(top.right);
            }
        }
    }

    void printElementsLevelUsingQueue(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(node);
        while (true) {
            int size = nodeQueue.size();
            if (size == 0) {
                break;
            }
            while (size > 0) {
                Node top = nodeQueue.remove();
                System.out.print(top.data + ", ");
                if (top.left != null) {
                    nodeQueue.add(top.left);
                }
                if (top.right != null) {
                    nodeQueue.add(top.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    void printElementsReverseUsingStack(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(node);
        Stack<Node> nodeStack = new Stack<>();
        while (nodeQueue.size() > 0) {
            Node top = nodeQueue.remove();
            if (top.right != null) {
                nodeQueue.add(top.right);
            }
            if (top.left != null) {
                nodeQueue.add(top.left);
            }
            nodeStack.push(top);
        }
        while (nodeStack.size() > 0) {
            System.out.print(nodeStack.pop().data + ", ");
        }
    }

    void printElementsLevelReverseUsingStack(Node node) {
        if (node == null) {
            return;
        }
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(node);
        Stack<Node> nodeStack = new Stack<>();
        while (true) {
            int size = nodeQueue.size();
            if (size == 0) {
                break;
            }
            while (size > 0) {
                Node top = nodeQueue.remove();
                if (top.right != null) {
                    nodeQueue.add(top.right);
                }
                if (top.left != null) {
                    nodeQueue.add(top.left);
                }
                nodeStack.push(top);
                size--;
            }
        }

        while (nodeStack.size() > 0) {
            System.out.print(nodeStack.pop().data + ", ");
        }
    }

    int maxLevel = 0;
    int maxLevelRight = 0;

    void leftViewOfTree(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level >= maxLevel) {
            System.out.print(node.data + ", ");
            maxLevel++;
        }
        leftViewOfTree(node.left, level + 1);
        leftViewOfTree(node.right, level + 1);
    }

    void rightViewOfTree(Node node, int level) {
        if (node == null) {
            return;
        }
        if (level >= maxLevelRight) {
            System.out.print(node.data + ", ");
            maxLevelRight++;
        }
        rightViewOfTree(node.right, level + 1);
        rightViewOfTree(node.left, level + 1);
    }

    Node mirrorOfTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorOfTree(node.left);
        mirrorOfTree(node.right);
        return node;
    }

    Node deleteTree(Node node) {
        if (node == null) {
            return null;
        }

        node.left = deleteTree(node.left);
        node.right = deleteTree(node.right);
        System.out.println("Deleting node -> " + node.data);
        return node;
    }

    boolean isIdenticalTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node2.data && isIdenticalTree(node1.left, node2.left)
                && isIdenticalTree(node1.right, node2.right);
    }

    // --Code Signal region--//

    boolean hasPathGivenSum(Node node, int sum, int pathSum) {
        if (node == null) {
            return false;
        }
        pathSum += node.data;

        if (pathSum == sum && node.left == null && node.right == null) {
            return true;
        }

        System.out.println("pathsum -> " + pathSum);

        return hasPathGivenSum(node.left, sum, pathSum) || hasPathGivenSum(node.right, sum, pathSum);
    }

    boolean isTreeSymmetric(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.data == node1.data && isTreeSymmetric(node1.left, node2.right)
                && isTreeSymmetric(node1.right, node2.left);
    }

    String findProfession(int level, int pos) {
        if (level == 1) {
            return "Engineer";
        }

        if (findProfession(level - 1, (pos + 1) / 2) == "Doctor") {
            return (pos % 2) > 0 ? "Doctor" : "Engineer";
        }

        return (pos % 2) > 0 ? "Engineer" : "Doctor";
    }

}

class BinarySearchTree {

    public Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }

    public Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }
        if (data < node.data) {
            node.left = delete(node.left, data);
        } else if (data > node.data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null || node.right == null) {
                Node temp = node.left == null ? node.right : node.left;
                if (temp == null) {
                    return null;
                } else {
                    return node;
                }
            } else {
                Node successor = getSuccessor(node);
                node.data = successor.data;
                node.right = delete(node.right, successor.data); //not working

            }
        }
        return node;
    }

    Node getSuccessor(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.right;
        while (temp.left != null) {
            temp = temp.left;
        }
        return node;
    }

    void inOrderBST(Node node) {
        if (node == null) {
            return;
        }
        inOrderBST(node.left);
        System.out.print(node.data + ", ");
        inOrderBST(node.right);
    }

    void preOrderBST(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + ", ");
        inOrderBST(node.left);
        inOrderBST(node.right);
    }

    void postOrderBST(Node node) {
        if (node == null) {
            return;
        }
        inOrderBST(node.left);
        inOrderBST(node.right);
        System.out.print(node.data + ", ");
    }

    boolean findNodeInBST(Node node, int val) {
        boolean isPresent = false;
        if (node == null) {
            return isPresent;
        }
        while (node != null) {
            if (val < node.data) {
                node = node.left;
            } else if (val > node.data) {
                node = node.right;
            } else {
                isPresent = true;
                break;
            }
        }
        return isPresent;
    }

    List<Integer> list = new ArrayList<>();

    List<Integer> kthSmallestBST(Node node, int k) {
        if (node == null) {
            return list;
        }
        kthSmallestBST(node.left, k);
        list.add(node.data);
        kthSmallestBST(node.right, k);

        return list;

        /*if (node == null) {
            return -1;
        }
        int left = kthSmallestBST(node.left, k, counter);

        if (left != -1) {
            return left;
        }
        counter++;
        if (counter == k) {
            return node.data;
        }

        return kthSmallestBST(node.right, k, counter);*/

    }

    boolean isSubTree(Node tree, Node subTree) {
        if (subTree == null) {
            return true;
        }
        if (tree == null) {
            return false;
        }

        if (isIdenticalTree(tree, subTree)) {
            return true;
        }
        return (isSubTree(tree.left, subTree) || isSubTree(tree.right, subTree));

    }

    boolean isIdenticalTree(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.data == node2.data) && isIdenticalTree(node1.left, node2.left)
                && isIdenticalTree(node1.right, node2.right);
    }

    boolean lookAtTree(Node t1, Node t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        if (checkTree(t1, t2)) {
            return true;
        }
        return (lookAtTree(t1.left, t2) || lookAtTree(t1.right, t2));
    }

    boolean checkTree(Node t1, Node t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return ((t1.data == t2.data) && checkTree(t1.left, t2.left) && checkTree(t1.right, t2.right));
    }

    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int preIndex = 0;

    Node reStoreTree(int[] inorder, int[] preorder) {

        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    Node buildTree(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node node = new Node(preorder[preIndex++]);

        if (node == null) {
            return null;
        }
        if (start == end) {
            return node;
        }
        int index = inOrderMap.get(node.data);

        node.left = buildTree(preorder, inorder, start, index - 1);
        node.right = buildTree(preorder, inorder, index + 1, end);
        return node;
    }


    // Function to delete a node from a BST
    public static Node deleteNode(Node root, int key) {
        // base case: the key is not found in the tree
        if (root == null) {
            return null;
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        }

        // if the given key is more than the root node, recur for the right subtree
        else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }

        // key found
        else {
            // Case 1: node to be deleted has no children (it is a leaf node)
            if (root.left == null && root.right == null) {
                // update root to null
                return null;
            }

            // Case 2: node to be deleted has two children
            else if (root.left != null && root.right != null) {
                // find its inorder predecessor node
                Node predecessor = findMaximumKey(root.left);

                // copy value of the predecessor to the current node
                root.data = predecessor.data;

                // recursively delete the predecessor. Note that the
                // predecessor will have at most one child (left child)
                root.left = deleteNode(root.left, predecessor.data);
            }

            // Case 3: node to be deleted has only one child
            else {
                // choose a child node
                Node child = (root.left != null) ? root.left : root.right;
                root = child;
            }
        }

        return root;
    }

    public static Node findMaximumKey(Node ptr) {
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        return ptr;
    }

    String[] findSubstrings(String[] words, String[] parts) {

        if (parts.length == 0 || words.length == 0) {
            return words;
        }

        String[] result = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            String temp = "";
            for (String part : parts) {
                if (words[i].contains(part)) {
                    if (temp.length() == 0 || temp.length() > part.length() ||
                            (words[i].indexOf(temp) > words[i].indexOf(part) && temp.length() == part.length())) {
                        temp = part;
                    }
                }
            }
            if (temp.length() > 0) {
                result[i] = words[i].replaceFirst(temp, "[" + temp + "]");
            } else {
                result[i] = words[i];
            }
        }

        return result;

    }


}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
