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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> post = new ArrayList<>();
        if(root == null){
            return post;
        }
        Stack<TreeNode> st = new Stack<>();

        TreeNode curr = root;
        // keep going to the left and push node in the stack while not null and then check for right node, if not
        // null, then try to go to its left as well, and if no right node, then add this node in the post order
        // traversal and then go back to its ancestors.

        // Basically we have to traverse left, right then root,. so first go left, then right and then 
        // go back by taking each root node. 
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;

                if(temp == null){
                    temp = st.pop();
                    post.add(temp.val);

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        post.add(temp.val);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return post;
    }
}