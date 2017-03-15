/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * function NestedInteger() {
 *
 *     Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     @return {boolean}
 *     this.isInteger = function() {
 *         ...
 *     };
 *
 *     Return the single integer that this NestedInteger holds, if it holds a single integer
 *     Return null if this NestedInteger holds a nested list
 *     @return {integer}
 *     this.getInteger = function() {
 *         ...
 *     };
 *
 *     Return the nested list that this NestedInteger holds, if it holds a nested list
 *     Return null if this NestedInteger holds a single integer
 *     @return {NestedInteger[]}
 *     this.getList = function() {
 *         ...
 *     };
 * };
 */
/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */
var NestedIterator = function(nestedList) {
    this.objStack = []
    this.idxStack = []

    if(nestedList != null && nestedList.length > 0){
        this.objStack.push(nestedList)
        this.idxStack.push(0)
        // console.log(this.objStack.length)
        extract(nestedList, 0, this.objStack, this.idxStack)
    }

    // console.log(this.objStack.length)
};


/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
    if(this.objStack.length > 0)  return true
    else return false
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
    var arr = this.objStack[this.objStack.length-1]
    var idx = this.idxStack[this.idxStack.length-1]
    var nextVal = arr[idx]
    idx++
    // console.log('output: ' + nextVal)

    this.idxStack[this.idxStack.length-1] = idx

    extract(arr, idx, this.objStack, this.idxStack)

    return nextVal
};

var extract = function(arr, idx, objStack, idxStack){
    while(arr == [] || idx >= arr.length || typeof(arr[idx]) == 'object'){
        // console.log('[' + arr + ']')
        if(arr == [] || idx >= arr.length){
            // console.log('(1)')
            objStack.pop()
            idxStack.pop()
            if(objStack.length == 0)
                break
            arr = objStack[objStack.length-1]
            idx = idxStack[idxStack.length-1]
            idx++
            idxStack[idxStack.length-1] = idx
            // console.log('(1F)')
        }
        else{
            // console.log('(2)')
            objStack.push(arr[idx])
            idxStack.push(0)
            arr = objStack[objStack.length-1]
            idx = idxStack[idxStack.length-1]
            // console.log('(2F)')
        }
    }
}

/**
 * Your NestedIterator will be called like this:
 * var i = new NestedIterator(nestedList), a = [];
 * while (i.hasNext()) a.push(i.next());
*/
var nestedList = [[1,1],2,[1,1]]
var i = new NestedIterator(nestedList), a = [];
while (i.hasNext()) // console.log(i.next());
