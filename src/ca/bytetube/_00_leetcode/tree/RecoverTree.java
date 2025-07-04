package ca.bytetube._00_leetcode.tree;

/**
 * https://leetcode.com/problems/recover-binary-search-tree/
 *
 * @author dall.
 */
public class RecoverTree {
    private TreeNode first;//first是第一个逆序对中的较大值
    private TreeNode second;//second是最后一个逆序对中的较小值
    private TreeNode prev;

    private void findWrongNode(TreeNode root) {
        if (root == null) return;
        //inOrder
        findWrongNode(root.left);
//        System.out.println();
        findInversion(root);
        findWrongNode(root.right);
    }

    private void findInversion(TreeNode root) {
        if (prev != null && prev.val > root.val) {
            second = root;
            if (first != null) return;
            first = prev;
        }
        prev = root;
    }

    public void recoverTree(TreeNode root) {
        findWrongNode(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
