
// pattern finding:
// rst[k] = rst[k-T]+1, where 2^T <= k < 2^(T+1)
public class Solution {
    public int[] countBits(int num) {
        int[] rst = new int[num+1];
        rst[0] = 0;

        int T = 1;
        int cnt = 1;
        while(true){
            for(int i = 0; i < T; i++){
                if(cnt > num){
                    return rst;
                }
                rst[cnt] = rst[cnt-T] + 1;
                cnt++;
            }
            T *= 2;
        }

    }
}
