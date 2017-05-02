/**
 * @param {number[]} citations
 * @return {number}
 */

 // take away
 // the nature of H-index is to divide citations into 2 category (high an low)
 // sort the array from high to low
 // then we can find the balanced point (H-index)

var hIndex = function(citations) {
    if(citations == null || citations.length == 0)
        return 0

    // sort array in descending order
    citations.sort(function(a,b){return b-a})
    if(citations[0] == 0)
        return 0

    let hIndex = 1
    while(hIndex <= citations.length){
        if(citations[hIndex-1] < hIndex)
            return hIndex-1
        hIndex++
    }

    // solution 2: bucket sort
    // ...

    return hIndex-1
};
