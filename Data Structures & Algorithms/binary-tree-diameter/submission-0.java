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
    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
            return 0;
        int answer = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));

        answer = Math.max(answer,maxDepth(root.left)+maxDepth(root.right));

        return answer;    
    }
}
