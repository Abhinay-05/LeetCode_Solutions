/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[20,9],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-100 <= Node.val <= 100
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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();

        if(node == null){
            return list;
        }

      // Deque
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(node);

        int x = 0;
        while(!dq.isEmpty()){
            int currLevelSize = dq.size();
            List<Integer> subList = new ArrayList<>(currLevelSize);

          // normal order
            if(x == 0){
                for(int i = 0 ; i < currLevelSize ; i++){
                    node = dq.poll();
                    subList.add(node.val);
                    if(node.left != null){
                        dq.offer(node.left);
                    }
                    if(node.right != null){
                        dq.offer(node.right);
                    }
                }
                x = 1;
            }

              // reverse order
            else{
                for(int i = 0 ; i < currLevelSize ; i++){
                    node = dq.pollLast();
                    subList.add(node.val);
                    if(node.right != null){
                        dq.offerFirst(node.right);
                    }
                    if(node.left != null){
                        dq.offerFirst(node.left);
                    }
                }
                x = 0;
            }
            list.add(subList);
        }
        return list;
    }
}
