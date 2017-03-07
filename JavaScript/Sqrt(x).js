/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    if(x <= 0)  return 0
    if(x == 1)  return 1

    // solution 1: O(n)
    // let i = 1
    // let tempVal = 1
    // while(tempVal < x){
    //     i++
    //     tempVal = i * i
    //     if(tempVal == x)  return i
    // }

    // solution 2: binary search O(lg(n))
    let left = 1
    let right = x
    while(left < right){
        let mid = Math.floor((left+right)/2)
        let tempVal = mid * mid
        if(tempVal == x)  return mid
        else if(tempVal < x){
            left = mid + 1
        }
        else{
            right = mid -1
        }
    }

    if(left * left == x)  return left
    else if(left * left < x)  return left
    else return left - 1
};
