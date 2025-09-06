/*
234. Palindrome Linked List

Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        ListNode two = null;

        while(temp != null){
            ListNode node = new ListNode(temp.val, two);
            two = node;
            temp = temp.next;
        }
        
        while(head != null){
            if(head.val != two.val){
                return false;
            }
            head = head.next;
            two = two.next;
        }
        return true;
    }
}
