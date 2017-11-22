/**
 * Created by Larry Liu on 11/21/2017.
 * 687. Longest Univalue Path
 */
public class p687 {
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return maxLen;
    }

    private int helper(TreeNode node) {
        int maxRes = 0, currRes = 0;
        int leftRes = 0, rightRes = 0;
        if (node.left != null) {
            leftRes = helper(node.left);
            if (node.val == node.left.val) {
                maxRes += leftRes + 1;
                currRes = Math.max(currRes, leftRes+1);
                maxLen = Math.max(maxLen, maxRes);
            }
        }
        if (node.right != null) {
            rightRes = helper(node.right);
            if (node.val == node.right.val) {
                maxRes += rightRes + 1;
                currRes = Math.max(currRes, rightRes+1);
                maxLen = Math.max(maxLen, maxRes);
            }
        }
        return currRes;
    }
}
