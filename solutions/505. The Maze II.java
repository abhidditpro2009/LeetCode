        
​
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                dist[i][j] = Integer.MAX_VALUE;
                pathStr[i][j] = "";
            }
        }
        
        dist[start[0]][start[1]] = 1;
        
        
        ALGO algo = ALGO.DFS; 
        
        switch(algo){
            
            case DFS:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                System.out.println("List of directions taken:"+list);
                return dist[destination[0]][destination[1]] == res ? -1 : dist[destination[0]][destination[1]]-1;
            
            case BFS:
                bfs(maze,start[0], start[1], destination[0], destination[1],dist);
                System.out.println("List of directions taken:"+list);
                return dist[destination[0]][destination[1]] == res ? -1 : dist[destination[0]][destination[1]]-1;
            
            case A_STAR:
                res =  dijikstra(maze,start[0], start[1], destination[0], destination[1],dist,true) -1;
                System.out.println("List of directions taken:"+list);
                return res;
                
            case DIJIKSTRA:
                res =  dijikstra(maze,start[0], start[1], destination[0], destination[1],dist,false) - 1;
                System.out.println("List of directions taken:"+list);
                return res;
        
            default:
                dfs(maze,start[0], start[1], destination[0], destination[1],dist,len+1);
                return dist[destination[0]][destination[1]] == res ? -1 : dist[destination[0]][destination[1]]-1;
        }
        
        
    }
    
    // BFS and DFS need to use a distance matrix
    // Dijikstra and A star dont need to use a distance matrix necessarily
    
