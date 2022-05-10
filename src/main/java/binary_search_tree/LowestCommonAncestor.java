package binary_search_tree;

public class LowestCommonAncestor {


    public static Node lowestCommonAncestor(Node root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        if (root.data > key1 && root.data < key2) {
            return root;
        } else if (root.data > key1 && root.data > key2) {
            return lowestCommonAncestor(root.left, key1, key2);
        } else {
            return lowestCommonAncestor(root.right, key1, key2);
        }
    }

    public static Node LCA(Node root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        if (root.data > Integer.max(key1, key2)) return LCA(root.left, key1, key2);

        if (root.data < Integer.min(key1, key2)) return LCA(root.right, key1, key2);

        return root;
    }


    public static void main(String[] args) {

        TreeBasicOperations treeBasicOperations = new TreeBasicOperations();

        // test tree creation
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for (int key : keys) {
            root = treeBasicOperations.insert(root, key);
        }

        Node lca = lowestCommonAncestor(root, 8, 12);
        System.out.println(lca.data);

    }
}
