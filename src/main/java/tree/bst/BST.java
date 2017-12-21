package tree.bst;

import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BST {

    Node root;
    int sz;

    public void add(int val) {
        if (root == null) {
            root = new Node(val);
            return;
        }

        addHelper(val, root);
        sz++;
    }

    private Node addHelper(int val, Node s) {
        if (s == null) return new Node(val);

        if (s.val > val) {
            s.left = addHelper(val, s.left);
            return s;
        } else if (s.val < val) {
            s.right = addHelper(val, s.right);
            return s;
        } else {
            return s;
        }
    }

    public void remove(int val) {
        removeHelper(val, root);
    }

    private Node removeHelper(int val, Node s) {
        if (s == null) return s; //nothing to delete

        if (s.val > val) return s.left = removeHelper(val, s.left);
        if (s.val < val) return s.right = removeHelper(val, s.right);

        // if equal, now remove
        // case 1: if leaf node
        if (s.left == null && s.right == null) return null; // this is to update its parent to point to null
        // case 2: either node is null
        if (s.left == null) return s.right;
        if (s.right == null) return s.left;

        // case 3: find the inorder, replace it with the value of the inOrder, (leftmost of the right branch)
        Node inOrder = findInOrder(s.right);
        s.val = inOrder.val;

        // remove val from its right branch
        s.right = removeHelper(inOrder.val, s.right);
        return s;
    }

    private Node findInOrder(Node s) {
        if (s.left == null) return s;
        else return findInOrder(s.left);
    }

    public List<Integer> inOrder() {
        List<Integer> inOrders = new ArrayList<>();

        inOrderHelper(root, inOrders);

        return inOrders;
    }

    private void inOrderHelper(Node s, List<Integer> inOrders) {
        if (s == null) return;
        inOrderHelper(s.left, inOrders);
        inOrders.add(s.val);
        inOrderHelper(s.right, inOrders);
    }
}
