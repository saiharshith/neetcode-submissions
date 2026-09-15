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
    private boolean sameTrees(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        return p.val==q.val && sameTrees(p.left,q.left) && sameTrees(p.right,q.right);
    }  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null)
            return false;
        boolean result = sameTrees(root,subRoot);
        if(result)
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
