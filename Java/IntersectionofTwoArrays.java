public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 ||
          nums2 == null || nums2.length == 0)  
            return new int[0];
        
        HashMap<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        
        for(int i : nums1){
            if(!numMap.containsKey(i))
                numMap.put(i,0);
        }
        
        List<Integer> rstList = new ArrayList<Integer>();
        
        for(int i : nums2){
            if(numMap.containsKey(i) && numMap.get(i) == 0){
                numMap.put(i,numMap.get(i) + 1);
                rstList.add(i);
            }
        }
        
        int[] rst = new int[rstList.size()];
        int idx = 0;
        for(int i : rstList)
            rst[idx++] = i;
        
        return rst;
    }
}
