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
    
    public void storeNodes(TreeNode root, Stack<Integer> st){
        if(root == null){
            return;
        }
        storeNodes(root.right, st);
        storeNodes(root.left, st);
        st.push(root.val);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        storeNodes(root, st);
        while(!st.isEmpty()){
            int top = st.pop();
            preorder.add(top);
        }
        return preorder;
    }
}