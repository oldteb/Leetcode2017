// takeaway
// there is two method to do random shuffling of an array:
//    1. random pick from array and move it afterwards
//    2. randomly pick an element from the rest of elements in array and swap it.


public class Solution {

    private int[] defaultNums = null;

    public Solution(int[] nums) {
        defaultNums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return defaultNums;
    }

    // solution 1
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> temp = new ArrayList<Integer>();
        int[] list = new int[defaultNums.length];

        for(int i = 0; i < list.length; i++){
            temp.add(defaultNums[i]);
        }

        for(int i = 0; i < list.length; i++){
            Random rand = new Random();
        		int randomNum = rand.nextInt((temp.size()-1) + 1);
        		int card = temp.get(randomNum);
        		temp.remove(randomNum);
        		list[i] = card;
        }

		    return list;
    }

    // solution 2
    /** Returns a random shuffling of the array. */
    // public int[] shuffle() {
    //     if(nums == null) return null;
    //     int[] a = nums.clone();
    //     for(int j = 1; j < a.length; j++) {
    //         int i = random.nextInt(j + 1);
    //         swap(a, i, j);
    //     }
    //     return a;
    // }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
