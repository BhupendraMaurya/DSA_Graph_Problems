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
    TreeNode buildBST(TreeNode root, int currData){
        // if current root is null, then create a new node with the value as currData
        // and assigns it to root variable and then return it as root of current level
        // which will become the left or right child of above level, if there are nodes in above level.
        if(root == null){
            root = new TreeNode(currData);
            return root;
        }

        // If currData is less than root's value, go to the left subtree
        if(root.val > currData){
            root.left = buildBST(root.left,currData);
        }
        else{
            root.right = buildBST(root.right, currData);
        }

        // Return the current root after insertion, after insertion of its left or right child.
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root = null;

        // taking each element of given array and passing it to build BST, with root node as root.
        for(int i=0;i<preorder.length;i++){
            root = buildBST(root,preorder[i]);
        }

        return root;
    }
}