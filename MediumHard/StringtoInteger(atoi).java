// refer to note: [Problem] 8. String to Integer (atoi)
public class Solution {
    public int myAtoi(String str){
    	// validate string
    	if(str == null || str.length() == 0)
    		return 0;   // empty string
    	int sign = 1;
    	int val = 0;
    	
    	// to lower case
    	str = str.toLowerCase();
    	
    	// to string buffer
    	StringBuffer strBuf = new StringBuffer(str);
    	
    	// eliminate space
    	popHeadingSpace(strBuf);
    	if(strBuf.length() == 0)  return 0;
    	
    	// pop sign
    	sign = popSign(strBuf);
    	if(sign == 0)  return 0;
    	if(strBuf.length() == 0)  return 0;
    	
    	// parse int
    	val = parseInt(strBuf, sign);
    	
    	if(val == 0 && sign == -1){
    		return 0;   // invalid expression: -0
    	}
    	
		return val;
    }
	
    void popHeadingSpace(StringBuffer strBuf){
    	int start = 0;
    	for(; start < strBuf.length(); start++){
    		if(strBuf.charAt(start) != ' ')  break;
    	}
    	
    	strBuf.delete(0, start);
    }
    
    int popSign(StringBuffer strBuf){
    	// get sign
    	int sign = 0;
    	char sn = strBuf.charAt(0);
    	if(sn == '-'){
    		sign = -1;
    		strBuf.deleteCharAt(0);
    	}
    	else if(sn == '+'){
    		sign = 1;
    		strBuf.deleteCharAt(0);
    	}
    	else if(sn >= '0' && sn <= '9'){
    		sign = 1;
    	}
    	
    	return sign;
    }
    
    
    int getType(StringBuffer strBuf){
    	if(strBuf.indexOf(".") != -1){
    		if(strBuf.indexOf("x") == -1){
    			return 1;   // float
    		}
    		else{
    			return 2;   // scientific notation
    		}
    	}
    	else{
    		return 0;  // integer type
    	}
    }
    
    int parseInt(StringBuffer strBuf, int sign){
    	// remove heading zeros
    	int start = 0;
    	String numStr = "";
    	for(;start < strBuf.length(); start++){
    		if(strBuf.charAt(start) != '0')  break;
    	}
    	if(start == strBuf.length())  return 0;
    	else{
    		numStr = strBuf.substring(start,strBuf.length());
    	}
    	
    	int val = 0;
    	for(int i = 0; i < numStr.length(); i++){
    		char digit = numStr.charAt(i);
    		if(digit < '0' || digit > '9')  return val;  // invalid expression
    		int dgt = digit - '0';
    		int newVal1 = val * 10;
    		if((newVal1)/10 != val){
    			return (sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
    		}
    		int newVal2 = newVal1 + dgt * sign;
    		if(sign == -1 && newVal2 > newVal1){
    			return Integer.MIN_VALUE;
    		}
    		else if(sign == 1 && newVal2 < newVal1){
    			return Integer.MAX_VALUE;
    		}
    		
    		val = newVal2;
    	}
    	
    	return val;
    }
}