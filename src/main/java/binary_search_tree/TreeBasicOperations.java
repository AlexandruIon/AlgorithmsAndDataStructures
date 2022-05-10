package binary_search_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBasicOperations {

    public void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    public void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public void levelOrderTraversal(Node rootNode) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> inOrderTraversal = new ArrayList<>();
        if (rootNode != null) {
            queue.add(rootNode);
        }
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            inOrderTraversal.add(node.data);

        }
        System.out.println(inOrderTraversal);
    }

    public static Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public static Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public Node search(Node root, int x) {
        if (root == null) {
            return null;
        }
        if (root.data > x)
            return search(root.left, x);
        else if (root.data < x)
            return search(root.right, x);
        else return root;
    }

    public Node insert(Node root, int key) {
        // if the root is null, create a new root and return it
        if (root == null) {
            return new Node(key);
        }
        // if the given key is less than the root node, recur for the left subtree
        if (root.data > key) {
            root.left = insert(root.left, key);
            // if the given key is more than te root node, recur for the right subtree
        } else if (root.data < key) {
            root.right = insert(root.right, key);
        }
        return root;

    }

    public Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        return x;
    }

}
