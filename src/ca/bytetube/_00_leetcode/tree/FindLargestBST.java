package ca.bytetube._00_leetcode.tree;

public class FindLargestBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(14);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(16);
        root.right.right = new TreeNode(18);
        root.left.right.left = new TreeNode(11);
        root.left.right.right = new TreeNode(25);
        root.left.right.left.left = new TreeNode(8);
        root.left.right.left.right = new TreeNode(13);
        root.left.right.right.left = new TreeNode(22);
        root.left.right.right.right = new TreeNode(29);
        FindLargestBST bst = new FindLargestBST();
        System.out.println(bst.findLargestBST(root));

    }

    private static class Info {
        public TreeNode root;
        public int size = 1;
        public int max;
        public int min;


        public Info(TreeNode root, int size, int max, int min) {
            this.root = root;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    /**
     * 以root作为根节点的二叉树本身就是一个bst，最大的bst就是其本身
     * 1.li != null&& ri! =null
     * && li.root == root.left && root.val > li.max
     * && ri.root == root.right && root.val < ri.min
     * 2.li != null && ri == null
     * && li.root == root.left && root.val > li.max
     * 3.li == null && ri != null
     * && ri.root == root.right && root.val < ri.min
     * 4.li==null && ri == null
     * <p>
     * if(以root作为根节点的二叉树本身就是一个bst){
     * return new Info(root,li.size + ri.size + 1,ri.max,li.min);
     * }else{//以root作为根节点的二叉树本身不是一个bst，那么最大的bst可能来自于左子树或者右子树，需要返回最大的子树的节点个数
     * if(li != null && ri != null){
     * if(li.size > ri.size){
     * return li.info;
     * }else{
     * return ri.info;
     * }
     * <p>
     * }
     * }
     */
    //自底向上
    public int findLargestBST(TreeNode root) {
        return (root == null) ? 0 : getInfo(root).size;
    }

    //返回以root作为根节点的二叉树的最大bst的子树信息
    public Info getInfo(TreeNode root) {
        if (root == null) return null;
        //左子树最大bst信息
        Info li = getInfo(root.left);
        //右子树最大bst信息
        Info ri = getInfo(root.right);
        //if(以root作为根节点的二叉树本身就是一个bst){
        // return new Info(root,li.size + ri.size + 1,ri.max,li.min);
        // }else{//以root作为根节点的二叉树本身不是一个bst，那么最大的bst可能来自于左子树或者右子树，需要返回最大的子树的节点个数
        //if(li != null && ri != null){
        // if(li.size > ri.size){
        //return li.info;
        //}else{
        //return ri.info;
        int leftBstSize = -1;
        int rightBstSize = -1;
        int min = root.val;
        int max = root.val;
        if (li == null) {
            leftBstSize = 0;
        } else if (li.root == root.left && root.val > li.max) {
            leftBstSize = li.size;
            min = li.min;
        }

        if (ri == null) {
            rightBstSize = 0;
        } else if (ri.root == root.right && root.val < ri.min) {
            rightBstSize = ri.size;
            max = ri.max;
        }

        if (leftBstSize >= 0 && rightBstSize >= 0) {
            return new Info(root, leftBstSize + rightBstSize + 1, max, min);
        }

        //以root作为根节点的二叉树不是bst
        //返回最大bst节点数量较多的那个info
        if (li != null && ri != null) return (li.size > ri.size) ? li : ri;


        return (li != null) ? li : ri;
    }

//    private int numOfNodes(TreeNode root) {
//        return 0;
//    }
//
//    public int findLargestBST(TreeNode root) {
//        if (root == null) return 0;
//        if (isBST(root)) {
//            return numOfNodes(root);
//        }
//        int left = findLargestBST(root.left);
//        int right = findLargestBST(root.right);
//        return Math.max(left, right);
//    }
//
//    private boolean isBST(TreeNode root) {
//        return false;
//    }

}
