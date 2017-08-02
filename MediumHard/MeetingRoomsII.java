/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/*
-- Take Away --

It is a greedy algorithm:
we calculate the number of conflict rooms that at the end of each interval.
then we return the largest one of them.

we sort the interval on their start and end time seperately
if the conflicts for interval ends at [i] is m
then the conflicts for interval ends at [i+1] 
    = m - 1(the last interval itself) + number of interval starts between ([i] and [i+1])

The genious part is to break the interval to sort them seperately.
because to calculate the number of layer, wheather start time and end time
belongs to same intercal does not matter.

*/
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int maxRooms = 0;
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length;) {
            if(starts[i]<ends[endsItr]){
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                i++;
            }
            else{
                rooms--;
                endsItr++;
            }
        }
        return maxRooms;
    }
}