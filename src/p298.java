
/**
 * Created by Larry Liu on 11/16/2017.
 * 298. Binary Tree Longest Consecutive Sequence
 */
public class p298 {
    int maxLen;
    public int longestConsecutive(TreeNode root) {
        maxLen = 0;
        if (root == null) return 0;
        dfs(root, 0, root.val);
        return maxLen;
    }
    private void dfs(TreeNode node, int currLen, int target) {
        if (node == null) return;
        if (node.val != target) {
            currLen = 1;
        } else currLen++;
        maxLen = Math.max(maxLen, currLen);
        dfs(node.left, currLen, node.val+1);
        dfs(node.right, currLen, node.val+1);
    }
}
