/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    if(numRows == null || numRows == 0)
        return []
    
    var rst = new Array()
    var lastList = [1]
    rst.push(lastList)
    
    for(let i = 1; i < numRows; i++){
        var list = new Array(lastList.length + 1)
        list[0] = 1
        for(let j = 1; j < lastList.length; j++){
            list[j] = lastList[j-1] + lastList[j]
        }
        list[list.length-1] = 1
        rst.push(list)
        lastList = list
    }
    
    return rst
    
};
