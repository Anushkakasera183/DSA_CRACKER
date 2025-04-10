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
        //Priority Queue 
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummyNode= new ListNode(0);
        ListNode cur= dummyNode;
        while(!pq.isEmpty()){
            ListNode minnode= pq.poll();
            cur.next= minnode;
            cur= cur.next;
            if(minnode.next!=null){
                pq.add(minnode.next);
            }
        }
        return dummyNode.next;
    }
}
