/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        if(intervals == null || intervals.length <= 1)  
            return true;
        
        for(int i = 0; i < intervals.length-1; i++){
            for(int j = i+1; j < intervals.length; j++){
                if(isOverlapped(intervals[i], intervals[j]))
                    return false;
            }
        }
        
        return true;
    }
    
    boolean isOverlapped(Interval i1, Interval i2){
        if(i1.end <= i2.start || i1.start >= i2.end)  return false;
        else return true;
    }
}