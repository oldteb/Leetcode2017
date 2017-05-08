/**
 * @param {string} str
 * @returns {string}
 */
var reverseWords = function(str) {
    if(str == null || str.length == 0)
        return ""

    var strArray = str.split(" ")

    var rst = ""
    for(let i = strArray.length-1; i >= 0; i--){
        if(strArray[i].length == 0)  continue
        rst += strArray[i]
        rst += " "
    }

    if(rst.length != 0)
        rst = rst.slice(0, rst.length-1)

    return rst
};
