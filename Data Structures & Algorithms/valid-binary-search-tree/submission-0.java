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
    private int[] dfs(TreeNode node){
        int[] ans = new int[3];
        if(node==null){
            ans[0]=1;
            ans[1]=Integer.MAX_VALUE;
            ans[2]=Integer.MIN_VALUE;
            return ans;    
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if(left[0]==0 || right[0]==0){
            return ans;
        }

        if(left[2]>=node.val || right[1]<=node.val){
            return ans;
        }

        ans[0]=1;
        ans[1]=node.left==null?node.val:left[1];
        ans[2]=node.right==null?node.val:right[2];

        return ans;

    }
    public boolean isValidBST(TreeNode root) {
        return dfs(root)[0]==1;    
    }
}
