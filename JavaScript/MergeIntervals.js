/**
 * Definition for an interval.
 * function Interval(start, end) {
 *     this.start = start;
 *     this.end = end;
 * }
 */
/**
 * @param {Interval[]} intervals
 * @return {Interval[]}
 */
 // take away
 // 1. read teh question !!!!
 // 2. nerver used copy !!!
 // performance: O(n^2)
 var merge = function(intervals) {
     if(intervals == null || intervals.length == 0)
         return []

     var queue = []
     for(let i = 0; i < intervals.length; i++){
         queue.push(intervals[i])
     }

     var rst = []
     while(queue.length != 0){
         var root = queue.shift()
         let size = queue.length
         let i = 0
         for(; i < size; i++){
             var interval = queue.shift()
             var mergeList = mergeRange(root, interval)
             if(mergeList != null){
                 queue.push(mergeList)
                 break
             }
             else{
                 queue.push(interval)
             }
         }

         if(i >= size){
             rst.push(root)
         }
     }

     return rst

 };

 var mergeRange = function(listA, listB){
     if(listA.start <= listB.end && listA.end >= listB.start){
         return new Interval(Math.min(listA.start,listB.start), Math.max(listA.end,listB.end))
     }
     return null
 };
