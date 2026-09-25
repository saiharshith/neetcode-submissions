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

public class Codec {
    private StringBuilder sb;
    private int index;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();    
        serializeHelper(root);
        return sb.toString();    
    }

    private void serializeHelper(TreeNode node){
        if(node==null){
            sb.append("N,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left);
        serializeHelper(node.right);
    }

    private TreeNode deserializeHelper(String[] values){
        if(values[index].equals("N")){
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        index++;
        node.left = deserializeHelper(values);
        node.right = deserializeHelper(values);

        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index=0;
        return deserializeHelper(values);    
    }
}
