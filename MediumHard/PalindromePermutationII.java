/*
-- Take Away --
0. deal with duplicate for permutation / subset:
    dictionary is better then sorted array
    
refer to note: [Problem] 267. Palindrome Permutation II


1. str -> char array
2. char array -> str
3. array -> List
4. List -> array
5. StringBuilder deleteCharAt
6. Arrays.copyOf()
*/

class Solution {
    
    // solution 2: select form dictionary
    public List<String> generatePalindromes(String s) {
        List<String> rst = new ArrayList<String>();
        if(s == null || s.length() == 0)
            return rst;
        
        char[] stat = new char[256];
        for(int i = 0; i < s.length(); i++)
            stat[s.charAt(i)]++;
        
        int numOfOdd = 0;
        char mid = 0;
        for(int i = 0; i < 256; i++){
            if(stat[i]%2 == 1){
                numOfOdd++;
                mid = (char)i;
            }
        }
        if(numOfOdd > 1)  return rst;
        
        char[] cur = Arrays.copyOf(stat, 256);
        StringBuilder sb = new StringBuilder();    
        dfs(stat, cur, s.length(), sb, rst, mid);
        return rst;
    }
    
    void dfs(char[] stat, char[] cur, int len, StringBuilder sb, List<String> rst, char mid){
        if(sb.length() == len/2){
            StringBuilder tmpSb = new StringBuilder(sb);
            if(len%2 != 0)
                tmpSb.append(mid);
            for(int i = len/2-1; i >= 0; i--){
                tmpSb.append(tmpSb.charAt(i));
            }
            rst.add(tmpSb.toString());
        }
        else{
            for(int i = 0; i < 256; i++){
                if(cur[i] <= Math.ceil(stat[i]/2.0))
                    continue;
                sb.append((char)i);
                cur[i]--;
                dfs(stat, cur, len, sb, rst, mid);
                cur[i]++;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    

    
//     // solutiion 1: sorted array
//     public List<String> generatePalindromes(String s) {
//         List<String> rst = new ArrayList<String>();
//         if(s == null || s.length() == 0)
//             return rst;
//         // sort input to deal with duplication
//         char[] carr = s.toCharArray();
//         Arrays.sort(carr);
//         // get statistic
//         Map<Character, Integer> stat = new HashMap<Character, Integer>();
//         for(char c : carr){
//             int cnt = stat.containsKey(c) ? stat.get(c): 0;
//             stat.put(c, cnt+1);
//         }
//         Map<Character, Integer> curStat = new HashMap<Character, Integer>();
//         int[] visited = new int[carr.length];
//         StringBuilder sb = new StringBuilder();
//         dfs(carr, visited, stat, curStat, sb, rst);
//         return rst;
//     }
    
//     void dfs(char[] carr, int[] visited, Map<Character, Integer> stat, Map<Character, Integer> curStat, StringBuilder sb, List<String> rst){
//         if(sb.length() == Math.ceil(carr.length / 2.0)){
//             int i = sb.length()-1;
//             if(carr.length % 2 != 0) i--;
//             StringBuilder tmpSb = new StringBuilder(sb);
//             for(; i >= 0; i--)
//                 tmpSb.append(tmpSb.charAt(i));
//             rst.add(tmpSb.toString());
//             return;
//         }
//         int lastIdx = -1;
//         for(int i = 0; i < carr.length; i++){
//             if(visited[i] == 1)  continue;
//             if(lastIdx != -1 && carr[i] == carr[lastIdx])  continue;
//             // if(i != 0 && carr[i] == carr[i-1])  continue;
//             char c = carr[i];
//             int cnt = curStat.containsKey(c) ? curStat.get(c): 0;
//             if(carr.length % 2 == 0 || sb.length() != Math.ceil(carr.length / 2.0)-1){
//                 if(cnt+1 > stat.get(c)/2)  continue;
//             }
//             else{
//                 if(cnt*2 >= stat.get(c))  continue;
//             }
//             lastIdx = i;
//             sb.append(c);
//             visited[i] = 1;
//             curStat.put(c, cnt+1);
//             dfs(carr, visited, stat, curStat, sb, rst);
//             curStat.put(c,cnt);
//             visited[i] = 0;
//             sb.deleteCharAt(sb.length()-1);
//         }
//         return;
//     }
}