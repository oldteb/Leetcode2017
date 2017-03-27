public class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('a');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root.store(word);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0)  return false;
        return dfs(root.children[word.charAt(0)-'a'], word, 0, true);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)  return false;
        return dfs(root.children[prefix.charAt(0)-'a'], prefix, 0, false);
    }


    boolean dfs(TrieNode root, String word, int idx, boolean findLeaf){
        if(root == null)  return false;

        char c = word.charAt(idx);
        if(root.value != c)  return false;

        if(idx == word.length()-1){
            if(findLeaf){
                if(root.isLeaf == true)  return true;
                else return false;
            }
            else return true;
        }

        c = word.charAt(idx+1);
        TrieNode node = root.children[c-'a'];
        return dfs(node, word, idx+1, findLeaf);
    }

    class TrieNode {
        char value;
        boolean isLeaf;
        TrieNode[] children;

        TrieNode(char c){
            this.value = c;
            this.children = new TrieNode[26];
        }

        void store(String word){
            if(word == null || word.length() == 0)  return;

            char c = word.charAt(0);
            TrieNode node = (children[c-'a'] == null) ? (new TrieNode(c)) : children[c-'a'];
            if(word.length() == 1){
                node.isLeaf = true;
            }
            else{
                node.store(word.substring(1));
            }
            children[c-'a'] = node;
            return;
        }
    }


}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
