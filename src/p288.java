import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Larry Liu on 11/19/2017.
 * 288. Unique Word Abbreviation
 */
public class p288 {
    Map<String, Set<String>> map;
    public p288(String[] dictionary) {
        map = new HashMap<>();
        for (String word: dictionary) {
            String abbr = word.length() <= 2 ? word: word.substring(0,1)+(word.length()-2)+word.substring(word.length()-1);
            map.putIfAbsent(abbr, new HashSet<>());
            map.get(abbr).add(word);

        }
    }

    public boolean isUnique(String word) {
        String abbr = word.length() <= 2 ? word: word.substring(0,1)+(word.length()-2)+word.substring(word.length()-1);
        return !map.containsKey(abbr) || (map.get(abbr).size() == 1 && map.get(abbr).contains(word));
    }
}
