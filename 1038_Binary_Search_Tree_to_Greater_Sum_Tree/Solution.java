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
    public int dfs(TreeNode node, int s){
        if(node==null){
            return s;
        }
        int right = dfs(node.right, s);
        node.val += right;
        int left = dfs(node.left, node.val);
        return left;
    }
    public TreeNode bstToGst(TreeNode root) {
        dfs(root, 0);
        return root;

    }
}