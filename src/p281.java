import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/17/17.
 * 281. Zigzag Iterator
 */
public class p281 {
    List<List<Integer>> list;
    int maxLen;
    int row;
    int col;
    public p281(List<Integer> v1, List<Integer> v2) {
        list = new LinkedList<>();
        maxLen = Math.max(v1.size(), v2.size());
        list.add(v1);
        list.add(v2);
        row = 0;
        col = 0;
    }

    public int next() {
        int res = list.get(row).get(col);
        row++;
        if (row >= list.size() && col < maxLen) {
            row = 0;
            col++;
        }
        return res;
    }

    public boolean hasNext() {
        if (row < list.size() && list.get(row).size() > col) return true;
        while (col < maxLen) {
            while (row < list.size()) {
                if (list.get(row).size() <= col) row++;
                else return true;
            }
            row = 0;
            col++;
        }
        return false;
    }
}
