/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        if(buf == null || n <= 0)
            return 0;
        
        char[] buf4 = new char[4];
        int len = 0;
        int cnt = 0;
        
        while((len = read4(buf4)) > 0 && cnt < n){
            for(int i = 0; i < len && cnt < n; i++){
                buf[cnt++] = buf4[i];
            }
        }
              
        return cnt;
    }
}