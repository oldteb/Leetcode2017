/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
 // takeaway
 // How to loop through:
 //   a Iterator: for(var value in Iterator)
 //   a Iterable: for(var value of Iterable)

var isAnagram = function(s, t) {
    if(s == null)
        if(t == null)
            return true
        else
            return false
    if(t == null)
        return false

    var map = new Map()

    for(let i = 0; i < s.length; i++){
        let cnt = map.has(s.charAt(i)) ? map.get(s.charAt(i)) : 0
        map.set(s.charAt(i), cnt+1)
    }

    for(let i = 0; i < t.length; i++){
        if(!map.has(t.charAt(i)))  return false
        if(map.get(t.charAt(i)) == 0)  return false
        map.set(t.charAt(i), map.get(t.charAt(i))-1)
    }

    var mapIter = map.values();
    for(let value of mapIter){
        if(value != 0)  return false
    }

    return true
};
