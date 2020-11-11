​
                    dist[nsx][nsy] = len + dist[sx][sy];
                    queue.add(new int[]{nsx,nsy});
                }
                
            }
​
        }
​
    }
    
    void dfs(int[][] maze, int sx, int sy, int dx, int dy, int[][] dist, int len){
        
        if(!isInBounds(sx,sy,maze) || maze[sx][sy] == -1) 
            return;
        
        if(sx == dx && sy == dy)
            return;
        
        for(int k=0;k< dirX.length;k++ ){
            
            int nsx = sx + dirX[k];
            int nsy = sy + dirY[k]; 
            
            // once you start in a direction....continue till you hit a wall
            
            len = dist[sx][sy] ;
            while(isInBounds(nsx,nsy,maze) && maze[nsx][nsy] != 1){
                nsx += dirX[k]; 
                nsy += dirY[k];
                len++;
            }
            
            // we need to come one step back once we hit a wall
            nsx -= dirX[k];
            nsy -= dirY[k];
            
            if(dist[nsx][nsy] == 0 || len < dist[nsx][nsy]){
                dist[nsx][nsy] = len;
                dfs(maze,nsx,nsy,dx,dy,dist,len);
            }
            
        }
        
    }
    
    boolean isInBounds(int sx, int sy,int[][] maze){
        
        if( sx < 0 || sy <0 || sx >= maze.length || sy >= maze[0].length)
            return false;
        else
            return true;
        
    }
    
    int heuristic(int x, int y, int x1, int y1 ){
        
        return (int) Math.sqrt( (x-x1) * (x-x1) + (y-y1)* (y-y1) );
    }
}
