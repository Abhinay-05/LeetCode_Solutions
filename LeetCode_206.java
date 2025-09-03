/*
206. Reverse Linked List

Given the head of a singly linked list, reverse the list, and return the reversed list.
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

    // using 3 pointers
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

         ListNode node = head;
         ListNode front = head.next;
         ListNode prev = null;

         while(node != null){
            node.next = prev;
            prev = node;
            node = front;
            if(front != null){
                front = front.next;
            }
         }
         return prev;
    }
}
