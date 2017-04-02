// take away:
// Keyword for this question:
// Largest => DP, Greedy
// Array Combination/re-arrangement => DFS/BFS/Sort
// The solution is to sort the array
// Performance: O(n^2)/O(n)
// see notes for more detail


public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "0";

        String[] strNums = new String[nums.length];
        int i = 0;
        for(int num : nums){
            String str = String.valueOf(num);
            strNums[i++] = str;
        }

        Arrays.sort(strNums, new Comparator<String>(){
            public int compare(String stra, String strb){
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                sb1.append(stra).append(strb);
                sb2.append(strb).append(stra);

                int i = 0;
                while(i < sb1.length()){
                    if(sb1.charAt(i) > sb2.charAt(i)){
                        return -1;
                    }
                    else if(sb1.charAt(i) < sb2.charAt(i)){
                        return 1;
                    }
                    i++;
                }

                return 0;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String str : strNums){
            sb.append(str);
        }

        i = 0;
        while(i < sb.length()){
            if(sb.charAt(i) != '0'){
                break;
            }
            i++;
        }

        String rst = sb.substring(i);
        if(rst == null || rst.length() == 0)
            rst = "0";

        return rst;

    }

}
