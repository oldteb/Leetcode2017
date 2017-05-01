/**
 * @param {string} s
 * @param {number} k
 * @return {string}
 */
 // reverse problem
var reverseStr = function(s, k) {
    if(s == null || s.length == 0  || k <= 1)
        return s

    var buf = []
    for(let i = 0;i < s.length; i++){
        buf[i] = s.charAt(i)
    }


    let turn = 0
    for(let i = 0; i < buf.length; turn = 1 - turn, i += k){
        if(turn == 1)  continue
        let j = i + k - 1
        if(j >= buf.length){
            reverse(buf,i,buf.length-1)
            break
        }
        else{
            reverse(buf,i,j)
        }
    }

    var rst = ""
    buf.forEach(function(e){
      rst += e
    })

    return rst

};

var reverse = function(buf, start, end){
    while(start < end){
        let tmp = buf[start]
        buf[start] = buf[end]
        buf[end] = tmp
        start++
        end--
    }
};
