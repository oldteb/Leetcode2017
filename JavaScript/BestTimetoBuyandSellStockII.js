/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    if(prices == null || prices.length == 0)
        return 0

    let maxProfit = 0
    for(let i = 1 ; i < prices.length; i++){
        maxProfit += Math.max(prices[i] - prices[i-1], 0)
    }

    return maxProfit
};
