public List<Integer> findAnagrams(String s, String p) {
        List<Integer> rst = new ArrayList<Integer>();
        
        if(s == null || s.length() == 0
            || p == null || p.length() == 0)
                return rst;

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < p.length(); i++){
            char key = p.charAt(i);
            map.putIfAbsent(key,0);
            map.put(key,map.get(key)+1);
        }
        int count = p.length();
        for(int i = 0; i < s.length(); i++){
            char key = s.charAt(i);
            if(map.containsKey(key)){
                if(map.get(key) >= 1)  count--;
                map.put(key,map.get(key)-1);
            }
            if(i>=p.length()-1){
                if(count == 0){
                    rst.add(i-p.length()+1);
                }   
                char skey = s.charAt(i-p.length()+1);
                if(map.containsKey(skey)){
                    map.put(skey,map.get(skey)+1);
                    if(map.get(skey) >= 1)  count++;
                }
            }
        }
        return rst;
    }
}