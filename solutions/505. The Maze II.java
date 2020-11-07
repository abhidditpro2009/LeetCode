    void dijikstra(int[][] maze, int x, int y, int dx, int dy, int[][] dist, boolean isAStar){
        
        PriorityQueue<int[]> queue ;
        
        if(isAStar)
            queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        else
            queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        
        queue.add(new int[]{x,y,1});
        
        
        while(!queue.isEmpty()){
            
            int[] node = queue.poll();
            int sx = node[0];
            int sy = node[1];
            int diff = node[2];
​
            if(sx == dx && sy == dy){
                System.out.println(dist[sx][sy]);
                return;
            }
​
            for(int k=0;k<dirX.length;k++){
​
                int nsx = sx + dirX[k];
                int nsy = sy + dirY[k];
                int len = 1;
                
​
                while(isInBounds(nsx,nsy,maze) && maze[nsx][nsy] != 1){
                    nsx += dirX[k]; 
                    nsy += dirY[k];
                    len++;
                }
​
                nsx -= dirX[k];
                nsy -= dirY[k];
                len--;
​
                if( len + diff < dist[nsx][nsy]){
​
                    dist[nsx][nsy] = len+ diff;
                    queue.add(new int[]{nsx,nsy,dist[nsx][nsy]});
                }
​
            }
        
        }
​
    }
    
    void bfs(int[][] maze, int x, int y, int dx, int dy, int[][] dist){
        
        Queue<int[]> queue = new LinkedList<>();
    
        queue.add(new int[]{x,y});
        
        while(!queue.isEmpty()){
