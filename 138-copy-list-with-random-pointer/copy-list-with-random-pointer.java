/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // taking a map to store old node and copy node as key, value pair.
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;

        while(temp != null){
            Node copy = new Node(temp.val);
            map.put(temp, copy);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            Node copyNode = map.get(temp);
            copyNode.next = map.get(temp.next);
            copyNode.random = map.get(temp.random);
            temp = temp.next;
        }

        return map.get(head);
    }
}