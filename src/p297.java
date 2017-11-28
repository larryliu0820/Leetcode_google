import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mengwliu on 11/26/17
 * 297. Serialize and Deserialize Binary Tree
 */
public class p297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                queue.offer(curr.left);
                sb.append(',').append(curr.left.val);
            } else sb.append(",#");
            if (curr.right != null) {
                queue.offer(curr.right);
                sb.append(',').append(curr.right.val);
            } else sb.append(",#");
        }
        while (sb.charAt(sb.length()-1) == '#')
            sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("#")) return null;
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(arr[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (i < arr.length && !arr[i].equals("#")) {
                curr.left = new TreeNode(Integer.valueOf(arr[i]));
                queue.offer(curr.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("#")) {
                curr.right = new TreeNode(Integer.valueOf(arr[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
