package ca.bytetube._20_amzOA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            pushLeft(node.right);
        }
        return node.val;
    }


    class TreeUtil {
        public static TreeNode buildTree(Integer[] arr) {
            if (arr.length == 0 || arr[0] == null) return null;
            TreeNode root = new TreeNode(arr[0]);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty() && i < arr.length) {
                TreeNode node = queue.poll();
                if (i < arr.length && arr[i] != null) {
                    node.left = new TreeNode(arr[i]);
                    queue.offer(node.left);
                }
                i++;
                if (i < arr.length && arr[i] != null) {
                    node.right = new TreeNode(arr[i]);
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }



    public static void main(String[] args) {
        Integer[] arr = {7, 3, 15, null, null, 9, 20};
        TreeNode root = TreeUtil.buildTree(arr);
        BSTIterator bSTIterator = new BSTIterator(root);

        System.out.println(bSTIterator.next());    // 3
        System.out.println(bSTIterator.next());    // 7
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 9
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 15
        System.out.println(bSTIterator.hasNext()); // true
        System.out.println(bSTIterator.next());    // 20
        System.out.println(bSTIterator.hasNext()); // false
    }
}
