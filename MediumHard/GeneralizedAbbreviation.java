public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> rst = new ArrayList<String>();
        if(word == null || word.length() == 0){
            rst.add("");
            return rst;
        }
        
        StringBuilder sb = new StringBuilder();
        
        dfs(word, sb, 0, rst);
        
        return rst;
    }
    
    void dfs(String word, StringBuilder sb, int level, List<String> rst){
        if(level >= word.length()){
            rst.add(sb.toString());
            return;
        }
        
        for(int i = 0; level + i <= word.length(); i++){
            if(i == 0){
                sb.append(word.charAt(level));
                dfs(word, sb, level+1, rst);
                sb.deleteCharAt(sb.length()-1);
            }
            else{
                String numStr = String.valueOf(i);
                sb.append(numStr);
                if(level+i < word.length()){
                    sb.append(word.charAt(level+i));
                    dfs(word, sb, level+i+1, rst);
                    sb.delete(sb.length() - numStr.length() - 1, sb.length());
                }
                else{
                    dfs(word, sb, level+i, rst);
                    sb.delete(sb.length() - numStr.length(), sb.length());
                }
            }
        }
        
        return;
        
    }
    
    
}