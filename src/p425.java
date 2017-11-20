import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/17/17.
 * 425. Word Squares
 */
public class p425 {
    class TrieNode {
        TrieNode[] neighbor;
        List<String> startWith;
        boolean isWord;
        TrieNode() {
            neighbor = new TrieNode[26];
            startWith = new ArrayList<>();
            isWord = false;
        }
    }
    List<List<String>> res = new LinkedList<>();
    TrieNode root;

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) return res;
        root = new TrieNode();
        buildTrie(words);
        List<String> list = new LinkedList<>();
        for (String word: words) {
            list.add(word);
            dfs(list, words[0].length());
            list.remove(list.size()-1);
        }

        return res;
    }

    private void buildTrie(String[] words) {
        for (String word: words) {
            TrieNode itr = root;
            for (char c: word.toCharArray()) {
                if (itr.neighbor[c-'a'] == null) {
                    itr.neighbor[c-'a'] = new TrieNode();
                }
                itr.neighbor[c-'a'].startWith.add(word);
                itr = itr.neighbor[c-'a'];
            }
            itr.isWord = true;
        }
    }

    private List<String> findWord(String prefix) {
        List<String> res = new ArrayList<>();
        TrieNode itr = root;
        for (char c: prefix.toCharArray()) {
            if (itr.neighbor[c-'a'] == null) {
                return res;
            }
            itr = itr.neighbor[c-'a'];
        }
        res.addAll(itr.startWith);
        return res;
    }
    private void dfs(List<String> curr, int len) {
        if (curr.size() == len) {
            res.add(new LinkedList<>(curr));
            return;
        }
        StringBuilder prefix = new StringBuilder();
        for (String s: curr) prefix.append(s.charAt(curr.size()));
        List<String> startWith = findWord(prefix.toString());
        for (String s: startWith) {
            curr.add(s);
            dfs(curr, len);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        p425 sol = new p425();
        sol.wordSquares(new String[]{"area","lead","wall","lady","ball"});
    }
}
