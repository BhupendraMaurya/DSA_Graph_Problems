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

    public void reversePreorder(TreeNode root, ArrayList<Integer> list, int level){
        if(root == null){
            return;
        }

        if(list.size() == level){
            list.add(root.val);
        }

        reversePreorder(root.right, list, level+1);
        reversePreorder(root.left, list, level+1);
    }
    public List<Integer> rightSideView(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        reversePreorder(root, list, 0);
        return list;

    }
}