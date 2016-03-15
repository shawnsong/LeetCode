package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
 * Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 * 
 */
class TrieNode {
	// Initialize your data structure here.
	
	private char character;	
	// list can be replaced by array to increase efficiency: TrieNode[] children = new TrieNode[26]; 
	private List<TrieNode> children;
	private boolean terminates = false;
	
	public TrieNode() {
		children = new LinkedList();
	}
	
	public TrieNode(char c) {
		this.character = c;
		children = new LinkedList();
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
		
		TrieNode child = getChild( word.charAt(0));
		if (child == null) {
			child = new TrieNode(word.charAt(0));
			children.add(child);
		}
		if (word.length() == 1)
			child.terminates = true;
		else
			child.addWord(word.substring(1));
	}
	
	public boolean search(String word, boolean isPrefix) {
		if (word.length() == 0) {
			if (isPrefix)
				return true;
			else if (this.terminates == true)
				return true;
			else
				return false;
		}
		TrieNode child = getChild(word.charAt(0));
		if (child == null)
			return false;
		return child.search(word.substring(1), isPrefix);
	}
	
	public TrieNode getChild(char c) {
		for (TrieNode child : this.children) {
			if (child.getCharacter() == c)
				return child;
		}
		return null;
	}
	
	public String toString() {
		return String.valueOf(character);
	}
}

public class Q208_Trie {
	private TrieNode root;

	public Q208_Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		root.addWord(word);
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		return root.search(word, false);
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return root.search(prefix, true);
	}
}
