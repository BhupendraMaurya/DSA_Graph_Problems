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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        

        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            
            
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                level.add(curr.val);

                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            list.add(level);
            
        }
        return list;
    }
}