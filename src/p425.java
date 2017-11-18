import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 11/17/17.
 * 425. Word Squares
 */
public class p425 {
    class TrieNode {
        TrieNode[] neighbor;
        boolean isWord;
        TrieNode() {
            neighbor = new TrieNode[26];
            isWord = false;
        }
    }
    List<List<String>> res = new LinkedList<>();
    TrieNode root;

    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0) return res;
        root = new TrieNode();
        buildTrie(words);
//        dfs(new LinkedList<>(), words, words[0].length());
        return res;
    }

    private void buildTrie(String[] words) {
        for (String word: words) {
            TrieNode itr = root;
            for (char c: word.toCharArray()) {
                if (itr.neighbor[c-'a'] == null) {
                    itr.neighbor[c-'a'] = new TrieNode();
                }
                itr = itr.neighbor[c-'a'];
            }
            itr.isWord = true;
        }
    }

    private void dfs(List<String> curr, String prefix, String path, TrieNode node, int len) {
        if (node.isWord) {
            curr.add(path);
        }
        if (curr.size() == len) {
            res.add(new LinkedList<>(curr));
            return;
        }
        for (int i = 0; i < 26; i++) {
            TrieNode neighbor = node.neighbor[i];
            if (neighbor == null) continue;
        }
    }

    public static void main(String[] args) {
        p425 sol = new p425();
        sol.wordSquares(new String[]{"ab", "ba"});
    }
}
