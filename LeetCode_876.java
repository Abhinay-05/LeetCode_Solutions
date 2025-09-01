/*
876. Middle of the Linked List

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.
*/


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
    public ListNode middleNode(ListNode head) {
        // when two people are running in a race
        // if the the speed of A is 2 times the speed of B
        // then by the time A finishes
        // B will be at the half point  

        ListNode slow = head;
        ListNode fast = head;

        // fast == null in case of EVEN nodes
        // fast.next == null in case of ODD nodes
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // at the middle node
        return slow;
    }
}
