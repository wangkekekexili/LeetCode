import java.util.HashMap;
import java.util.Map;

class TrieNode {
	boolean endOfWord = false;
	Map<Character, TrieNode> map = new HashMap<>();
	
	void insert(String word) {
		if (word == null || word.length() == 0) {
			endOfWord = true;
			return;
		}
		char firstChar = word.charAt(0);
		if (map.get(firstChar) == null) {
			map.put(firstChar, new TrieNode());
		}
		map.get(firstChar).insert(word.substring(1));
	}
	
	boolean search(String word) {
		if (word == null || word.length() == 0) {
			return endOfWord;
		}
		char firstChar = word.charAt(0);
		TrieNode nextNode = map.get(firstChar);
		if (nextNode == null) {
			return false;
		} else {
			return nextNode.search(word.substring(1));
		}
	}
	
	boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return true;
		}
		char firstChar = prefix.charAt(0);
		TrieNode nextNode = map.get(firstChar);
		if (nextNode == null) {
			return false;
		} else {
			return nextNode.startsWith(prefix.substring(1));
		}	
	}
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return root.search(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix);
    }
    
    public static void main(String[] args) {
    	Trie t = new Trie();
    	t.insert("ab");
    	System.out.println(t.startsWith("a"));
    }
}

