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
    Map<Integer, List<Integer>> levelMap = new HashMap<>();
    int maxDepth = 0;
    public List<List<Integer>> levelOrder(TreeNode root) {
        traverse(root, 0);

        // System.out.println(levelMap);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            if (levelMap.containsKey(i))
            ans.add(levelMap.get(i));
        }
        return ans;
    }

    private void traverse(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        maxDepth = Math.max(depth, maxDepth);
        levelMap.computeIfAbsent(depth, k-> new ArrayList<>()).add(node.val);
        traverse(node.left, depth + 1);
        traverse(node.right, depth + 1);
    }
}
