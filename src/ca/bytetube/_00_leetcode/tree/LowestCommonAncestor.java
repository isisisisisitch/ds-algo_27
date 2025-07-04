package ca.bytetube._00_leetcode.tree;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author dall.
 */
public class LowestCommonAncestor {
    /*
    以root为根节点的二叉树中，查找p，q的最低公共祖先节点
    1.如果p,q同时存在于这棵树中，那么就能成功返回它们的最低公共祖先节点
    2.如果p,q都不存在于这棵树中，返回null
    3.如果只有p存在于这子棵树中，则返回p
    4.如果只有q存在于这子棵树中，则返回q
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        //以root.left作为根节点的二叉树中去查找p，q的最低公共祖先节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //以root.right作为根节点的二叉树中去查找p，q的最低公共祖先节点
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        //p,q都在左侧
//        if (left != null && right == null) return left;
//        if (right != null && left == null) return right;
//        return null;
        return (left != null) ? left : right;
    }
}
