import java.util.List;

/**
 * Created by Larry Liu on 11/22/
 * 524. Longest Word in Dictionary through Deleting
 */
public class p524 {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";
        for (String dictWord: d) {
            if (dictWord.length() < longest.length()) continue;
            int i = 0;
            for (char c: s.toCharArray()) {
                if (i < dictWord.length() && c == dictWord.charAt(i)) i++;
            }
            if (i == dictWord.length()) {
                if (dictWord.length() > longest.length() || dictWord.compareTo(longest) < 0) longest = dictWord;
            }
        }
        return longest;
    }
}
