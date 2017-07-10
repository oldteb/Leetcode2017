public class Solution {
    public String[] findWords(String[] words) {
        if(words == null || words.length == 0)
            return new String[0];
        
        Map<Character, Integer> dict = new HashMap<Character, Integer>();
        
        dict.put('q',1);
        dict.put('w',1);
        dict.put('e',1);
        dict.put('r',1);
        dict.put('t',1);
        dict.put('y',1);
        dict.put('u',1);
        dict.put('i',1);
        dict.put('o',1);
        dict.put('p',1);
        dict.put('a',2);
        dict.put('s',2);
        dict.put('d',2);
        dict.put('f',2);
        dict.put('g',2);
        dict.put('h',2);
        dict.put('j',2);
        dict.put('k',2);
        dict.put('l',2);
        dict.put('z',4);
        dict.put('x',4);
        dict.put('c',4);
        dict.put('v',4);
        dict.put('b',4);
        dict.put('n',4);
        dict.put('m',4);
              
        List<String> rstList = new ArrayList<String>();
                 
        for(String str : words){
            int sum = 0;
            String lowCaseStr = str.toLowerCase();
            for(int i = 0; i < lowCaseStr.length(); i++)
                sum |= dict.get(lowCaseStr.charAt(i));
            if(sum == 1 || sum == 2 || sum == 4)
                rstList.add(str);
        }
                 
        String[] rst = new String[rstList.size()];    
        
        for(int i = 0; i < rstList.size(); i++){
            rst[i] = rstList.get(i);
        }
                 
        return rst;
        
    }
}