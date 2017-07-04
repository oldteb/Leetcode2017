// take away
// opt1: use double map to keep mutual references
// opt2: use array instead of hashmap to speed up searching

public class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || secret.length() == 0)
            return "0A0B";
        
        int numA = 0;
        int numB = 0;
        
        int[] buf1 = new int[10];
        int[] buf2 = new int[10];
        
        
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                numA++;
            }
            else{
                int digit1 = secret.charAt(i) - '0';
                int digit2 = guess.charAt(i) - '0';
                if(buf2[digit1] > 0){
                    numB++;
                    buf2[digit1] -= 1;
                }
                else{
                    buf1[digit1]++;
                }
                
                if(buf1[digit2] > 0){
                    numB++;
                    buf1[digit2] -= 1;
                }
                else{
                    buf2[digit2]++;
                }
            }
        }
        
        return String.valueOf(numA) + "A" + String.valueOf(numB) + "B";
    }
}