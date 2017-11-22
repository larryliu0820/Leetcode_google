import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 11/20/2017.
 * 246. Strobogrammatic Number
 */
public class p246 {
    public boolean isStrobogrammatic(String num) {
        int[] map = new int[] {0, 1, 0, 0, 0, 0, 9, 0, 8, 6};
        int left = 0, right = num.length()-1;
        while (left <= right) {
            if (map[num.charAt(left++)-'0'] != num.charAt(right--)-'0') return false;
        }
        return true;
    }
}
