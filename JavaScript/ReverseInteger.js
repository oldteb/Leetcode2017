/**
 * @param {number} x
 * @return {number}
 */

 // takeaway
 // to determine if an integer is overflowed
 // simply do reverse calculation
var reverse = function(x) {
    var reversed = 0

    while(x != 0){
        let last = x%10
        x = (x-last)/10
        reversed = reversed * 10 + last
        if(reversed > 2147483647 || reversed < -2147483648)
            return 0
        // if((temp-last)/10 != reversed){
        //     return 0
        // }
    }

    return reversed
};
