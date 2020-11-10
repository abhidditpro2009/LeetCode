class Solution {
    public int minKnightMoves(int x, int y) {
        
        x = Math.abs(x);
        y = Math.abs(y);
        return bfs(x,y);
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
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
​
            while(size-- > 0){
            
                int[] node = queue.poll();
                int x = node[0];
                int y = node[1];
                
                if(x == dx && y ==dy)
                    return count;
                
                for(int k = 0; k < dirX.length;k++){
​
                    int nx = x + dirX[k];
