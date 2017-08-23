public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)  return false;
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            else{
                if(i == 0)  return false;
                else if(stack.size() == 0)  return false;
                else if(stack.peek() != map.get(s.charAt(i)))  return false;
                else  stack.pop();
            }
        }

        if(stack.size() == 0)  return true;
        else return false;

    }
}
