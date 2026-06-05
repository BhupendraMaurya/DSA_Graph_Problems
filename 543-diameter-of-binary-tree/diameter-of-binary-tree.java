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
    int d;
    int h;

    Info(int d, int h){
        this.d = d;
        this.h = h;
    }
 }
class Solution {

    public Info solve(TreeNode root){
        if(root == null){
            return new Info(0, 0);
        }

        Info lInfo = solve(root.left);
        Info rInfo = solve(root.right);

        int finalD = Math.max(lInfo.h+rInfo.h, Math.max(lInfo.d, rInfo.d));
        int finalH = Math.max(lInfo.h, rInfo.h)+1;
        return new Info(finalD, finalH);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        return solve(root).d;
    }

    
}