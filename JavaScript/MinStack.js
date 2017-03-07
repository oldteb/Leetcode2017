/**
 * initialize your data structure here.
 */
var MinStack = function() {
    this.valStack = []
    this.minStack = []
};

/**
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.valStack.push(x)
    let oldMin = this.minStack.length == 0 ? Number.MAX_SAFE_INTEGER : this.minStack[this.minStack.length-1]
    this.minStack.push(Math.min(oldMin,x))
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    this.valStack.pop()
    this.minStack.pop()
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.valStack[this.valStack.length-1]
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minStack[this.minStack.length-1]
};

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */
