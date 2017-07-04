public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        
        /* solution 1: DFS */
        // for(int i = 1; i <= 9; i++){
        //     dfs(n, i, rst);
        // }
        
        /* solution 2: iteration */
        int num = 1;
        while(num != 0){
            if(num <= n){
                rst.add(num);
                num = num*10;
            }
            else{
                num = num/10;
                while(num%10 == 9)
                    num = num/10;
                if(num == 0)
                    break;
                int minDigit = num%10;
                num = (num/10)*10 + minDigit+1;
            }         
        }
        
        return rst;
    }
    
    
    /* DFS solution */
    void dfs(int n, int num, List<Integer> rst){
        if(num > n)
            return;
        int tmp = 0;
        rst.add(num);
        for(int i = 0; i <= 9; i++){
            tmp = num*10+i;
            dfs(n,tmp,rst);
        }
        
        return;
    }
}
