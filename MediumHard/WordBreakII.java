/*
-- Take Away --
1. Brute force Backtracing will cause TLE. (worst case time complexity is: O(n*2^n))
2. Limit search word len to maxLen: still cause TLE.
3. Use Memorization (prune) to avoid repeated calculation (DP idealology)
4. If the dictionary is small, we can iterate throught the dictionary to instead of search in set.

*/


class Solution {
    
    // solutin 2: Backtracking + Meomorization
    public List<String> wordBreak(String s, List<String> wordDict){
        List<String> rst = new ArrayList<String>();
        if(s == null || s.length() == 0)  return rst;
        int maxLen = 0;
        Set<String> set = new HashSet<String>();
        for(String str : wordDict){
            set.add(str);
            maxLen = Math.max(maxLen, str.length());
        }
        Map<String, List<String>> memo = new HashMap<String, List<String>>();
        return wordBreakSub(s,set,memo,maxLen);
        
    }
    
    List<String> wordBreakSub(String s, Set<String> set, Map<String, List<String>> memo, int maxLen){
        List<String> rst = new LinkedList<String>();
        if(s.length() == 0){
            rst.add("");
            return rst;
        }
        if(memo.containsKey(s))  return memo.get(s);
        for(int i = 1; i <= s.length() && i <= maxLen; i++){
            String word = s.substring(0,i);
            if(set.contains(word)){
                List<String> list = wordBreakSub(s.substring(i), set, memo, maxLen);
                if(list.size() == 0)  continue;
                for(String wd : list)
                    rst.add(word + (wd.length() == 0 ? "" : " ") + wd);
            }
        }
        memo.put(s,rst);
        return rst;
    }
    

    
    // solution 1: Brute Force Backtracing
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         List<String> rst = new ArrayList<String>();
//         if(s == null || s.length() == 0)  return rst;
//         int maxLen = 0;
//         Set<String> set = new HashSet<String>();
//         for(String str : wordDict){
//             set.add(str);
//             maxLen = Math.max(maxLen, str.length());
//         }   
//         StringBuilder sb = new StringBuilder();
//         dfs(s, 0, set, sb, rst, maxLen);
//         return rst;
//     }
    
//     void dfs(String s, int lvl, Set<String> set, StringBuilder sb, List<String> rst, int maxLen){
//         if(lvl == s.length()){
//             String candidate = sb.substring(0,sb.length()-1);
//             rst.add(candidate);
//             return;
//         }
//         for(int i = lvl+1; i <= s.length() && i-lvl <= maxLen; i++){
//             String word = s.substring(lvl,i);
//             if(set.contains(word)){
//                 sb.append(word + " ");
//                 dfs(s, i, set, sb, rst, maxLen);
//                 sb.delete(sb.length()-word.length()-1, sb.length());
//             }
//         }
//     }
    
}