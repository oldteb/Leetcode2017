public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(words == null || words.length == 0 || word1 == null || word2 == null){
            return 0;
        }
        
        int idx1 = -1;
        int idx2 = -1;
        int shortestDistance = Integer.MAX_VALUE;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1))
                idx1 = i;
            else if(words[i].equals(word2))
                idx2 = i;
            else
                continue;
            
            if(idx1 != -1 && idx2 != -1)
                shortestDistance = Math.min(shortestDistance, Math.abs(idx1-idx2));
            if(shortestDistance == 1)
                return 1;
        }
        
        return shortestDistance;
    }
}