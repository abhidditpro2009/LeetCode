class Solution {
    
    enum ALGO {
        BFS,
        DFS,
        DIJIKSTRA,
        A_STAR
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        
        int[][] dist = new int[maze.length][maze[0].length];
        int len = 0;
        
        for (int i = 0; i < maze.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        dist[start[0]][start[1]] = 1;
        
        ALGO algo = ALGO.BFS; 
        
        switch(algo){
            
            case DFS:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            
            case BFS:
                bfs(maze,start[0], start[1], destination[0], destination[1],dist);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            
            case A_STAR:
                dijikstra(maze,start[0], start[1], destination[0], destination[1],dist,true);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            
            case DIJIKSTRA:
                dijikstra(maze,start[0], start[1], destination[0], destination[1],dist,false);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
        
            default:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
