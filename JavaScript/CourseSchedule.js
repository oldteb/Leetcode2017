/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
 // take away:
 // it is essentially a directional graph loop detecting problem
 // use Loop-DFS to traverse the forest
 // use 0,1,2 to mark the status of each node:
 // 0 - new node
 // 1 - ancester node
 // 2 - node already detected, no loop found
 // If during the treversal, a node of 1 is reached, then loop is detected
 // Refer to note "Loop Detection" for more details

var canFinish = function(numCourses, prerequisites) {
    if(numCourses <= 0 || prerequisites == null || prerequisites.length == 0)
        return true

    var courses = []
    for(let i = 0; i < numCourses; i++){
        courses[i] = 0
    }

    var edges = new Map
    for(let i = 0; i < prerequisites.length; i++){
        var edge = prerequisites[i]
        var list = edges.has(edge[0]) ? edges.get(edge[0]) : new Array()
        list.push(edge[1])
        edges.set(edge[0], list)
    }

    for(let i = 0; i < courses.length; i++){
        if(courses[i] == 0){
            if(findLoop(i, courses, edges) == false)  return false
        }
    }

    return true
};

var findLoop = function(idx, courses, edges){
    if(courses[idx] == 2)  return true
    if(courses[idx] == 1)  return false

    if(edges.has(idx)){
        courses[idx] = 1
        var list = edges.get(idx)
        for(let j = 0; j < list.length; j++){
            let dest = list[j]
            if(findLoop(dest, courses, edges) == false)  return false
        }
    }

    courses[idx] = 2
    return true
};
