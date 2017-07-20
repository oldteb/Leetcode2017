public class Solution {
    public int minCost(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0)
            return 0;
        
        int costR = costs[0][0];
        int costB = costs[0][1];
        int costG = costs[0][2];
        
        for(int i = 1; i < costs.length; i++){
            int tmpR = Math.min(costB,costG) + costs[i][0];
            int tmpB = Math.min(costR,costG) + costs[i][1];
            int tmpG = Math.min(costR,costB) + costs[i][2];
            
            costR = tmpR;
            costB = tmpB;
            costG = tmpG;
        }
        
        return Math.min(costR, Math.min(costB, costG));
    
    }
}