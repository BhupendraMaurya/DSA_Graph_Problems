/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    public ListNode mergeKLists(ListNode[] lists) {
        var pq = new PriorityQueue<ListNode>(
            (a, b) -> a.val - b.val);


        for(int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                pq.add(lists[i]);
            }
        }

        ListNode dummyNode = new ListNode(-1, null);
        ListNode curr = dummyNode;

        while(!pq.isEmpty()){
            curr.next = pq.poll();
            curr = curr.next;

            if(curr.next != null){
                pq.add(curr.next);
            }
        }
        return dummyNode.next;
    }
}