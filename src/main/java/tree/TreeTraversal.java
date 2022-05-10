package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {


//    public static void main(String[] args) {
//
//        Node root = new Node(new Node(new Node(null, null, 4), new Node(null, null, 6), 5), new Node(new Node(null, null, 8), new Node(null, null, 10), 9), 7);
//
//        inOrderTraversal(root);
//        System.out.println("");
//        System.out.println("________");
//        preOrderTraversal(root);
//        System.out.println("");
//        System.out.println("________");
//        postOrderTraversal(root);
//    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    public static boolean isSameTree(Node p, Node q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }


    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        inOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    public boolean isSymetric(Node root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(Node left, Node right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public List<Integer> preorderTraversal(Node root) {
        return preorderTraversal(root, new ArrayList<Integer>());
    }

    public List<Integer> preorderTraversal(Node node, List<Integer> order) {

        if (node == null) {
            return order;
        }
        order.add(node.val);
        order.addAll(preorderTraversal(node.left, order));
        order.addAll(preorderTraversal(node.right, order));
        return order;
    }

    public List<Integer> postorderTraversal(Node root) {
        return postorderTraversal(root, new ArrayList<Integer>());
    }

    public List<Integer> postorderTraversal(Node node, List<Integer> order) {
        if (node == null) {
            return order;
        }
        order.add(node.val);
        postorderTraversal(node.left, order);
        postorderTraversal(node.right, order);
        return order;
    }

    public static void main(String[] args) {

        Node root = new Node(null, new Node(null, null, 2), 1);

        hasPathSum(root, 1);
    }

    public static boolean hasPathSum(Node root, int targetSum) {
        if (root == null) return false;

        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }


}

class Node {

    Node left;
    Node right;
    int val;

    public Node(Node left, Node right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}