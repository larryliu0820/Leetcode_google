import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/16/17.
 * 388. Longest Absolute File Path
 */
public class p388 {
    public int lengthLongestPath(String input) {
        List<Integer> path = new LinkedList<>();
        int count = 0;
        String[] arr = input.split("\n");
        for (String name : arr) {
            int level = 0;
            while (name.startsWith("\t", level)) level++;
            if (level == 0) path.add(level, name.length()-level);
            else path.add(level, path.get(level-1) + name.length()-level+1);
            if (name.contains(".")) count = Math.max(count, path.get(level));
        }
        return count;
    }
}
