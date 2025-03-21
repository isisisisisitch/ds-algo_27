package ca.bytetube._00_leetcode.tree;

import ca.bytetube._06_tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * @author dall.
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        invertTree2(root.left);
        invertTree2(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public TreeNode invertTree3(TreeNode root) {
        if (root == null) return null;

        invertTree3(root.left);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree3(root.left);

        return root;
    }

    public TreeNode invertTree4(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            TreeNode poll = queue.poll();
            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }


        return root;
    }
}
