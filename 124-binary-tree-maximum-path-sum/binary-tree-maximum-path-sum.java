/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     } 
 * }
 */
class Solution {
    int maxi = Integer.MIN_VALUE;  // Initialize to handle all-negative values

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxi;
    }

    public int maxSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lsum = Math.max(0, maxSum(root.left));
        int rsum = Math.max(0, maxSum(root.right));

        maxi = Math.max(maxi, rsum + lsum + root.val);

        return root.val + Math.max(rsum, lsum);
    }
}