import java.util.ArrayList;
import java.util.List;

/**
 * Created by Larry Liu on 11/19/2017.
 * 271. Encode and Decode Strings
 */
public class p271 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s: strs) sb.append(s.length()).append('/').append(s);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            res.add(s.substring(slash+1, slash+size+1));
            i = slash+size+1;
        }
        return res;
    }
}
