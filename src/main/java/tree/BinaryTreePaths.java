package tree;

import java.util.*;

public class BinaryTreePaths {

    public static void main(String[] args) {
        TreeNode asd = new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null));
        System.out.println(Arrays.toString(printRootToLeafPath2(asd).toArray()));
    }

    public static void printRootToLeafPath(TreeNode node, Deque<Integer> path) {
        if (node == null) {
            return;
        }

        path.addLast(node.val);

        if (isLeaf(node)) {
            System.out.println(path);
        }

        printRootToLeafPath(node.left, path);
        printRootToLeafPath(node.right, path);

        path.removeLast();
    }

    public static List<String> printRootToLeafPath2(TreeNode node) {
        List<String> asd = new ArrayList<>();
        printRootToLeafPath2(node, new ArrayDeque<>(), asd);
        return asd;
    }

    public static void printRootToLeafPath2(TreeNode node, Deque<Integer> path, List<String> paths) {
        if (node == null) {
            return;
        }

        path.addLast(node.val);

        if (isLeaf(node)) {
            StringBuilder as = new StringBuilder();
            for (Integer a : path) {
                as.append(a);
                as.append("->");
            }
            as.delete(as.length() - 2, as.length());
            paths.add(as.toString());
        }

        printRootToLeafPath2(node.left, path, paths);
        printRootToLeafPath2(node.right, path, paths);

        path.removeLast();
    }

    public static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
