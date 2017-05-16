public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0))
            return 0;

        if(nums1 == null || nums1.length == 0){
            return nums2.length%2 == 0 ? (nums2[nums2.length/2] + nums2[nums2.length/2-1])/2.0 : nums2[nums2.length/2];
        }
        else if(nums2 == null || nums2.length == 0){
            return nums1.length%2 == 0 ? (nums1[nums1.length/2] +  nums1[nums1.length/2-1])/2.0 : nums1[nums1.length/2];
        }

        if(nums1.length > nums2.length){
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int i = (left+right)/2;
            int j = (nums1.length+nums2.length+1)/2 - i;

            if((j == 0 || i == nums1.length || nums1[i] >= nums2[j-1])
                && (j == nums2.length || i == 0 || nums2[j] >= nums1[i-1])){
                int len = nums1.length + nums2.length;
                if(len%2 == 0){
                    int n1 = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
                    int n2 = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
                    int a = Math.max(n1,n2);
                    n1 = (i==nums1.length) ? Integer.MAX_VALUE : nums1[i];
                    n2 = (j==nums2.length) ? Integer.MAX_VALUE : nums2[j];
                    int b = Math.min(n1,n2);
                    return (a+b)/2.0;
                }
                else{
                    int a = (i==0) ? Integer.MIN_VALUE : nums1[i-1];
                    int b = (j==0) ? Integer.MIN_VALUE : nums2[j-1];
                    return Math.max(a,b);
                }
            }
            else if(j == 0 || i == nums1.length || nums1[i] >= nums2[j-1]){
                right = i-1;
            }
            else{
                left = i+1;
            }
        }

        return -1;

    }
}
