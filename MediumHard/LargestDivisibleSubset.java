// take away:
// DP solution:
// 1. for implementation, sort the array in asc order
// 2. let F(i) represents the number of max divisibles from nums[0..i]
//      then F(i+1) = Max(F(k)+1), k from 0 to i, where nums[i] % nums[k] == 0

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> rst = new ArrayList<Integer>();
        
        if(nums == null || nums.length == 0)
            return rst;
        
        
        Node[] nodes = new Node[nums.length];
        Arrays.sort(nums);
        
        Node lastNode = null;
        int maxCnt = 0;
        
        for(int i = 0; i < nums.length; i++){
            int maxSet = 0;
            int lastIdx = -1;
            
            for(int j = i-1; j >= 0; j--){
                if(nums[i] % nums[j] == 0 && maxSet < nodes[j].cnt){
                    maxSet = nodes[j].cnt;
                    lastIdx = j;
                }
            }
            
            Node node = new Node(maxSet+1, i, lastIdx);
            nodes[i] = node;      
            
            if(maxCnt < node.cnt){
                lastNode = node;
                maxCnt = node.cnt;
            }
        }
        
        while(lastNode != null){
            rst.add(nums[lastNode.idx]);
            lastNode = lastNode.last == -1 ? null : nodes[lastNode.last];
        }
        
        return rst;
        
    }
    
    class Node{
        int cnt;
        int idx;
        int last;
        
        Node(int cnt, int idx, int last){
            this.cnt = cnt;
            this.idx = idx;
            this.last = last;
        }
    }
}