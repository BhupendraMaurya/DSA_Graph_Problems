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
    static class Info{
        int d;
        int h;

        public Info(int d, int h){
            this.d = d;
            this.h = h;
        }
    }
    public Info diameterOfBinaryTree2(TreeNode root){
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameterOfBinaryTree2(root.left);
        Info rightInfo = diameterOfBinaryTree2(root.right);

        int finalDia = Math.max(leftInfo.h + rightInfo.h, Math.max(leftInfo.d, rightInfo.d));
        int finalHt = Math.max(leftInfo.h, rightInfo.h)+1;

        return new Info(finalDia, finalHt);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        if(root == null){
            return 0;
        }

        return diameterOfBinaryTree2(root).d;
        

    }

    
}