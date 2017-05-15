/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
    if(citations == null || citations.length == 0)
        return 0

    // linerar seach O(n)
    // let hIdx = 1
    // for(let i = citations.length-1; i >= 0; i--){
    //     if(citations[i] >= hIdx)
    //         hIdx++
    //     else
    //         break
    // }

    // binary search O(lg(n))
    let hIdx = 1
    let left = 0
    let right = citations.length-1
    while(left < right){
        let mid = Math.floor((left+right)/2)
        let hi = citations.length - mid
        if(citations[mid] < hi)
            left = mid+1
        else
            right = mid
    }

    if(citations[left] < citations.length - left)
        return citations.length - left - 1

    return citations.length - left
};
