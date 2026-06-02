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

        TreeNode node = root;
        // took two stack and then just push root into the stack 1 and then start taking the top element out,
        // and also push it into the st2 and then check its left and right element, if not null, then first insert
        // left and then right, 
        // in the last, just keep  take all the elements from the stack and print it. 

        // We can also solve this without using the second stack. as it is only used to store the nodes. 
        // so store nodes in list and then reverse and return it. 

        s1.push(node);
        while(!s1.isEmpty()){
            TreeNode top = s1.pop();
            post.add(top.val);
            if(top.left != null){
                s1.push(top.left);
            }

            if(top.right != null){
                s1.push(top.right);
            }
        }

        Collections.reverse(post);
        return post;
    }
}