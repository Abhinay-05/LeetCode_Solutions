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
class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }
    // using PostOrder
    private int pathSum(TreeNode root){
        if(root == null){
            // NULL noed returns 0
            return 0;
        }

        int left = pathSum(root.left);//max value from left subtree
        int right = pathSum(root.right);// max value from right subtree

        int currVal = root.val;//current node's value
        if(currVal > max){
            // if the value of current node is greater than max
            max = currVal;
        }
        if((left + currVal) > max){
            // if (left subtree + current) is greater
            max = left + currVal;
        }
        if((currVal + right) > max){
            // if (right subtree + current) is greater
            max = currVal + right;
        }

        int currPath = left + currVal + right;// calculate current path 
        if(currPath > max){
            // if current path is greater than MAX
            max = currPath;
        }

        return Math.max(currVal, (Math.max(left, right) + currVal));// subtree of just current value
        // current node's value might be greater than 
        // cutoff the path at this node
    }
}
