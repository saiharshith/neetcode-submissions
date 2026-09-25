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
    private int preorderIndex = 0;
    private Map<Integer,Integer> inorderMap = new HashMap<>();
    private TreeNode build(int[] preorder,int inorderStart, int inorderEnd){
        if(inorderStart>inorderEnd)
            return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.left = build(preorder,inorderStart,rootIndex-1);
        root.right = build(preorder,rootIndex+1,inorderEnd);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);    
        }    
        return build(preorder,0,inorder.length-1);    
    }
}
