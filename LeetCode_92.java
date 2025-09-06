/*
92. Reverse Linked List II

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){
            return head;
        }

        int indx = 1;

        ListNode temp = head;
        ListNode start = head;
        ListNode end = head;
        ListNode Lend = null;
        ListNode Rend = head;

        while(temp != null){
            if(left - 1 == indx){
                Lend = temp;
            }

            if(indx == left){
                start = temp;
            }

            if(indx == right){
                end = temp;
                Rend = temp.next;
                break;
            }
            indx++;
            temp = temp.next;
        }

        ListNode prev = Rend;
        ListNode node = start;
        ListNode front = node.next;

        while(node != Rend){
            node.next = prev;
            prev = node;
            node = front;
            if(front != Rend){
                front = front.next;
            }
        }
        // when head is previous
        if (Lend == null) {
            return prev;
        } 
        Lend.next = prev;   
            return head;
    }


}
