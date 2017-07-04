public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length()==0){
            return new ArrayList<Integer>();
        }
        
        // parse string
        List<Integer> vals = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();
        
        for(int i = 0; i < input.length();){
            int j = i+1;
            while(j < input.length() && input.charAt(j) >= '0' && input.charAt(j) <= '9')
                j++;
            
            int val = Integer.parseInt(input.substring(i,j));
            vals.add(val);
            
            if(j != input.length())
                ops.add(input.charAt(j));
        
            i = j + 1;
        }
        
        // search solution
        List<Integer> rst = new ArrayList<Integer>();
        Stack<Integer> valStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();
        
        //valStack.push(vals.get(0));
        //opStack.push(ops.get(0));
        
        if(vals.size() == 1)
            return vals;
        
        dfs(vals, ops, rst, valStack, opStack, 0);
        
        return rst;
    
    }
    
    void dfs(List<Integer> vals, List<Character> ops, List<Integer> rst, 
            Stack<Integer> valStack, Stack<Character> opStack, int level){
        
        if(valStack.size() == 1 && level == vals.size()){
            rst.add(valStack.peek());
            return;
        }
        
        if(level < vals.size()){
            valStack.push(vals.get(level));
            if(level < ops.size())
                opStack.push(ops.get(level));
            dfs(vals, ops, rst, valStack, opStack, level+1);
            valStack.pop();
            if(level < ops.size())
                opStack.pop();
        }
        
        if(valStack.size() >= 2){
            int v1 = valStack.pop();
            char op = opStack.pop();
            int v2 = valStack.pop();
            if(level < vals.size()){
                char op2 = opStack.pop();
                int ans = calculate(v2, v1, op2);
                valStack.push(ans);
                opStack.push(op);
                dfs(vals, ops, rst, valStack, opStack, level);
                valStack.pop();
                opStack.pop();
                valStack.push(v2);
                opStack.push(op2);
                valStack.push(v1);
                opStack.push(op);
            }
            else{
                int ans = calculate(v2, v1, op);
                valStack.push(ans);
                dfs(vals, ops, rst, valStack, opStack, level);
                valStack.pop();
                valStack.push(v2);
                opStack.push(op);
                valStack.push(v1);
            }
        }    
        
        return;
    }
    
    int calculate(int v1, int v2, char op){
        if(op == '+')  return v1+v2;
        else if(op == '-')  return v1-v2;
        else return v1*v2;
    }
    
    
}
