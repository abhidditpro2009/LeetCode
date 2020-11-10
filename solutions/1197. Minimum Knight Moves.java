class Solution {
    
    enum ALGO{
        BFS,
        A_STAR,
        DIJIKSTRA,
    }
    
    public int minKnightMoves(int x, int y) {
        
        ALGO algo = ALGO.A_STAR;
        
        x = Math.abs(x);
        y = Math.abs(y);
        
        switch(algo){
                
            case BFS:
                return bfs(x,y);
            case A_STAR:
                return A_Star(x,y);
            case DIJIKSTRA:
                return dijikstra(x,y);
            default:
                return bfs(x,y);
        }
        
        
    }
    
    // We cannot use DFS in an infinite maze. It will get stuck in infinite loop.
    
    int bfs( int dx, int dy){
        
        
        Set<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
        
        queue.add(new int[]{0,0});
        set.add("0_0");
        
        int[] dirX = {1,1,-1,-1,2,2,-2,-2};
        int[] dirY = {2,-2,2,-2,1,-1,1,-1};
        int count =0;
