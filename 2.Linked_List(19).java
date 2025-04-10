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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp= head;
        //getting the size of the Linked List 
        int size=0;
        while(temp!= null){
            temp=temp.next;
            size++;
        }
        if (n == size) {
        return head.next; // skip the head
       }

        int count=0;
        ListNode temp1= head;
        while(count< size-n-1){
            temp1= temp1.next;
            count++;
            
        }
        temp1.next= temp1.next.next;
        return head;
    }
}
