// take away
// if statistic on 26 english characters
// use compressed integer to store the infomation
// instead of array or even hash table

public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0)
            return 0;
        
        int maxProduct = Integer.MIN_VALUE;
        
        for(int i = 0; i < words.length; i++){
            int a = compress(words[i]);
            for(int j = i+1; j < words.length; j++){
                int b = compress(words[j]);
                if((a&b) == 0)
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
            }
        }
        
        return maxProduct == Integer.MIN_VALUE ? 0 : maxProduct;
        
    }
    
    public int compress(String word){
        int rst = 0;
        
        for(int i = 0; i < word.length(); i++){
            rst |= (1<<(word.charAt(i)-'a'));
        }
        
        return rst;
    }
}