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


        // test successor
        for (int key : keys) {
            Node succ = InorderPredecessorAndSuccessorBST.successor(root, null, key);
            if (succ != null) {
                System.out.println("The successor of node " + key + " is " + succ.data);
            } else {
                System.out.println("The successor doesn`t exists for key " + key);
            }
        }
        System.out.println("_______________________-------------------____________");

        // test predecessor
        for (int key : keys) {
            Node prec = InorderPredecessorAndSuccessorBST.predecessor(root, null, key);
            if (prec != null) {
                System.out.println("The predecessor of node " + key + " is " + prec.data);
            } else {
                System.out.println("The predecessor doesn`t exists for key " + key);
            }
        }


    }

}
