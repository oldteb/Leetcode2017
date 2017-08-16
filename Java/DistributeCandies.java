public class Solution {
    public int distributeCandies(int[] candies) {
        if(candies == null || candies.length == 0)
            return 0;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < candies.length; i++){
            set.add(candies[i]);
        }
        
        return Math.min(set.size(), candies.length/2);
    }
}