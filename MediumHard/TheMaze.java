/*
-- Take Away --
Graph path searching: DFS / BFS / BFS(non-level based)

*/

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        LinkedList<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        int[][] visited = new int[maze.length][maze[0].length];
        
        while(queue.size() != 0){
            int[] cur = queue.poll();
            if(cur[0] == destination[0] && cur[1] == destination[1])  return true;
            if(visited[cur[0]][cur[1]] == 1)
                continue;
            int[] next;
            next = rollUp(maze,cur);
            if(next != null)  queue.offer(next);
            next = rollDown(maze,cur);
            if(next != null)  queue.offer(next);
            next = rollLeft(maze,cur);
            if(next != null)  queue.offer(next);
            next = rollRight(maze,cur);
            if(next != null)  queue.offer(next);
            visited[cur[0]][cur[1]] = 1;
        }
        
        return false;
        
    }
    
    int[] rollUp(int[][] maze, int[] cur){
        int last = 0;
        for(int i = cur[0]-1; i >= 0; i--){
            if(maze[i][cur[1]] == 1){
                last = i+1;
                break;
            }
        }
        if(last == cur[0])  return null;
        else  return new int[]{last,cur[1]};
    }
    
    int[] rollDown(int[][] maze, int[] cur){
        int last = maze.length-1;
        for(int i = cur[0]+1; i < maze.length; i++){
            if(maze[i][cur[1]] == 1){
                last = i-1;
                break;
            }
        }
        if(last == cur[0])  return null;
        else  return new int[]{last,cur[1]};
    }
    
    int[] rollLeft(int[][] maze, int[] cur){
        int last = 0;
        for(int i = cur[1]-1; i >= 0; i--){
            if(maze[cur[0]][i] == 1){
                last = i+1;
                break;
            }
        }
        if(last == cur[1])  return null;
        else  return new int[]{cur[0],last};
    }
    
    int[] rollRight(int[][] maze, int[] cur){
        int last = maze[0].length-1;
        for(int i = cur[1]+1; i < maze[0].length; i++){
            if(maze[cur[0]][i] == 1){
                last = i-1;
                break;
            }
        }
        if(last == cur[1])  return null;
        else  return new int[]{cur[0],last};
    }
    
    
}