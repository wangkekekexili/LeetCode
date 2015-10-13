import java.util.HashMap;
import java.util.Map;

public class AddAndSearchWord {
	public static void main(String[] args) {
		WordDictionary d = new WordDictionary();
		d.addWord("at");
		d.addWord("and");
		d.addWord("an");
		d.addWord("add");
		d.search("a");
		d.search(".at");
		d.addWord("bat");
		d.search(".at");
	}
}

class WordDictionary {

	class Node {
		boolean isWord = false;
		Map<Character, Node> map = new HashMap<>();
		void addWord(String word) {
			if (word.length() == 0) {
				isWord = true;
				return;
			}
			char firstChar = word.charAt(0);
			Node oldNode = map.get(firstChar);
			if (oldNode == null) {
				oldNode = new Node();
				map.put(firstChar, oldNode);
			}
			oldNode.addWord(word.substring(1));
		}
		boolean search(String word) {
			if (word.length() == 0) {
				if (isWord == true) {
					return true;
				} else {
					return false;
				}
			} 
			char firstChar = word.charAt(0);
			if (firstChar == '.') {
				for (Node n : map.values()) {
					if (n.search(word.substring(1)) == true) {
						return true;
					}
				}
				return false;
			} else {
				if (map.get(firstChar) == null) {
					return false;
				} else {
					return map.get(firstChar).search(word.substring(1));
				}
			}
		}
	}
	
	private Node root = new Node();;
	
    // Adds a word into the data structure.
    public void addWord(String word) {
        root.addWord(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return root.search(word);
    }
}
