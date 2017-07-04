public class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
            
        int perimeter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    perimeter += countEdges(grid, i, j);
            }
        }
        
        return perimeter;
    }
    
    int countEdges(int[][] grid, int x, int y){
        int edges = 0;
        edges += (x-1 < 0 ? 1 : 1-grid[x-1][y]);
        edges += (x+1 >= grid.length ? 1 : 1-grid[x+1][y]);
        edges += (y-1 < 0 ? 1 : 1-grid[x][y-1]);
        edges += (y+1 >= grid[0].length ? 1 : 1-grid[x][y+1]);
        
        return edges;
    }
}
