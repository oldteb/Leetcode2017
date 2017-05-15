
// refer to note: [Problem] 220. Contains Duplicate III
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0)  return false;
        if(k <= 0 || t < 0)  return false;

        // solution 1: Buckets O(n)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int cap = Math.max(1,t);
            if(i-k-1 >= 0)  // delete old record from map
                map.remove(nums[i-k-1]/cap);
            for(int n = nums[i]/cap-1; n <= nums[i]/cap+1; n++)
                if(map.get(n) != null){
                    long arg1 = map.get(n);
                    long arg2 = nums[i];
                    if(Math.max(arg1,arg2) - Math.min(arg1,arg2) <= (long)t)  return true;
                }
            map.put(nums[i]/cap,nums[i]);
        }

        // solution 2: BST O(nlg(k))
        // TreeSet<Long> bst = new TreeSet<Long>();
        // long kl = (long)k;
        // long tl = (long)t;
        // for(int i = 0; i < nums.length; i++){
        //     SortedSet duplicatesSet = bst.subSet(nums[i]-tl, nums[i]+tl+1);
        //     if(duplicatesSet != null && duplicatesSet.size() != 0)
        //         return true;
        //     // add to BST
        //     bst.add((long)nums[i]);
        //     // remove old element BST to maintain windows size of k
        //     if(i >= kl){
        //         bst.remove((long)nums[(int)(i-kl)]);
        //     }
        // }

        return false;
    }
}
