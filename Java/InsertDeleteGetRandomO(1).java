public class RandomizedSet {
    Map<Integer, Integer> valMap = new HashMap<Integer, Integer>();
    Map<Integer, Integer> idxMap = new HashMap<Integer, Integer>();
    Random rand = null;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        rand = new Random(System.currentTimeMillis());
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(valMap.containsKey(val)){
            return false;
        }

        int idx = valMap.size();
        valMap.put(val, idx);
        idxMap.put(idx, val);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!valMap.containsKey(val)){
            return false;
        }

        int idx = valMap.get(val);
        valMap.remove(val);
        idxMap.remove(idx);

        if(!idxMap.containsKey(valMap.size())){
            return true;
        }

        int tmpVal = idxMap.get(valMap.size());
        idxMap.remove(valMap.size());
        idxMap.put(idx, tmpVal);
        valMap.put(tmpVal, idx);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if(valMap.size()==0){
            return -1;
        }

        if(valMap.size()==1){
            return idxMap.get(0);
        }

        return idxMap.get(new Random().nextInt(valMap.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
