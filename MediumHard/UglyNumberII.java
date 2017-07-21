// take away:
// this problem shows us two ways to solve find Kth problem:
// 1) iterate through all integer from 1 -> n, check every one till Kth element is found. O(n)
// 2) find a way to construct the sequence directly, O(k) time only

// use DP for this kind of problem:
// find the transition formula from smaller value to current value
// so we can quickly determine if the current value is valid or not

// refer to note: [Topic] Find Kth in sequence

public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 5)
            return n;
        // solution 1: linear search + DP
//         Set<Integer> set = new HashSet<Integer>();
//         set.add(1);
//         set.add(2);
//         set.add(3);
//         set.add(4);
//         set.add(5);
        
//         int cnt = 5;
//         int i = 6;
        
//         while(cnt < n){
//             if(i%2 == 0 && set.contains(i/2)
//               || i%3 == 0 && set.contains(i/3)
//               || i%5 == 0 && set.contains(i/5)){
//                 set.add(i);
//                 cnt++;
//             }
//             i++; 
//         }
//       
//         return i-1;
        
        // solution 2: O(n)
        int idx2 = 1;
        int idx3 = 1;
        int idx5 = 1;
        
        int[] buf = new int[n+1];
        buf[1] = 1;
        
        for(int i = 2; i <= n; i++){
            int head2 = buf[idx2]*2;
            int head3 = buf[idx3]*3;
            int head5 = buf[idx5]*5;
            
            int min = Math.min(head2, Math.min(head3, head5));
            
            buf[i] = min;
            
            if(min == head2)
                idx2++;
            if(min == head3)
                idx3++;
            if(min == head5)
                idx5++;
        }
        
        return buf[n];

    }
}