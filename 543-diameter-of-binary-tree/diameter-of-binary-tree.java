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

        return Math.max(leftH, rightH) + 1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        // here we are not doing this: lh + rh + 1: because we want the no of edges between this and if we add
        // lh and rh, then total edges equal to diameter,
        int selfD = lh + rh;

        return Math.max(selfD, Math.max(leftD, rightD));
        
        

    }

    
}