public class TwoSum {

    Map<Integer, Integer> map;
    
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer, Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
         map.put(number, map.containsKey(number) ? map.get(number)+1 : 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {

        Set<Map.Entry<Integer, Integer>> es = map.entrySet();
        Iterator iter = es.iterator();
        
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>)iter.next();
            int other = value - entry.getKey();
            if(map.containsKey(other) && (other != entry.getKey() || map.get(other) > 1)){
                return true; 
            }
        }
            
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */