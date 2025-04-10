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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: Find the length and the last node
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Make the list circular
        tail.next = head;

        // Step 3: Normalize k in case it's greater than length
        k = k % length;
        int stepsToNewHead = length - k;

        // Step 4: Find the new tail and head
        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Step 5: Break the circle and return the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
