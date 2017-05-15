public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0)
            return 0;

        List<Integer> stack = new ArrayList<Integer>();
        StringBuffer fileSysStrBuf = new StringBuffer(input);

        int maxLen = 0;
        if(fileSysStrBuf.charAt(0) != '\n')
            fileSysStrBuf.insert(0, "\n");


        while(fileSysStrBuf.length() != 0){
            int lvl = popLvl(fileSysStrBuf);
            System.out.println("lvl:" + lvl);
            if(lvl == -1)
                return 0;

            String objStr = popObj(fileSysStrBuf);
            // System.out.println("obj:" + objStr);
            if(objStr == null || objStr.length() == 0)
                return 0;

            int newLen = (lvl == 0 ? 0 : stack.get(lvl-1)) + objStr.length();
            if(lvl >= stack.size())
                stack.add(newLen);
            else
                stack.set(lvl, newLen);

            if(isFile(objStr)){
                maxLen = Math.max(maxLen, stack.get(lvl) + lvl);
                // System.out.println("maxLen:" + maxLen);
            }
        }

        return maxLen;

    }

    public int popLvl(StringBuffer fileSysStrBuf){
        int lvl = -1;
        String prefix = null;
        char nextChar = 0;

        while(fileSysStrBuf.length() != 0){
            nextChar = fileSysStrBuf.charAt(0);
            if(lvl == -1 && nextChar == '\n'
                || lvl >= 0 && nextChar == '\t'){
                fileSysStrBuf.delete(0,1);
                lvl++;
            }
            else
                break;
        }

        return lvl;
    }

    public String popObj(StringBuffer fileSysStrBuf){
        if(fileSysStrBuf == null || fileSysStrBuf.length() == 0)
            return null;
        String target = null;
        int idx = fileSysStrBuf.indexOf("\n");
        // System.out.println(idx);
        if(idx == -1){
            target = fileSysStrBuf.toString();
            fileSysStrBuf.delete(0,fileSysStrBuf.length());
        }
        else{
            target = fileSysStrBuf.substring(0,idx);
            fileSysStrBuf.delete(0,idx);
        }

        return target;
    }

    public boolean isFile(String objStr){
        if(objStr == null || objStr.length() == 0)
            return false;

        return objStr.contains(".");
    }

}
