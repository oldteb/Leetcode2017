/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    var stack = []
    
    for(let i = 0; i < s.length; i++){
        let c = s.charAt(i)
        if(c == '(' || c == '[' || c == '{'){
            stack.push(c)
        }
        else{
            let leftParathese = stack.pop()
            if(leftParathese != getCounterParenthese(c))
                return false
        }
    }
    
    if(stack.length != 0)
        return false
        
    return true
    
};

var getCounterParenthese = function(s){
    if(s == ')')  return '('
    else if(s == ']')  return '['
    else if(s == '}')  return '{'
    else return null
}; 
