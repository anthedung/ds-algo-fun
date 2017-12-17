package tree.bst;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

// check if BT is a BST given root
public class BSTValidator {

    // Sol1: maintain the max and min for each subtree
    // anything on left is smaller than MIN_INT and root
    public static boolean isBSTMaxMin(Node root) {
        return checkBSTMaxMinHelper(root, 0, 10000);
    }

    private static boolean checkBSTMaxMinHelper(Node root, int minVal, int maxVal) {
        if (root == null)
            return true;

        if (root.val < minVal || root.val > maxVal) {
            return false;
        }

        return (checkBSTMaxMinHelper(root.left, minVal, root.val - 1)
        && checkBSTMaxMinHelper(root.right, root.val+1, maxVal));
    }


    public static boolean checkBSTInOrder(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        visit(root, inOrder);

        //System.out.println(inOrder.size());
        for (int i = 0; i < inOrder.size() - 1 ; i++) {
            //System.out.println(inOrder.get(i));
            if (inOrder.get(i) >= inOrder.get(i+1)) {
                //System.out.println(inOrder.get(i) + ":"+inOrder.get(i));
                return false;
            }
        }

        return true;
    }

    public static void visit(Node root, List<Integer> inOrder) {
        if (root == null) return;
        if (root.left != null) visit(root.left, inOrder);
        inOrder.add(root.val);
        if (root.right != null) visit(root.right, inOrder);

        return;
    }
}
