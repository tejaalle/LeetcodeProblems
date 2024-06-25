# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def bstToGst(self, root: TreeNode) -> TreeNode:
        def dfs(root, s):
            if not root:
                return s
            right = dfs(root.right, s)
            root.val += right
            left = dfs(root.left, root.val)
            return left
        dfs(root, 0)
        return root
