/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
 // take away:
 // Key word: shortest: DP
 // Route Searching: DFS/BFS
 // The solution is to find the shortest path in a bi-directional graph: BFS
 // How to minimize the time to extract one node in queue(find all next words):
 // 1) compare current word with each word in dict: O(n)
 // 2) assemble all possible next words and check if dict has it: O(1)


var ladderLength = function(beginWord, endWord, wordList) {
    if(wordList == null || wordList.length == 0)
        return 0

    // prepare
    var dict = new Map()
    for(let i = 0; i < wordList.length; i++){
        dict.set(wordList[i], i)
    }


    // solution 1:DFS: O(n^3)/O(n) ?
    // var mark = []
    // for(let i = 0; i < wordList.length; i++)
    //     mark[i] = 0
    // let rst = dfs(beginWord, endWord, wordList, mark)
    // if(rst == 0)
    //     return 0
    // else
    //     return rst+1


    // solution 2: BFS: O(n^2)/O(n)
    var mark = []
    var queue = []
    for(let i = 0; i < wordList.length; i++)
        mark[i] = 0
    for(let i = 0; i < wordList.length; i++){
        if(wordDiff(beginWord, wordList[i]) == 1){
            queue.push(i)
            mark[i] = 1
        }
    }
    let endIdx = -1
    for(let i = 0; i < wordList.length; i++){
        if(wordList[i] == endWord){
            endIdx = i
            break
        }
    }

    if(endIdx == -1)  return 0

    let depth = 0
    while(queue.length != 0){
        depth++
        let size = queue.length
        for(let i = 0; i < size; i++){
            let wordIdx = queue.shift()
            if(wordIdx == endIdx)  return depth+1
            var list = getNextWordIdx(wordIdx, wordList, dict)
            for(let j = 0; j < list.length; j++){
                if(mark[list[j]] == 1)  continue
                queue.push(list[j])
                mark[list[j]] = 1
            }
        }
    }

    return 0

};


var dfs = function(beginWord, endWord, wordList, mark){
    let minDistance = Number.MAX_SAFE_INTEGER

    // find all next words in O(n) time
    for(let i = 0; i < wordList.length; i++){
        if(mark[i] == 1)  continue
        if(wordDiff(wordList[i], beginWord) == 1){
            if(wordList[i] == endWord){
                return 1
            }
            mark[i] = 1
            let cnt = dfs(wordList[i], endWord, wordList, mark)
            mark[i] = 0
            if(cnt == 0)  continue
            minDistance = Math.min(minDistance, cnt+1)
        }
    }

    if(minDistance == Number.MAX_SAFE_INTEGER)
        minDistance = 0

    return minDistance
};

// find all next words in constant time
var getNextWordIdx = function(strIdx, wordList, dict){
    var list = []
    var word = wordList[strIdx]
    for(let i = 0; i < word.length; i++){
        for(let j = 97; j <= 122; j++){
            let c = String.fromCharCode(j)
            if(word.charAt(i) == c)  continue
            let tmp = word.slice(0,i) + c + word.slice(i+1)
            if(dict.has(tmp)){
                list.push(dict.get(tmp))
            }
        }
    }

    return list
};

// determin if a word is next word in constant time
var wordDiff = function(str1, str2){
  let i = 0
  let j = 0

  let diffCnt = 0

  while(i < str1.length){
      if(str1.charAt(i) != str2.charAt(i)){
          diffCnt++
      }
      i++
  }

  return diffCnt
};
