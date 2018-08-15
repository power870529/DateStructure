import java.util.LinkedList;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with the root node root,
 * return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 *
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 *
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *        4
 *      /   \
 *     2      6
 *    / \
 *   1   3
 *
 *   while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 *
 *   Note:
 *   The size of the BST will be between 2 and 100.
 *   The BST is always valid, each node's value is an integer, and each node's value is different.
*/

public class LeetCode783MinimumDistanceBetweenBSTNodes {

    /*
    public int minDiffInBST(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        inOrder(list, root);

        int res = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            res = Math.min(res, list.get(i) - list.get(i - 1));
        }

        return res;
    }

    private void inOrder(List list, TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(list, node.left);
        list.add(node.val);
        inOrder(list, node.right);
    }
    */

    Integer res = Integer.MAX_VALUE;
    Integer pre = null;

    public int minDiffInBST(TreeNode root) {

        if (root.left != null) {
            minDiffInBST(root.left);
        }

        if (pre != null) {
            res = Math.min(res, root.val - pre);
        }
        pre = root.val;

        if (root.right != null) {
            minDiffInBST(root.right);
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.val = x;
        }
    }
}
