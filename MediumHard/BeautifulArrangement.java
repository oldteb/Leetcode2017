/*
-- Take Away --

No DP solution found, use BT to solve

Performance O(n!)?

Categries: put elements together to form combination

1. use visited array or linked list to represent available resources
2. Early failure can boost performance significatly.

*/

public class Solution {
    public int countArrangement(int N) {
        if(N <= 1)  return N;
        
        int[] inf = new int[N+1];
        
        return dfs(inf.length-1, inf, 0);
    }
    
    int dfs(int i, int[] inf, int rst){
        if(i == 0){
            return rst+1;
        }
        
        for(int cur = inf.length-1; cur > 0; cur--){
            if(inf[cur] == 1)  continue;
            if(cur%i == 0 || i%cur == 0){
                inf[cur] = 1;
                rst = dfs(i-1, inf, rst);
                inf[cur] = 0;
            }
        }
        
        return rst;
    }
}