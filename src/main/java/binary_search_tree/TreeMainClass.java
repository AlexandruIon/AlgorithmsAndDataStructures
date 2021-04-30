package binary_search_tree;

public class TreeMainClass {

    public static void main(String[] args) {

        TreeBasicOperations treeBasicOperations = new TreeBasicOperations();

        // test tree creation
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for (int key : keys) {
            root = treeBasicOperations.insert(root, key);
        }

        treeBasicOperations.inOrderTraversal(root);
        Node search = treeBasicOperations.search(root, 25);
        System.out.println("search " + search.data);

    }

}
