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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // creating a dummy node
        ListNode dummyNode = new ListNode(-1, null);

        // Temp node which is pointing towards temp node.
        ListNode temp = dummyNode;

        // Run loop till both list is not null.
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else{
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        // Since any one of the list would be not null or both would be not null,
        // If list1 is not null, then assign it as temp's next.
        if(list1 != null){
            temp.next = list1;
        }
        // If list2 is not null, then just assign it as temp's next.
        else{
            temp.next = list2;
        }

        return dummyNode.next;
    }
}