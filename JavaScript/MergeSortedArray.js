/**
 * @param {number[]} nums1
 * @param {number} m
 * @param {number[]} nums2
 * @param {number} n
 * @return {void} Do not return anything, modify nums1 in-place instead.
 */
 // take away
 // Number.NEGATIVE_INFINITY is 'Integer.MIN_VALUE' in  Java
var merge = function(nums1, m, nums2, n) {
    if(nums1 == null || nums2 == null)
        return nums1

    let cursor1 = m-1
    let cursor2 = n-1
    let index = m+n-1

    while(index >= 0){
        let n1 = cursor1 >= 0 ? nums1[cursor1] : Number.NEGATIVE_INFINITY
        let n2 = cursor2 >= 0 ? nums2[cursor2] : Number.NEGATIVE_INFINITY
        if(n1 > n2){
            nums1[index--] = n1
            cursor1--
        }
        else{
            nums1[index--] = n2
            cursor2--
        }
    }

};
