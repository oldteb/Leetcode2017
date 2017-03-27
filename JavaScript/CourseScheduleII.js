/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
 // take away:
 // same process as CourseScheduleI.js
 // except that course i is added to rst when all its prerequisites are satisfied
 // or return false if loop is detacted
var findOrder = function(numCourses, prerequisites) {
    if(prerequisites == null || numCourses <= 0)
        return []

    var buf = []
    for(let i = 0; i < numCourses; i++){
        buf[i] = 0
    }

    var map = new Map()
    for(let i = 0; i < prerequisites.length; i++){
        var list = map.has(prerequisites[i][0]) ? map.get(prerequisites[i][0]) : new Array()
        list.push(prerequisites[i][1])
        map.set(prerequisites[i][0], list)
    }

    var rst = []
    for(let i = 0; i < numCourses; i++){
        if(buf[i] == 0){
            if(dfs(i, map, buf, rst) == false)  return []
        }
    }

    return rst
};

var dfs = function(i, map, buf, rst){
    if(buf[i] == 2)  return true
    if(buf[i] == 1)  return false

    var list = map.get(i)
    if(list != null){
        buf[i] = 1
        for(let j = 0; j < list.length; j++){
            if(dfs(list[j], map, buf, rst) == false)  return false
        }
    }

    rst.push(i)
    buf[i] = 2
    return true
}
