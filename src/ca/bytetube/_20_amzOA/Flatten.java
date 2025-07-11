package ca.bytetube._20_amzOA;

import java.util.ArrayList;
import java.util.List;

public class Flatten {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        list.add(node);
        preorder(node.left, list);
        preorder(node.right, list);
    }

}
