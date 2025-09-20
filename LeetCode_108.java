/*
108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

//  insert middle elements in the array
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        root = binarySearchInsertion(root, nums, 0, nums.length - 1);
        return root;
    }

    TreeNode binarySearchInsertion(TreeNode root, int[] nums, int st, int end){
        if(st > end){
            return null;
        }

        int mid = st + (end - st) / 2;
        root = insertion(root, nums[mid]);

        binarySearchInsertion(root, nums, st, mid-1);
        binarySearchInsertion(root, nums, mid+1, end);

        return root;
    }

    TreeNode insertion(TreeNode node, int val){
        if(node == null){
            return new TreeNode(val);
        }

        if(val < node.val){
            node.left = insertion(node.left, val);
        }
        else{
            node.right = insertion(node.right, val);
        }
        return node;
    }
}
