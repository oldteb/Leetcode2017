/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if(n == 0)
            return 0;
        int left = 1;
        int right = n;
        
        while(left < right){
            int mid = (right - left) / 2 + left;
            boolean rst = isBadVersion(mid);
            if(rst == true){
                if(mid == left || isBadVersion(mid-1) == false)
                    return mid;
                else
                    right = mid-1;
            }
            else{
                left = mid + 1;
            }            
        }
        
        return left;
    }
}
