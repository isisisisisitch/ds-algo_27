package ca.bytetube._00_leetcode.tree;

/**
 * https://leetcode.com/problems/maximum-binary-tree/description/
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {


        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l == r) return null;
        int maxIndex = l;
        for (int i = l + 1; i < r; i++) {
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }
        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = constructMaximumBinaryTree(nums, l, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, r);

        return root;
    }

}
