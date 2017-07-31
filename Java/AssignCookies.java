public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g == null || g.length == 0
          || s == null || s.length == 0)  return 0;
        
        Arrays.sort(g);
        Arrays.sort(s);
        
        int cnt = 0;
        
        int i = 0;
        int j = 0;
        while(i < g.length){
            while(j < s.length && s[j] < g[i])
                j++;
            if(j == s.length)  break;
            
            cnt++;
            i++;
            j++;
        }
        
        return cnt;
    }
}