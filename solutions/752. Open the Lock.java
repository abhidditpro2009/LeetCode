class Solution {
    
    int fcount = -1;
    int bcount = -1;
    int count = -1;
    int[] dirX = new int[]{-1,1};  
    
    String source = "0000";
    
    enum ALGO{
        BFS,
        BI_DIR_BFS
    }
    
    public int openLock(String[] deadends, String target) {
    
        
        ALGO algo = ALGO.BI_DIR_BFS;
        
        switch(algo){
                
            case BFS:
                return simpleBfs(deadends, target);
            case BI_DIR_BFS:
                return biDirBfs(deadends, target);
            default:
                return simpleBfs(deadends, target);
        }
        
    }
    
    int simpleBfs(String[] deadends, String target){
        
        
        String source = "0000";        
        Queue<String> queue = new LinkedList<>();
        Set<String> block = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        
        if(block.contains(target) || block.contains(source) )
            return -1;
        
        queue.add(source);
        visited.add(source);
        
        while(!queue.isEmpty()){
            
            int size = queue.size();
            count++;
            
            
            int res = bfsUtil(queue,visited,null,block,target);
            
            if(res != -1)
