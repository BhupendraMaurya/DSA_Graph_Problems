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
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode node = root;
        // took two stack and then just push root into the stack 1 and then start taking the top element out,
        // and also push it into the st2 and then check its left and right element, if not null, then first insert
        // left and then right, 
        // in the last, just keep  take all the elements from the stack and print it. 

        s1.push(node);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            s2.push(top);
            if(top.left != null){
                s1.push(top.left);
            }

            if(top.right != null){
                s1.push(top.right);
            }
        }

        while(!s2.isEmpty()){
            post.add(s2.pop().val);
        }
        return post;
    }
}