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
    private int answer = -1;
    private int dfs(TreeNode node, int k){
        if(node==null)
            return 0;
        int left = dfs(node.left,k);
        if(left==k-1){
            answer=node.val;
            return k+1;
        }else if(left>=k){
            return k+1;
        }else{
            int right = dfs(node.right,k-left-1);
            return left+right+1;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return answer;    
    }
}
