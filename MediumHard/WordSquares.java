/*
-- Take Away --
Permutation + Word Search

Use Trie to speed up word search in matrix

Complexity:
    1) build Trie Tree: k * n
    2) get permutation: n^k
    3) cost of get all words with prefix: O(1)
    worst case total: kn + n^k = O(n^k)

*/


class Solution {
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> rst = new ArrayList<List<String>>();
        if(words == null || words.length == 0)  return rst;
        
        List<String> cur = new ArrayList<String>();
        Dictionary dict = new Dictionary(words);
        dfs(words, 0, cur, rst, dict);
        return rst;
    }
    
    void dfs(String[] words, int lvl, List<String> cur, List<List<String>> rst, Dictionary dict){
        if(lvl == words[0].length()){
            rst.add(new ArrayList<String>(cur));
            return;
        }
        String prefix = getPrefix(lvl, cur);
        List<String> list = dict.getWordsWithPrefix(prefix);
        for(String str : list){
            cur.add(str);
            dfs(words, lvl+1, cur, rst, dict);
            cur.remove(cur.size()-1);
        }
        return;
    }
    
    String getPrefix(int lvl, List<String> cur){
        if(lvl == 0)  return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lvl; i++){
            sb.append(cur.get(i).charAt(lvl));
        }
        return sb.toString();
    }
    
    
    class Dictionary {
        
        DicNode root;
        
        Dictionary(String[] words){
            root = new DicNode('0');
            for(String str : words)
                addWord(str);
        }
            
        public void addWord(String str){
            DicNode rt = root;
            int i = 0;
            while(i < str.length()){
                if(rt.childs[str.charAt(i)-'a'] == null)
                    rt.childs[str.charAt(i)-'a'] = new DicNode(str.charAt(i));
                rt = rt.childs[str.charAt(i)-'a'];
                i++;
            }
        }
        
        public List<String> getWordsWithPrefix(String prefix){
            List<String> rst = new ArrayList<String>();
            DicNode rt = root;
            int i = 0;
            while(i < prefix.length()){
                if(rt.childs[prefix.charAt(i)-'a'] == null)
                    return rst;
                rt = rt.childs[prefix.charAt(i)-'a'];
                i++;
            }
            
            StringBuilder sb = new StringBuilder(prefix);
            getAll(rt, rst, sb);
            return rst;
        }
        
        void getAll(DicNode rt, List<String> rst, StringBuilder sb){
            boolean isLeaf = true;
            for(int i = 0; i < 26; i++){
                if(rt.childs[i] != null){
                    isLeaf = false;
                    sb.append(rt.childs[i].c);
                    getAll(rt.childs[i],rst,sb);
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            if(isLeaf == true)
                rst.add(sb.toString());
        }
        
    }
    
    class DicNode {
        char c;
        DicNode[] childs = new DicNode[26];

        DicNode(char c){
            this.c = c;
        }
    }
    
    
}