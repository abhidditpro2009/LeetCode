class Solution {
    
    enum ALGO {
        BFS,
        DFS
    }
    
    int[] dirX = new int[]{1,-1,0,0};
    int[] dirY = new int[]{0,0,1,-1};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
     
        ALGO algo = ALGO.BFS; 
        
        switch(algo){
            case BFS:
                return bfs(maze,start[0],start[1],destination[0],destination[1]);
            case DFS:
                return dfs(maze,start[0],start[1],destination[0],destination[1]);
            default:
                return bfs(maze,start[0],start[1],destination[0],destination[1]);
        }
  
    }
    
    boolean bfs(int[][] maze,int sx,int sy, int dx, int dy ){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sx,sy});
        maze[sx][sy] = -1;
        
        while(!queue.isEmpty()){
            
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            
            for(int k=0;k< dirX.length;k++){
                int nx = x + dirX[k];
                int ny = y + dirY[k];
                
                while(isInBounds(nx,ny,maze) && maze[nx][ny] != 1 ){
                    nx+= dirX[k];
                    ny+= dirY[k];
                }
                
                nx = nx - dirX[k];
                ny = ny - dirY[k];
                
                if(nx == dx && ny ==dy)
                    return true;
                
                if(maze[nx][ny] == -1)
                    continue;
