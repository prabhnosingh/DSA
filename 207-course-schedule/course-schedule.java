class Solution {
    
    //Re-solving on 13 Feb 2026

    //intuition 2: Topic: Graphs
        //Pattern: Topological sort
        //Sub-pattern: BFS + Kahn's algorithm

        //We are having a directed graph in this problem
        //We basically need to find if there is a cycle in this graph. As if there
            //is a cycle then it will not be possible to finish all the courses
        
        //So this problem boils down to whether there is a cycle in the graph or not
        //Therefore, we can apply Topological sort - Kahn's algorithm

        //Calculate in-order degree of all the courses
        //Insert courses with 0 in-degree to the queue
        //Deque the courses and reduce the in-degree of the adjacent courses
        //Enque the adjacent courses if the in-degree becomes 0
        //at last see if processed courses = total courses, if yes, return true, else false
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Queue<Integer> queue = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        int[] inDegree = new int[numCourses];
        int processedCourses = 0;

        //building adjList and finding indgree of all the courses
        //prerequisites are in the format of ai -> bi but as we trying to get
            //topoligical order, we will build adj list as bi -> ai, indicating
            //that bi should be finished before we can finish ai (is this correct understanding)
        for(int[] prereq : prerequisites){
            int c1 = prereq[0];
            int c2 = prereq[1];

            if(!adjList.containsKey(c2)) adjList.put(c2, new ArrayList<>());

            adjList.get(c2).add(c1);

            inDegree[c1] += 1;
        }

        //adding zero in-degree courses to the queue
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0) {
                queue.offer(i);
                processedCourses += 1;
            }
        }

        while(!queue.isEmpty() && processedCourses != numCourses){
            
            int currCourse = queue.poll();
            
            if(!adjList.containsKey(currCourse)) continue;

            for(int childCourse : adjList.get(currCourse)){
                inDegree[childCourse] -= 1;

                if(inDegree[childCourse] == 0) {
                    queue.offer(childCourse);
                    processedCourses += 1;
                }
            }


        }

        if(processedCourses != numCourses) return false;
        return true;

       

    }



























/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Feb 2026

//     //intuition 1: Graphs : DFS (3 coloring) - can we solve it using Topological sort? - yes
//         //Have an adjacency list in which each course's prerequisites are stored against
//             //that course
//         //The basic thing to find is that we find some sort of cycle, then we return false
//         //So maintain a color array that stores 0,1,2 for each index, where each index 
//             //indicates a course
//         //Now if a course is in unvisited, it will be 0
//         //if a course is currently under traversal, it will be 1 (if while traversing any 
//             //course, the same course is reached, then we conclude that there is a cycle 
//             //and the current course cannot be finished, hence return false)
//         //if a course is already visited, it will be 2 (this would mean that this course
//             //is kinda possible to finish, so we can just return the call from here without
//             //traversing again)
//         //If we encounter any node with color = 1, that node is already on the current DFS 
//             //recursion path, which means we found a directed cycle.
//         //2 means the course and all prerequisites reachable from it have already been fully 
//             //explored without finding a cycle.

//         //Color 1 represents nodes on the current DFS path. If DFS encounters another color-1 
//             //node, there is a back edge, which proves a directed cycle exists. Color 2 
//             //represents nodes whose entire dependency graph has already been verified 
//             //to be cycle-free.

//         //TC: O(V + E) : V = number of nodes (numCourses) and E = prerequisites.length
//             //Build adj list = O(E)
//             //DFS all vertices = O(V + E)
//             //Each course is fully processed at most once and each prerequisite edge is
//                 //examined at most once.
//         //SC: O(V + E)
//             //Adj list = O(V + E)
//             //coloring[] = O(V)
//             //recursion stack = O(V) worst case


//         //how much maximum could prerequisites array can be in size? - n(n-1)
//              //if there are n number of courses and each prerequisite pair is unique
//              //with no-self dependency, the maximum possible number of prerequisites
//              //will be n(n-1) - each course can depend on every other course except
//              //itself        
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//         HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
//         //0 - unvisited
//         //1 - currently being visited
//         //2 - successfully visited
//         int[] coloring = new int[numCourses];


//         //building the adjacency list
//         for(int[] prereq : prerequisites){
//             int c1 = prereq[0];
//             int c2 = prereq[1];

//             if(!adjList.containsKey(c1)) adjList.put(c1, new ArrayList<>());
//             adjList.get(c1).add(c2); //to finish c1 we need to finish c2
//         }

//         for(int course = 0; course < numCourses; course ++){
//             if(coloring[course] == 2) continue;
//             coloring[course] = 1; //marking as currently being traversed
//             if(!dfsTraversal(adjList, coloring, course)) return false;
//             coloring[course] = 2; //marking a course successfully traversed
//         }

//         return true;


//     }

//     private boolean dfsTraversal(HashMap<Integer, List<Integer>> adjList, int[] coloring, 
//     int currCourse){

//         if(coloring[currCourse] == 2) return true;

//         if(!adjList.containsKey(currCourse)) {//indicates that currCourse does
//             //not have any pre requisite
//             return true; 
        
//         }

//         for(int prereqCourse : adjList.get(currCourse)){
//             if(coloring[prereqCourse] == 1) return false;
//             else if(coloring[prereqCourse] == 2) continue; //prereqCourse is already
//                 //possible to complete, proceed with next prereqCourse

//             coloring[prereqCourse] = 1;

//             if(!dfsTraversal(adjList, coloring, prereqCourse)) return false;
//             coloring[prereqCourse] = 2; //marking as successfully finished
//         }

//         return true;

//     }


























// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Feb 2026

//     //intuition 2: Graphs : Topological sort
//         //We will find the toplogical sort order of the courses based on prerequisites
//         //Topological order algo
//             //build an adjacency list
//             //have stack and visited array and run dfs
//             //push each node to stack after traversing all its children
//             //have two int arrays, topoOrder and position
//             //pop all the elements from the stack and add to topoOrder and position while keeping
//                 //a track of position with k variable
//         //At last see if the topoOrder is valid, if yes, return true, else, return false
//             //to check topoOrder is valid or not, run nested for loop for each node and its
//                 //children and see if any parent node's position is greater than its child node's
//                 //position, if yes, then the topological sort order is invalid

//         //TC: O(E+V)
//         //SC: O(E+V)

//     public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//         List<Integer>[] adjList = new ArrayList[numCourses];

//         //intializing adjList with empty arraylist
//         for(int i = 0; i < numCourses; i ++){ //O(V)
//             adjList[i] = new ArrayList<>();
//         }

//         //filling adjList
//         for(int[] preReq : prerequisites){ //O(E)
//             int dependantCourse = preReq[0];
//             int parentCourse = preReq[1];

//             adjList[dependantCourse].add(parentCourse);
//         }

//         Stack<Integer> stack = new Stack<>();
//         boolean[] visited = new boolean[numCourses]; 
//         for(int i = 0; i < numCourses; i ++){ //O(E+V)
//             dfs(i, adjList, stack, visited);
//         }

//         int[] topoSort = new int[numCourses];
//         int[] position = new int[numCourses];

//         int k = 0;
//         while(!stack.isEmpty()){ //O(V)
//             int currCourse = stack.pop();
//             topoSort[k] = currCourse;
//             position[currCourse] = k;

//             k += 1;
//         }

//         for(int i = 0; i < numCourses; i ++){ //O(E) => iterating over all adjacency list once in total
//             for(int parentCourse : adjList[i]){
//                 if(position[i] >= position[parentCourse]) return false; //parent courses should be
//                 //done before i courses and hence should appear after i in topological sort, else return false
//             }
//         }

//         return true;

//     }

//     private void dfs(int currCourse, List<Integer>[] adjList, Stack<Integer> stack, boolean[] visited){
//         if(visited[currCourse]) return;

//         visited[currCourse] = true;

//         for(int parentCourse : adjList[currCourse]){
//             dfs(parentCourse, adjList, stack, visited);
//         }

//         stack.push(currCourse); //pushing currCourse after traversing all its children
//     }




























// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Feb 2026

//     //intuition 1: Graphs : DFS 3-color
//         //prerequisites array is like an adjList
//         //in [1,0], 0 is the parent of 1
//         //in [[1,0], [0,1]] there is a cycle 

//         //starting from 0 run a 3-color dfs

//         //TC: O(E+V)
//         //SC: O(E+V) : E+V for adjList, V for visited and V for dfs recursive stack


//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<Integer>[] adjList = new ArrayList[numCourses];

//         //intializing adjList
//         for(int i = 0; i < numCourses; i ++){ //O(V) : no. of vertices 
//             adjList[i] = new ArrayList<>(); 
//         }

//         //filling adjList
//         for(int[] preReq : prerequisites){ //O(E) : no. of edges
//             int childCourse = preReq[0];
//             int parentCourse = preReq[1];
            
//             //childCourse -> parentCourse

//             adjList[childCourse].add(parentCourse);
//         }



//         int[] visited = new int[numCourses]; //(3-color DFS)
//             //0 if the course is not visited
//             //1 if the course is visited
//             //2 if the course is in traversal
//         //looping over all courses as some might not have any dependency and might be not connected
//         for(int course = 0; course < numCourses; course ++){ //O(E+V) : (E+V) for all dfs calls due
//             //to memoization. "each node becomes visiting once and then done once → O(V)" and 
//             //"each edge is explored once in the for (parentCourse : adjList[currCourse]) loops overall → O(E)"
//             // boolean[] visited = new boolean[numCourses];
//             // if(adjList[course].size() != 0){ //traverse only if the course have dependency
//                 if(!dfs(course, adjList, visited)){
//                     return false;
//                 }
//             // }
//         }

//         return true;
    

//     }


//     //return false when a cycle is detected
//     private boolean dfs(int currCourse, List<Integer>[] adjList, int[] visited){

//         if(visited[currCourse] == 2) return false; //cycle detected; the course is already in traversal
//             //and is being encountered again before finishing its recursive call 
//         if(visited[currCourse] == 1) return true; //course already completed

//         visited[currCourse] = 2; //marking a course as visiting
//         for(int parentCourse : adjList[currCourse]){
//             if(!dfs(parentCourse, adjList, visited)) return false;
//         }

//         visited[currCourse] = 1;
//         return true;
//     }

































// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //inuition 1: draw the graph (prequisites) on paper and consider different examples and draw different paths
    //in this false is when we have a cicular graph
    //if all the node's combined sum of neighborCount is 0, then it is not possible to finish
    //intuition 2: use dfs. if a node encountered does not have any outward edges (meaning it does not have any prequisites), then it is 
    //possible to complete the course, return true
    //put all nodes and its neighbors in a map

    // boolean[] visited;
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     HashMap<Integer, List<Integer>> map = new HashMap<>();
    //     // node -> prerequisites
    //     visited = new boolean[numCourses];
    //     for(int i = 0; i < numCourses; i ++){
    //         map.put(i, new ArrayList<>()); //initializing the map
    //     }

    //     for(int[] pre : prerequisites){
    //         // if(!map.containsKey(pre[0])){
    //         //     map.put(pre[0], new ArrayList<>());
    //         // }
    //         map.get(pre[0]).add(pre[1]);

    //     }
    //     for(int i = 0; i < numCourses; i ++){
    //         if(!dfs(i, map)){ //start from 0
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean dfs(int node, HashMap<Integer, List<Integer>> map){
    //     if(map.get(node).size() == 0){ //return true if a node in the map does not have 
    //     //any prerequisites
    //         return true;
    //     }

    //     visited[node] = true;
    //     for(int neighbor : map.get(node)){
    //         if(visited[neighbor]){ //to avoid cyclic graphs
    //             continue;
    //         }
    //         if(dfs(neighbor, map)){ //if any of the neighbor of a node cannot be completed than the node itself cannot be completed
    //             map.get(node).remove(Integer.valueOf(neighbor));
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //intuition 3: use hashMap to store the dependencies of each node. Then run dfs on node 0 and see
    //if it have dependencies and then run dfs on each dependency and finally return true for a node that
    //do not have any dependecies. Also remove the dependency from a node if we know that the dependency course
    //is possible to complete. Maintain a visited set to avoid any revists during dfs and a validCourse set to set a course
    //true if a course is found to be valid in some dfs call (results are cached, to avoid next time) 
    // boolean[] visited;
    // boolean[] validCourse;
    // HashMap<Integer, List<Integer>> map;
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     map = new HashMap<>();
    //     visited = new boolean[numCourses]; 
    //     validCourse = new boolean[numCourses]; 
    //     for(int course = 0; course < numCourses; course ++){
    //         map.put(course, new ArrayList<>());
            
    //     }
    //     for(int[] dependency : prerequisites){
    //         int course = dependency[0];
    //         map.get(course).add(dependency[1]);
    //     }
    //     for(int course = 0; course < numCourses; course ++){ //making sure that all courses are verified
    //         if(!dfs(course, map)){ //return even if one of the course is not possible to be compeleted
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean dfs(int course, HashMap<Integer, List<Integer>> map){
    //     if(visited[course]){
    //         return false;
    //     }
    //     if(validCourse[course]){
    //         return true;
    //     }
    //     visited[course] = true;
    //     // List<Integer> removalList = new ArrayList<>();
    //     for(int depCourse : map.get(course)){
    //         // if(depCourse)
    //         // if(!visited[depCourse]){
    //             if(!dfs(depCourse, map)){
    //                 //doing this(i.e., removing elements from a list while iterating over it) in java is not
    //                 //allowed (checkForComodification error)
    //                 // map.get(course).remove(Integer.valueOf(depCourse)); //removing dependency course if it is 
    //                 //possible to complete
    //                 // removalList.add(depCourse); // -> TLE
    //                 return false;
    //             }
    //             else{
    //                 validCourse[depCourse] = true;
    //             }
    //         // }
    //         // else{
    //             // return false;
    //         // }
    //     }

    //     // for(int rem : removalList){
    //     //     map.get(course).remove(Integer.valueOf(rem));
    //     // }
    //     visited[course] = false;
    //     // if(map.get(course).size() == 0){ //if all the dependcy courses are possible to be completed then 
    //     // //the list of depencies of course will not have anything
    //     //     return true;
    //     // }
    //     return true;
    // }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    //cleaning up intuition 3
    // boolean[] visited; //for courses within a recursive call
    // boolean[] validCourse; //for marking overall courses as valid 
    // HashMap<Integer, List<Integer>> map;
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     map = new HashMap<>();
    //     visited = new boolean[numCourses]; 
    //     validCourse = new boolean[numCourses]; 
    //     for(int course = 0; course < numCourses; course ++){
    //         map.put(course, new ArrayList<>());
            
    //     }
    //     for(int[] dependency : prerequisites){//setting up map with courses and dependent courses
    //         int course = dependency[0];
    //         map.get(course).add(dependency[1]);
    //     }
    //     for(int course = 0; course < numCourses; course ++){ //making sure that all courses are verified
    //         if(!dfs(course, map)){ //return even if one of the course is not possible to be compeleted
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // public boolean dfs(int course, HashMap<Integer, List<Integer>> map){
    //     if(visited[course]){ //if the course have already been visited, return false, to avoid cycles
    //         return false;
    //     }
    //     if(validCourse[course]){ //if the course is alredy found to be valid in some other dfs call
    //         return true;
    //     }
    //     visited[course] = true;
    //     for(int depCourse : map.get(course)){
    //         if(!dfs(depCourse, map)){ 
    //             return false; //returning false if any dependent course is not possible to complete
    //         }
    //         else{
    //             validCourse[depCourse] = true; //marking a dependent course as valid for future references
    //         }
    //     }
    //     visited[course] = false; //resetting visited[course] = false so that it is available for future traversals 
    //     return true; //return true if all dependent courses can be completed
    // }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //intuition 4: Using 3-state have only 1 visited set. If 0 then it means that the course is not visited yet. If it is 1 then it means
    //it is being traversed currently in a dfs call and if it is 2 it means that it is valid course which can be completed. 
    //Store the courses in map against their dependent courses. Traverse each of the course's dependents, return false if there is 
    //a cycle (i.e. if the course is marked as 1). If none of the dependent courses return true, then that means that the parent course is
    //a valid one. If in between a dependent course returns true, then mark it as 2 on the spot to avoid any future traversals.

    // int[] visited;
    // HashMap<Integer, List<Integer>> map; 
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     visited = new int[numCourses];
    //     map = new HashMap<>();
    //     for(int i = 0; i < numCourses; i ++){ //initializing the map
    //         map.put(i, new ArrayList<>());
    //     }

    //     for(int[] pre : prerequisites){
    //         map.get(pre[0]).add(pre[1]);
    //     }

    //     for(int course = 0; course < numCourses; course ++){
    //         if(!dfs(course)){
    //             return false; //even if 1 course is not possible to complete, return false
    //         }
          
    //     }
        
    //     return true;
    // }

    // public boolean dfs(int course){
    //     if(visited[course] == 2){ //return true, if the course have already been marked as 2
    //         return true;
    //     }
    //     if(visited[course] == 1){ //if a course have been marked as 1 in visited, return false, because of a cycle
    //         return false;
    //     }

    //     visited[course] = 1; //marking the course to be in a recursive call

    //     for(int depCourse : map.get(course)){
    //         if(!dfs(depCourse)){ //return false if any of the depCourse's dfs call returns false
    //             return false;
    //         }
    //         else{
    //             visited[depCourse] = 2; //marking a course as a valid one
    //         }
    //     }
    //     visited[course] = 0; //marking course as 0 to allow for revist by next dfs calls
    //     visited[course] = 2; //for marking the course as 2 if it is a valid one
    //     return true;
    // }


}






