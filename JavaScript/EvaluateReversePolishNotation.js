/**
 * @param {string[]} tokens
 * @return {number}
 */
 // take away:
 // when doing division in JS,
 // a) use Math.floor for positive grounding
 // b) use Math.ceil for negative grounding
var evalRPN = function(tokens) {
    if(tokens == null || tokens.length == 0)
        return null

    var numStack = []

    for(let i = 0; i < tokens.length; i++){
        var obj = tokens[i]
        if(isOperand(obj)){
            let num1 = numStack.pop()
            let num2 = numStack.pop()
            let rst = calculate(num2, num1, obj)
            numStack.push(rst)
        }
        else{
            numStack.push(parseInt(obj))
        }
        console.log(numStack[numStack.length-1])
    }

    return numStack.pop()
};

var isOperand = function(obj){
    switch(obj){
        case '+':
        case '-':
        case '*':
        case '/':
            return true
    }

    return false
}

var calculate = function(num1, num2, op){
      switch(op){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                let rst = num1/num2
                if(rst < 0)
                    rst = Math.ceil(rst)
                else
                    rst = Math.floor(rst)
                return rst
        }
        return -1;
}
