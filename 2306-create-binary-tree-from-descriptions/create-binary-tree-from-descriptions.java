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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(-1);
        HashMap<TreeNode, Boolean> map2 = new HashMap<>();
        
        for(int arr[] : descriptions){
            int val1 = arr[0];
            int val2 = arr[1];
            int leftOrRight = arr[2];

            TreeNode parent = new TreeNode(-1);
            if(!map.containsKey(val1)){
                TreeNode temp = new TreeNode(val1);
                parent = temp;
                map.put(val1, parent);
            }
            else{
                parent = map.get(val1);
            }
            
            TreeNode child = new TreeNode(-1);
            if(!map.containsKey(val2)){
                TreeNode temp2 = new TreeNode(val2);
                child = temp2;
                map.put(val2, child);
            }
            else{
                child = map.get(val2);
            }
            if(!map2.containsKey(parent)){
                map2.put(parent, true);
                // System.out.println(parent.val);
            }
            if(leftOrRight == 1){
                parent.left = child;
                map2.put(child, false);
            }
            else{
                parent.right = child;
                map2.put(child, false);
            }
        }

        for(Map.Entry<TreeNode, Boolean> it : map2.entrySet()){
            TreeNode value = it.getKey();
            Boolean value2 = it.getValue();
            System.out.println(value2);
            if(map2.get(value)){
                root = map.get(value.val);
            }
        }
        return root;

    }
}