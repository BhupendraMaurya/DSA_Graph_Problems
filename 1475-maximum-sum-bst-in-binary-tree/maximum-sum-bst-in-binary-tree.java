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
 class Info{
    boolean isBST;
    int sum;
    int mini;
    int maxi;

    Info(boolean isBST, int sum, int mini, int maxi){
        this.isBST = isBST;
        this.sum = sum;
        this.mini = mini;
        this.maxi = maxi;
    }

 }
class Solution {
    public static int maxBST = 0;
    
    public Info countBST(TreeNode root){
        if(root == null){
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info leftTree = countBST(root.left);
        Info rightTree = countBST(root.right);

        int sum = leftTree.sum + rightTree.sum + root.val;
        int mini = Math.min(root.val, Math.min(leftTree.mini, rightTree.mini));
        int maxi = Math.max(root.val, Math.max(leftTree.maxi, rightTree.maxi));

        // if current node is valid. 
        if(leftTree.isBST && rightTree.isBST && root.val > leftTree.maxi && root.val < rightTree.mini){

            maxBST = Math.max(maxBST, sum);
            return new Info(true, sum, mini, maxi);
        }

        // if current root does not have any valid bst in any of its child, then return false and details.
        return new Info(false, sum, mini, maxi);
    }
    public int maxSumBST(TreeNode root) {
        maxBST = 0;
        countBST(root);
        return maxBST;
    }
}