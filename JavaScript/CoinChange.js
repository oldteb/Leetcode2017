/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
 // take away:
 // array comnination search, consider:
 // 1) DFS search
 // 2) DP
 // This problem has obvious DP solution: (key word: fewest)
 // Let F(n) be the minimum coins needed, then
 // F(n) = MIN(F(x)+1), where x each coin value
 // Therefore we can build up result from bottom up.
var coinChange = function(coins, amount) {
    if(coins == null || coins.length == 0 || amount < 0)
        return -1

    if(amount == 0)  return 0

    var buf = []
    for(let i = 0; i <= amount; i++){
        buf[i] = -1
    }

    for(let i = 0; i < coins.length; i++){
        buf[coins[i]] = 1
    }

    for(let i = 1; i <= amount; i++){
        for(let j = 0; j < coins.length; j++){
            let idx = i - coins[j]
            if(idx <= 0 || buf[idx] == -1)  continue
            buf[i] = (buf[i] == -1 ? (buf[idx]+1) : Math.min(buf[idx]+1, buf[i]))
        }
    }

    return buf[amount]
};
