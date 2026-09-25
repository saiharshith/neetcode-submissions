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
    private int max = -1001;
    private int maxDepth(TreeNode root){
        if(root==null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        max = Math.max(max, root.val+Math.max(0,left)+Math.max(0,right));

        return root.val+Math.max(0,Math.max(left,right));
    }
    public int maxPathSum(TreeNode root) {
        maxDepth(root);

        return max;
    }
}
