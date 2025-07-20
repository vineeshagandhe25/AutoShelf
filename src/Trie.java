import java.util.*;

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            curr.children.putIfAbsent(ch, new TrieNode());
            curr = curr.children.get(ch);
        }
        curr.isEndOfWord = true;
        curr.fullWord = word; // store original word
    }

    public List<String> getWordsByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode curr = root;
        for (char ch : prefix.toLowerCase().toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                return result;
            }
            curr = curr.children.get(ch);
        }
        dfs(curr, result);
        return result;
    }

    private void dfs(TrieNode node, List<String> result) {
        if (node.isEndOfWord) {
            result.add(node.fullWord);
        }
        for (char ch : node.children.keySet()) {
            dfs(node.children.get(ch), result);
        }
    }
}
