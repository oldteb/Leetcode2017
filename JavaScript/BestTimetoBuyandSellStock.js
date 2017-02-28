/**
 * @param {number[]} prices
 * @return {number}
 */
 // take-away
 // MAKE SURE that the equal sign is '==' not '=' !!!
var maxProfit = function(prices) {
    if(prices == null || prices.length == 0)
        return 0

    var maxProfit = 0
    var lowIdx = 0

    for(let i = 1; i < prices.length; i++){
        if((prices[i] - prices[lowIdx]) > maxProfit){
            maxProfit = prices[i] - prices[lowIdx]
        }
        else if(prices[i] < prices[lowIdx]){
            lowIdx = i
        }
    }

    return maxProfit

};
