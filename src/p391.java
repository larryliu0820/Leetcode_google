import java.util.HashSet;
import java.util.Set;

/**
 * Created by mengwliu on 11/25/17
 * 391. Perfect Rectangle
 */
public class p391 {
    public boolean isRectangleCover(int[][] rectangles) {
        int x1 = Integer.MAX_VALUE, x2 = Integer.MIN_VALUE;
        int y1 = Integer.MAX_VALUE, y2 = Integer.MIN_VALUE;
        int area = 0;
        Set<String> set = new HashSet<>();
        for (int[] rect: rectangles) {
            x1 = Math.min(x1, rect[0]);
            x2 = Math.max(x2, rect[2]);
            y1 = Math.min(y1, rect[1]);
            y2 = Math.max(y2, rect[3]);

            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);

            if (!set.add(rect[0] + " " + rect[1])) set.remove(rect[0] + " " + rect[1]);
            if (!set.add(rect[0] + " " + rect[3])) set.remove(rect[0] + " " + rect[3]);
            if (!set.add(rect[2] + " " + rect[1])) set.remove(rect[2] + " " + rect[1]);
            if (!set.add(rect[2] + " " + rect[3])) set.remove(rect[2] + " " + rect[3]);

        }

        String[] corners = new String[4];
        corners[0] = x1 + " " + y1;
        corners[1] = x1 + " " + y2;
        corners[2] = x2 + " " + y1;
        corners[3] = x2 + " " + y2;
        if (set.size() != 4 || area != (x2 - x1) * (y2 - y1)) return false;
        for (String corner: corners) {
            if (!set.contains(corner)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        p391 sol = new p391();
        sol.isRectangleCover(new int[][]{{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}});
    }
}
