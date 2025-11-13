/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Example 1:
Input: root = [1,2,3,null,null,4,5]
Output: [1,2,3,null,null,4,5]

Example 2:
Input: root = []
Output: []
 
Constraints:
The number of nodes in the tree is in the range [0, 104].
-1000 <= Node.val <= 1000
  
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // Solving by using PreOrder approach

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<TreeNode> list = serialize1(root);
        
        // convert list to string
        StringBuilder sb = new StringBuilder();
        for(TreeNode el : list){
            if(el == null){
                sb.append("null ");
            }
            else{
                sb.append(el.val);
                sb.append(" ");
            }
        }
        return sb.toString();

    }
    private List<TreeNode> serialize1(TreeNode node){
        List<TreeNode> list = new ArrayList<>();
        if(node == null){
            list.add(node);
            return list;
        }

        list.add(node); //preorder
        list.addAll(serialize1(node.left));
        list.addAll(serialize1(node.right));

        return list;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        return deserialize1(arr);
    }
    // to track elements of the list
    int i = 0;
    private TreeNode deserialize1(String[] arr){
        if(arr[i].equals("null")){
            // return null
            i++;
            return null;
        }
        //preorder 
        TreeNode node = new TreeNode(Integer.parseInt(arr[i]));
        i++;

        node.left = deserialize1(arr);
        node.right = deserialize1(arr);

        return node; 
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
