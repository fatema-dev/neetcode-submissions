class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preqMap = new HashMap<>();
        for(int[] preq : prerequisites){
            preqMap.putIfAbsent(preq[0], new LinkedList<>());
            preqMap.get(preq[0]).add(preq[1]);
        }
        Set<Integer> visitedSet = new HashSet<>();

        for (int i=0; i<numCourses; i++){
            if (!dfs(i, visitedSet, preqMap, prerequisites)) {
                return false;
            }
        }
        
        return true;
    }

    private boolean dfs(int crs, Set<Integer> visitSet , Map<Integer, List<Integer>> preqMap ,int[][] preq) {
        if(visitSet.contains(crs)){ //we visited a crs twice (loop detected)
            return false;
        }
        if(preqMap.get(crs) == null || preqMap.get(crs).isEmpty() ){
            return true;
        }

        visitSet.add(crs);
        for(int preqs : preqMap.get(crs)){
            if(!(dfs(preqs,visitSet, preqMap, preq))){
                return false;
            }
        }
        visitSet.remove(crs);
        preqMap.get(crs).clear(); //clear the list
        return true;
    }
}