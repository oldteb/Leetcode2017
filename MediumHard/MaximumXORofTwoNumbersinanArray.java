// take away:
// 1) Use bit level iteration to reduce complexity
// 2) Property of XOR: a^b=c <==> a^c=b <==> b^c=a 
// 
// This question is like 2 sum:
// O(n^2) solution: nested loop comparation
// O(n) solution: use map/set + reverse calculation to check if the paired value exists

public class Solution {
    public int findMaximumXOR(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int max = 0;
        int mask = 0;
        
        for(int i = 30; i >= 0; i--){
            mask = mask | (1<<i);
            Set<Integer> set = new HashSet<Integer>(nums.length);
            for(int num : nums){
                set.add(num & mask);
            }
            
            int tmpMax = max | (1<<i);
            for(int num : nums){
                if(set.contains(tmpMax ^ (num & mask))){
                    max = tmpMax;
                    break;
                }
            }
        }
        
        return max;
    }
}