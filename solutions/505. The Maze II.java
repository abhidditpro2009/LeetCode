class Solution {
    
    enum ALGO {
        BFS,
        DFS,
        DIJIKSTRA
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
            case BFS:
                bfs(maze,start[0], start[1], destination[0], destination[1],dist);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            case DIJIKSTRA:
                dijikstra(maze,start[0], start[1], destination[0], destination[1],dist);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            case DFS:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
            default:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]]-1;
        }
        
        
    }
    
    int[] dirX = new int[]{1,-1,0,0};
    int[] dirY = new int[]{0,0,1,-1};
    
    void dijikstra(int[][] maze, int x, int y, int dx, int dy, int[][] dist){
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        queue.add(new int[]{x,y,1});
        
        maze[x][y] = -1;
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            
