/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted linked list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: []
 
Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.
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
    public ListNode mergeKLists(ListNode[] lists) {
        //create a MIN Heap
        List<Integer> list = new ArrayList<>();
        for(ListNode head : lists){
            while(head != null){
                list.add(head.val);
                rearrange(list);
                head = head.next;
            }
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while(!list.isEmpty()){
            temp.next = new ListNode(remove(list));
            temp = temp.next;
        }
        return head.next;
    }

    private void swap(List<Integer> list, int x, int y){
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    private void rearrange(List<Integer> list){
        int i = list.size() - 1;
        // upHeap
        while(i > 0){
            int p = (i-1)/2;
            
            if(list.get(p) > list.get(i)){
                swap(list, p, i);
                i = p;
            }
            else{
                break;
            }
        }
    }

    private int remove(List<Integer> list){
        int ans = list.get(0);

        int last = list.remove(list.size()-1);
        if(!list.isEmpty()){
            list.set(0, last);
        }
        int len = list.size();
        int i = 0;
        // downHeap
        while(i < len){
            int min = i;
            int left = 2*i + 1;
            int right = 2*(i+1);

            if(left < len && list.get(min) > list.get(left)){
                min = left;
            }

            if(right < len && list.get(min) > list.get(right)){
                min = right;
            }

            if(min == i){
                break;
            }
            //else
            swap(list, min, i);
            i = min;
        }
        return ans;
    }
}
