/*
143. Reorder List

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.
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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode mid = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            mid = mid.next;
        }
        mid = reverseList(mid);
        ListNode temp = new ListNode(-1);
        // head first
        ListNode hf = head;
        // head second
        ListNode hs = mid;
        
        while(hs != null && hf != null){
            
            temp = hf.next;
            hf.next = hs;
            hf = temp;

            temp = hs.next;
            hs.next = hf;
            hs = temp;
        }

        if(hf != null){
            hf.next = null;
        }
    }

    ListNode reverseList(ListNode head) {
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
                front = front.next; // could give null pointer exception
            }
         }
         return prev;//old tail(new head)
    }


}
