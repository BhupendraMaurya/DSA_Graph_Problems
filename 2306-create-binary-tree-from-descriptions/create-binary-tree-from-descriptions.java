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
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int description[] : descriptions){
            // extracting parent value, child value, and whether it is a left or right child.
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;
            //create parent and child nodes if not already created.
            if(!nodeMap.containsKey(parent)){
                nodeMap.put(parent, new TreeNode(parent));
            }
            if(!nodeMap.containsKey(child)){
                nodeMap.put(child, new TreeNode(child));
            }
            if(isLeft){
                nodeMap.get(parent).left = nodeMap.get(child);
            }
            else{
                nodeMap.get(parent).right = nodeMap.get(child);
            }
            // mark child as a child in the set. 
            children.add(child);
        }
        // find and return the root node.
        for(TreeNode node : nodeMap.values()){
            if(!children.contains(node.val)){
                return node;
            }
        }
        return null;
    }
}