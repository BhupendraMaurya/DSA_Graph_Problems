/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode first = headA;
        ListNode second = headB;

        int lenA = 0;
        int lenB = 0;
        ListNode temp = headA;
        while(temp != null){
            lenA++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            lenB++;
            temp = temp.next;
        }
        while(first != null && second != null){
            if(first == second){
                return first;
            }
            else if(first != second && lenA != lenB){
                if(lenA > lenB){
                    lenA--;
                    first = first.next;
                }
                else{
                    lenB--;
                    second = second.next;
                }
            }
            else{
                first = first.next;
                second = second.next;
                lenA--;
                lenB--;
            }
        }

        return null;
    }
}