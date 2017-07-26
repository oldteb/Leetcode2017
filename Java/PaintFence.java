// take away:
// Characteristics that problem has a DP solution:
// 1) looking for optimal solution
// 2) looking for number of ways (without return the actual set)

public class Solution {
    public int numWays(int n, int k) {
        if(n == 0 || k == 0)  return 0;
        if(n == 1)  return k;
        
        int diffColor = k*(k-1);
        int sameColor = k;
        
        for(int i = 2; i < n; i++){
            int newDiffColor = diffColor * (k-1) + sameColor * (k-1);
            int newSameColor = diffColor;
            diffColor = newDiffColor;
            sameColor = newSameColor;
        }
        
        return diffColor + sameColor;
    }
}