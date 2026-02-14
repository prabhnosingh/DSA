class Solution {




    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] adjList = new ArrayList[numCourses];

        //intializing adjList with empty arraylist
        for(int i = 0; i < numCourses; i ++){
            adjList[i] = new ArrayList<>();
        }

        //filling adjList
        for(int[] preReq : prerequisites){
            int dependantCourse = preReq[0];
            int parentCourse = preReq[1];

            adjList[parentCourse].add(dependantCourse);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i ++){
            dfs(i, adjList, stack, visited);
        }

        int[] topoSort = new int[numCourses];
        int[] position = new int[numCourses];

        int k = 0;
        while(!stack.isEmpty()){
            int currCourse = stack.pop();
            topoSort[k] = currCourse;
            position[currCourse] = k;

            k += 1;
        }

        for(int parentCourse = 0; parentCourse < numCourses; parentCourse ++){
            for(int dependentCourse : adjList[parentCourse]){
                if(position[parentCourse] >= position[dependentCourse]) return new int[]{}; //parent courses should be
                //done before dependentCourses and hence should appear after dependentCourses in topological sort,
                //else return false
            }
        }

    
        return topoSort;

    }

    private void dfs(int currCourse, List<Integer>[] adjList, Stack<Integer> stack, boolean[] visited){
        if(visited[currCourse]) return;

        visited[currCourse] = true;

        for(int dependentCourse : adjList[currCourse]){
            dfs(dependentCourse, adjList, stack, visited);
        }

        stack.push(currCourse); //pushing currCourse after traversing all its children
    }





















//////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: The logic of checking whether all courses are possible to be completed remains the same as in "Course Schedule I"
    
    // //for order of courses, it should be: the course with maximum dependencies (inward nodes) -> the course with less than max
    // //dependencies -> and so on....
    
    // //order of courses will depend on what gets concluded as valid first. We can note it when a depCourse is returned as true inside a recursive
    // //call or when a course is considered a valid one.

    // //TC -> O(V + E) -> Building the adjacency list → O(V + E) and DFS across all nodes/edges → O(V + E)
    // //SC -> O(V + E) (adjacency list + recursion + arrays)

    // int[] visited;
    // HashMap<Integer, List<Integer>> map = new HashMap<>();
    // int[] ans;
    // int currIdx = 0;

    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     visited = new int[numCourses];
    //     map = new HashMap<>();
    //     ans = new int[numCourses];

    //     for(int i = 0; i < numCourses; i ++){
    //         map.put(i, new ArrayList<>());
    //     }

    //     for(int[] pre : prerequisites){
    //         map.get(pre[0]).add(pre[1]);
    //     }

    //     for(int course = 0; course < numCourses; course ++){
    //         if(!dfs(course)){
    //             return new int[0];
    //         }
    //     }

    //     return ans;

    // }
    // public boolean dfs(int course){
    //     if(visited[course] == 2){
    //         return true;
    //     }
    //     if(visited[course] == 1){
    //         return false;
    //     }

    //     visited[course] = 1;
    //     for(int depCourse : map.get(course)){
    //         if(!dfs(depCourse)){
    //             return false;
    //         }
    //         else if(visited[depCourse] != 2){ //add to depCourse only if the depCourse is already not marked 2
    //             visited[depCourse] = 2;
    //             ans[currIdx ++] = depCourse;
    //         }
    //     }

    //     visited[course] = 0;
    //     ans[currIdx ++] = course; //marking a course valid just in case it does not have any children
    //     visited[course] = 2;
    //     return true;
    // }
}