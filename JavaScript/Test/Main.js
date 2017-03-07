var longestCommonPrefix = function(strs) {
  if(strs == null || strs.length == 0)
      return ''

  let prefixLen = 0

  while(true){
      if(prefixLen >= strs[0].length)  break
      let char = strs[0].charAt(prefixLen)

      let mismatch = false
      for(let i = 1; i < strs.length; i++){
          if(prefixLen >= strs[i].length || char != strs[i].charAt(prefixLen)){
              mismatch = true
              break
          }
      }

      if(mismatch)  break
      else prefixLen++
  }

  return strs[0].substring(0, prefixLen)

};


var rst = longestCommonPrefix(['abc', 'ab', 'abcd'])
console.log(rst)
