package tree;

public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int v) {
        val = v;
    }

    public Node insertLeft(int v) {
        this.left = new Node(v);

        return this.left;
    }

    public Node insertRight(int v) {
        this.right = new Node(v);

        return this.right;
    }
}
