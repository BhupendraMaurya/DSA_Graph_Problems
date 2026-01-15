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
   
    public void levelOrder(TreeNode root, List<List<Integer>> list){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        List<Integer> currentLevel = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr != null){
                currentLevel.add(curr.val);
                if(curr.left != null){
                    q.add(curr.left);
                }

                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            else{
                list.add(new ArrayList<>(currentLevel));
                currentLevel.clear();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        levelOrder(root, list);

        List<List<Integer>> list2 = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(i%2 == 0){
                list2.add(list.get(i));
            }
            else{
                List<Integer> list3 = list.get(i);
                Collections.reverse(list3);
                list2.add(list3);
            }
        }
        return list2;
    }
}