package ca.bytetube._20_amzOA;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class AverageOfLevels {


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }


    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtil.buildTree(arr);
        AverageOfLevels sol = new AverageOfLevels();
        System.out.println(sol.averageOfLevels(root)); // [3.0, 14.5, 11.0]
    }
}
