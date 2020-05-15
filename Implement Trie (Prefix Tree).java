/*

Implement a trie with insert, search, and startsWith methods.

Example:
Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");   
trie.search("app");     // returns true

Note:
You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.

*/

class Trie {
    
    Trie[] child;
    boolean wordEnd;

    /** Initialize your data structure here. */
    public Trie() {
        child = new Trie[26];
        wordEnd = false;        
        for(int i=0; i<26; i++)
            child[i] = null;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {        
        Trie t = this;        
        for(char ch : word.toCharArray()){
            if(t.child[ch - 'a'] == null){
                t.child[ch - 'a'] = new Trie();
            }
            t = t.child[ch - 'a'];
        }        
        t.wordEnd = true;        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie t = this;
        for(char ch : word.toCharArray()){
            if(t.child[ch - 'a'] == null){
                return false;
            }
            t = t.child[ch - 'a'];
        }        
        return t.wordEnd;        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie t = this;
        for(char ch : prefix.toCharArray()){
            if(t.child[ch - 'a'] == null){
                return false;
            }
            t = t.child[ch - 'a'];
        }        
        return true;   
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
