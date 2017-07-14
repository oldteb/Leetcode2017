public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> rst0 = new ArrayList<String>();
        if(num == 0){
            rst0.add("0:00");
            return rst0;
        }
        
        int[] hrBuf = {1,2,4,8};
        int[] minBuf = {1,2,4,8,16,32};
        
        for(int i = 0; i <= num; i++){
            int minLights = num - i;
            List<String> rst1 = new ArrayList<String>();
            List<String> rst2= new ArrayList<String>();
            dfs(hrBuf, 0, i, 12, 0, rst1);
            dfs(minBuf, 0, minLights, 60, 0, rst2);
            for(String hr : rst1){
                for(String min : rst2){
                    String tmp = min.length() == 1 ? "0"+min : min;
                    rst0.add(hr + ":" + tmp);
                }
            }
        }
        
        return rst0;
    }
    
    void dfs(int[] buf, int lvl, int lights, int cap, int sum, List<String> rst){
        if(sum >= cap)
            return;
        if(lights == 0){
            String minStr = String.valueOf(sum);
            rst.add(minStr);
            return;
        }
        
        for(int i = lvl; i+lights-1 < buf.length; i++){
            dfs(buf, i+1, lights-1, cap, sum+buf[i], rst);
        }
        
        return;
    }
}