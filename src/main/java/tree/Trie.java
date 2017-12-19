package tree;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie {
    TrieNode root;
    Set<String> distinctWordSet; // avoid adding duplicate words

    public Trie() {
        root = new TrieNode();
        distinctWordSet = new HashSet<>();
    }

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isWord;
        int wordFollowing;

        TrieNode() {
            children = new HashMap<>();
        }
    }

    public boolean add(String w) {
        // avoid adding duplicate words
        if (distinctWordSet.contains(w))
            return false;

        distinctWordSet.add(w);

        TrieNode cur = root;
        for (int i = 0; i < w.length(); i++) {
            char c = w.charAt(i);

            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);

            // assumption: no duplicate name for adding
            cur.wordFollowing++;
        }

        cur.isWord = true;
        return true;
    }

    public int findPartial(String p) {
        TrieNode cur = root;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            if (cur.children.get(c) == null) {
                System.out.println(0);
                return 0;
            }

            cur = cur.children.get(c);
        }

        System.out.println(cur.wordFollowing);
        return cur.wordFollowing;
    }
}