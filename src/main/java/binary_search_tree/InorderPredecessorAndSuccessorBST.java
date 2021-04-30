package binary_search_tree;

public class InorderPredecessorAndSuccessorBST {


    // search for the given node in the tree and update the predecessor
    // to the current node before visiting its right subtree
    public static Node predecessor(Node root, Node prec, int key) {
        // base case
        if (root == null) {
            return null;
        }

        // if a node with the desired value is found, the predecessor is the maximum
        // value node in its left subtree (if any)
        if (key == root.data) {
            if (root.left != null) {
                return TreeBasicOperations.maximum(root.left);
            }
        }
        // if the given key is more than the root node, recur for the right subtree
        else if (key > root.data) {
            // update predecessor to the current node before recursing
            // in the right subtree
            prec = root;
            return predecessor(root.right, prec, key);

            // if the given key is less than the root node, recur for the left subtree
        } else {
            return predecessor(root.left, prec, key);
        }

        return prec;
    }

    // search for the given node in the tree and update the successor to the current node before
    // visiting it`s left subtree
    public static Node successor(Node root, Node succ, int key) {

        // base case
        if (root == null) {
            return null;
        }

        if (key == root.data) {
            // if it has a right tree get the min in that one
            if (root.right != null) {
                return TreeBasicOperations.minimum(root.right);
            }
        }

        // if the given key is less than the current node, recur for the left subtree
        else if (key < root.data) {
            // update successor to the current node before recursing in the left subtree
            succ = root;
            return successor(root.left, succ, key);

        }
        // if the given key is more than the root node, recur for the right subtree
        else return successor(root.right, succ, key);

        return succ;
    }

}
