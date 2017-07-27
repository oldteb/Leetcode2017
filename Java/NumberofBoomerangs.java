public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if(points == null || points.length == 0 || points[0].length == 0)
            return 0;
        
        int count = 0;
        
        for(int i = 0; i < points.length; i++){
            Map<Double, Integer> map = new HashMap<Double, Integer>();
            for(int j = 0; j < points.length; j++){
                if(j == i)  continue;
                double dis = getDistance(points, i, j);
                if(map.containsKey(dis)){
                    count += map.get(dis) * 2;
                    map.put(dis, map.get(dis)+1);
                }
                else{
                    map.put(dis, 1);
                }
            }
        }
        
        return count;
    }
    
    double getDistance(int[][] points, int i, int j){
        int x = Math.abs(points[i][0] - points[j][0]);
        int y = Math.abs(points[i][1] - points[j][1]);
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2));    
    }
}