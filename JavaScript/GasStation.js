/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
 // take away
 // solution 1: brute force: O(n^2)
 // solution 2: two pointers, borrow gas from previous gas station
var canCompleteCircuit = function(gas, cost) {
    if(gas == null || gas.length == 0 || cost == null || cost.length == 0)
        return -1

    let start = 0
    let end = 0
    let total = 0
    let begin = 1

    while(start != end || begin == 1){
        if(begin == 1){
            begin = 0
        }

        if(total >= 0){
            total += gas[end] - cost[end]
            end = (end+1) % gas.length
        }
        else{
            start = start-1 >= 0 ? (start-1) : gas.length-1
            total += gas[start] - cost[start]
        }
    }

    if(total >= 0)  return start
    else return -1

};
