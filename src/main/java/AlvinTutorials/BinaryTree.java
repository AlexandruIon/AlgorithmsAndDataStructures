package AlvinTutorials;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinaryTree {

    // n = # of nodes
    // time = O(N)
    // space = O(N)


    static List<String> depthFirstSearch(Node root) {
        List<String> results = new ArrayList<>();
        depthFirstSearch(root, results);
        return results;
    }

    static void depthFirstSearch(Node node, List<String> results) {
        if (node == null) return;

        results.add(node.value);
        depthFirstSearch(node.left);
        depthFirstSearch(node.right);
    }

    static List<String> depthFirstSearch2(Node root) {
        if (root == null) return Collections.EMPTY_LIST;
        List<String> leftValues = depthFirstSearch(root.left);
        List<String> rightValues = depthFirstSearch(root.right);
        List<String> results = Arrays.asList(root.value);
        return Stream.concat(results.stream(), Stream.concat(leftValues.stream(), rightValues.stream())).collect(Collectors.toList());
    }

    static List<String> depthFirstSearchIterative(Node root) {
        if (root == null) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Stack<Node> stack = new Stack();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            result.add(node.value);

            if (node.left != null) stack.add(node.left);
            if (node.right != null) stack.add(node.right);
        }

        return result;
    }

    // n = # of nodes
    // Time O(n)
    // Space O(n)
    static List<String> breadthFirstSearch(Node root) {
        List<String> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.value);
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return result;
    }


    // n = # of nodes
    // Time O(n)
    // Space O(n)
    static boolean treeIncludesIterative(Node root, String value) {
        if (root == null) return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.value.equals(value)) return true;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return false;
    }

    static boolean treeIncludes(Node root, String value) {
        if (root == null) return false;

        if (root.value.equals(value)) return true;

        return treeIncludes(root.left, value) || treeIncludes(root.right, value);
    }

    // n = # of nodes
    // Time = O(N)
    // Space = O(N)
    static int treeSum(NodeInt node) {
        if (node == null) return 0;
        return node.value + treeSum(node.left) + treeSum(node.right);
    }

    // n = # of nodes
    // Time = O(n)
    // Space = O(n)
    static int treeMinValue(NodeInt node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(node.value, Math.min(treeMinValue(node.left), treeMinValue(node.right)));
    }

    // node  = # of nodes
    // Time = O(n)
    // Space = O(n)
    static int maxRootToLeaf(NodeInt node) {
        if (node == null) return Integer.MIN_VALUE;

        if (node.left == null && node.right == null) return node.value;

        int left = maxRootToLeaf(node.left);
        int right = maxRootToLeaf(node.right);

        return node.value + Math.max(left, right);
    }


}

class NodeInt {
    int value;
    NodeInt left;
    NodeInt right;

    public NodeInt(int value, NodeInt left, NodeInt right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

class Node {
    String value;
    Node left;
    Node right;

    public Node(String value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}