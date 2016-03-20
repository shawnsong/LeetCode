package leetcode;


class TrieSearch {
	// Initialize your data structure here.
	
	private char character;	
	// list can be replaced by array to increase efficiency: TrieSearch[] children = new TrieSearch[26]; 
	private TrieSearch[] children;
	private boolean terminates = false;
	
	public TrieSearch() {
		children = new TrieSearch[26];
	}
	
	public TrieSearch(char c) {
		this.character = c;
		children = new TrieSearch[26];
	}
	
	public char getCharacter() {
		return character;
	}
	
	public boolean getTerminates() {
		return terminates;
	}
	
	public void addWord(String word) {
		if (word == null || word.length() == 0)
			return;
		
		TrieSearch child = getChild( word.charAt(0));
		if (child == null) {
			child = new TrieSearch(word.charAt(0));
			children[child.getCharacter()- 'a'] = child;
		}
		if (word.length() == 1)
			child.terminates = true;
		else
			child.addWord(word.substring(1));
	}
	
	public boolean search(String word, boolean isPrefix) {
		if (word.length() == 0) {
			if ( this.getTerminates())
				return true;
			else 
				return false;
		}
		char c = word.charAt(0);
		if (c != '.') {
			TrieSearch child = this.getChild(c);
			if (child == null)
				return false;
			return child.search(word.substring(1), false);
		} else {
			for (TrieSearch child : children) {
				if (child != null) {
					boolean res = child.search(word.substring(1), false);
					if (res == true)
						return true;
				}
			}
		}
		return false;
	}
	
	public TrieSearch getChild(char c) {
		for (TrieSearch child : this.children) {
			if (child != null && child.getCharacter() == c)
				return child;
		}
		return null;
	}
	
	public TrieSearch[] getChildren() {
		return this.children;
	}
	
	public String toString() {
		return String.valueOf(character);
	}
}

public class Q211_AddAndSearchWord {
	TrieSearch root = new TrieSearch();
	// Adds a word into the data structure.
	
	public void addWord(String word) {
		root.addWord(word);
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return root.search(word, false);
	}
}
