public class RandomizedSet {

    Map<Integer, Integer> elemIdxMap;
    List<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        elemIdxMap = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!elemIdxMap.containsKey(val)){
            list.add(val);
            elemIdxMap.put(val, list.size()-1);
            return true;
        }
        else
            return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(elemIdxMap.containsKey(val)){
            if(elemIdxMap.get(val) != list.size()-1){
                int spot = elemIdxMap.get(val);
                list.set(spot, list.get(list.size()-1));
                elemIdxMap.put(list.get(spot), spot);
            }

            elemIdxMap.remove(val);
            list.remove((int)(list.size()-1));
            return true;
        }
        else
            return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randIdx = new Random().nextInt(list.size());
        return list.get(randIdx);
    }

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
