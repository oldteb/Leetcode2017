// take away:
// for implementation problem like this:
// try to think in a generic Solution
// the implementation takes time, but our thoughts must be clear.
public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0)  return 0;

        // eliminate space
        s = s.replaceAll("\\s+","");

        int nextIdx = 0;
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> opStack = new Stack<Character>();

        while(nextIdx < s.length()){
            int i = nextIdx+1;
            for(; i < s.length(); i++){
                if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                    break;
                }
            }
            String sub = s.substring(nextIdx, i);
            int number = Integer.parseInt(sub);
            char op = (i == s.length()) ? '+' : s.charAt(i);
            nextIdx = i+1;

            numStack.push(number);
            opStack.push(op);
            squeezeStack(numStack, opStack);
        }

        return numStack.peek();

    }

    public void squeezeStack(Stack<Integer> numStack, Stack<Character> opStack){
        if(numStack.size() < 2)  return;

        char op1 = opStack.pop();
        char op0 = opStack.peek();
        int num1 = numStack.pop();
        int num0 = numStack.peek();


        int p1 = getOPPriority(op0);
        int p2 = getOPPriority(op1);
        if(p1 >= p2){
            numStack.pop();
            opStack.pop();
            numStack.push(calculate(num0, num1, op0));
            opStack.push(op1);
            squeezeStack(numStack, opStack);
        }
        else{
            numStack.push(num1);
            opStack.push(op1);
        }

        return;
    }

    public int getOPPriority(char op){
        if(op == '+' || op == '-')  return 0;
        else return 1;
    }

    public int calculate(int num1, int num2, char op){
        switch(op){
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
        }
        return -1;
    }
}
