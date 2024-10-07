package intermediate.src.week1_labs.advance_ds;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    // TrieNode class represents each node in the Trie
    static class TrieNode {
        TrieNode[] children = new TrieNode[ 26 ]; // Array for 26 lowercase letters (a-z)
        boolean isEndOfWord = false; // Marks if this node represents the end of a word
    }
    
    private final TrieNode root;
    
    // Constructor to initialize the Trie
    public Trie () {
        root = new TrieNode();
    }
    
    // Inserts a word into the Trie
    public void insert (String word) {
        TrieNode node = root;
        for ( char ch : word.toCharArray() ) {
            int index = ch - 'a'; // Convert character to index (0-25)
            if ( node.children[ index ] == null ) {
                node.children[ index ] = new TrieNode(); // Create new node if it doesn't exist
            }
            node = node.children[ index ];
        }
        node.isEndOfWord = true; // Mark the end of the word
    }
    
    // Searches for a word in the Trie
    public boolean search (String word) {
        TrieNode node = root;
        for ( char ch : word.toCharArray() ) {
            int index = ch - 'a';
            if ( node.children[ index ] == null ) {
                return false; // Word not found
            }
            node = node.children[ index ];
        }
        return node.isEndOfWord; // Return true if it's the end of a word
    }
    
    // Returns true if there is any word in the Trie that starts with the given prefix
    public boolean startsWith (String prefix) {
        TrieNode node = root;
        for ( char ch : prefix.toCharArray() ) {
            int index = ch - 'a';
            if ( node.children[ index ] == null ) {
                return false; // Prefix not found
            }
            node = node.children[ index ];
        }
        return true; // Prefix exists
    }
    
    // Helper method to find all words starting with a given prefix
    public List<String> getWordsWithPrefix (String prefix) {
        TrieNode node = root;
        List<String> result = new ArrayList<>();
        
        // Navigate to the node that represents the last letter of the prefix
        for ( char ch : prefix.toCharArray() ) {
            int index = ch - 'a';
            if ( node.children[ index ] == null ) {
                return result; // Return empty list if prefix doesn't exist
            }
            node = node.children[ index ];
        }
        
        // Collect all words starting from this node
        collectAllWords( node, prefix, result );
        return result;
    }
    
    // Helper method to collect words recursively from the given node
    private void collectAllWords (TrieNode node, String word, List<String> result) {
        if ( node.isEndOfWord ) {
            result.add( word );
        }
        for ( int i = 0; i < 26; i++ ) {
            if ( node.children[ i ] != null ) {
                char nextChar = (char) ( i + 'a' );
                collectAllWords( node.children[ i ], word + nextChar, result );
            }
        }
    }
    
    public static void main (String[] args) {
        Trie trie = new Trie();
        
        // Insert words
        trie.insert( "apple" );
        trie.insert( "appetite" );
        trie.insert( "banana" );
        trie.insert( "bat" );
        
        // Search for words
        System.out.println( trie.search( "appetite" ) );    // Output: true
        System.out.println( trie.search( "bat" ) );    // Output: true
        System.out.println( trie.search( "batman" ) ); // Output: false
        
        // Check for prefixes
        System.out.println( trie.startsWith( "ban" ) );  // Output: true
        System.out.println( trie.startsWith( "cat" ) );  // Output: false
        
        // Get all words starting with a prefix
        System.out.println( trie.getWordsWithPrefix( "app" ) ); // Output: [appetite, apple]
        System.out.println( trie.getWordsWithPrefix( "ba" ) );  // Output: [banana, bat]
    }
}




