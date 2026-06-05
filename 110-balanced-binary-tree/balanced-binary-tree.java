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
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = height(root.left);
        int rightH = height(root.right);

        int diff = Math.abs(leftH - rightH);
        if(diff > 1){
            return -1;
        }

        if(leftH == -1 || rightH == -1){
            return -1;
        }
        return Math.max(leftH, rightH) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root == null){
            return true;
        }

        if(height(root) == -1){
            return false;
        }
        return true;
    }

    
}