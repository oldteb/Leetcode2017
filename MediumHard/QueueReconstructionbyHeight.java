public class Solution {
    public int[][] reconstructQueue(int[][] people) {        
        if(people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        
        Arrays.sort(people, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0]){
                    if(arr1[1] == arr2[1])  return 0;
                    else if(arr1[1] < arr2[1])  return -1;
                    else return 1;
                }
                else if(arr1[0] < arr2[0])  return 1;
                else return -1;
            }
        });
        
        int[][] rst = new int[people.length][people[0].length];
        
        for(int i = 0; i < people.length; i++){
            rst[i] = people[i];
            for(int j = i; j > people[i][1]; j--){
                swap(rst, j, j-1);
            }
        }
        
        return rst;

    }
    
    public void swap(int[][] nums, int i, int j){
        int[] tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}