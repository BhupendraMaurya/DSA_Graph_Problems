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
        ArrayList<Integer> list = new ArrayList<>();

        for(ListNode head : lists){
            ListNode temp = head;
            while(temp != null){
                list.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(list);
        System.out.println(list);

        if(list.size() == 0){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;

        int i = 0;
        while(i < list.size()){
            ListNode newNode = new ListNode(list.get(i));
            temp.next = newNode;
            temp = temp.next;
            i++;
        }

        return newHead.next;
    }
}