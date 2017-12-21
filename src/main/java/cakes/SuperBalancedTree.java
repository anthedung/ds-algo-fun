package cakes;

import tree.Node;

/**
 * A tree is "superbalanced" if the difference between the depths
 * of any two leaf nodes is no greater than one.
 */
public class SuperBalancedTree {

    static boolean superBalance(Node root) {
        if (root == null) return false;

        int[] depths = new int[2];
        depths[0] = Integer.MAX_VALUE;

        superBalanceCountDepths(root, depths, 0);

        return (depths[1] - depths[0] <= 1);
    }

    private static void superBalanceCountDepths(Node s, int[] depths, int depth) {
        if (s == null) return;
        depth++;

        if (s.right == null && s.left == null) {
            depths[0] = Math.min(depth, depths[0]);
            depths[1] = Math.max(depth, depths[1]);

            if (depths[1] - depths[0]  > 1) return;
        }

        superBalanceCountDepths(s.left, depths, depth);
        superBalanceCountDepths(s.right, depths, depth);
    }
}
