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
    public TreeNode build(int nodeVal, Map<Integer, Integer> leftMap, Map<Integer, Integer> rightMap){
        TreeNode root = new TreeNode(nodeVal);

        if(leftMap.containsKey(nodeVal)){
            root.left = build(leftMap.get(nodeVal), leftMap, rightMap);
        }

        if(rightMap.containsKey(nodeVal)){
            root.right = build(rightMap.get(nodeVal), leftMap, rightMap);
        }
        return root;
    }
    public TreeNode createBinaryTree(int[][] descriptions) {
        // parent -> Left child
        Map<Integer, Integer> leftMap = new HashMap<>();
        // parent -> Right child
        Map<Integer, Integer> rightMap = new HashMap<>();
        // storing all the nodes that appear as children in the set.
        Set<Integer> children = new HashSet<>();

        for(int a[] : descriptions){
            int parent = a[0];
            int child = a[1];
            
            children.add(child);

            if(a[2] == 1){
                leftMap.put(parent, child);
            }
            else{
                rightMap.put(parent, child);
            }
        }

        // traversing on the set and checking that which node is never a child that is our parent.
        // any node which never becomes the child is our parent.
        int rootNode = -1;
        for(int a[] : descriptions){
            if(!children.contains(a[0])){
                rootNode = a[0];
                break;
            }
        }

        TreeNode root = build(rootNode, leftMap, rightMap);
        return root;
    }
}