class Solution {

    //Re-solving on 15 Aug 2026

    //intuition 1: 
        //Topic: Graphs
        //Pattern: Topological sort
        //Sub-pattern: BFS : Kahn's algo

        //To complete each course we have some pre-requisites
        //The ordering that we are supposed to return is basically a topological sort 
            //because we want to make sure that any course coming up in the array have
            //all its prerequisites already present in the array before it
        //Therefore we can apply kahn's algo here
            //have an in degree array to store in degree of all the courses
            //add all the courses with in degree equal to 0 to a queue
            //when polling the courses from the queue, reduce the in degree of adjacent
                //courses by 1 and if any adjacent course's in degree reaches 0, add it 
                //to queue
            //after polling the course, add that to the answer array
            //keep track of courses added to the answer array and if at last (after queue
                //becomes empty) the courses added to answer array are still not equal to 
                //numCourses, return empty array, else return answer array

        //E = numCourses
        //V = prerequisites.length

        //TC: O(V) for adjList and in degree construction +
            //O(E) for adding in degree-0 courses to queue +
            //O(E + V) for running BFS (each course and each prerequisite is processed once)


        //SC: O(E + V) for adjList +
            //O(E) for in degree array +
            //O(E) for queue

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] topoOrder = new int[numCourses];
        int processedCourses = 0;

        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        int[] inDegree = new int[numCourses];

        Queue<Integer> queue = new ArrayDeque<>();

        //building adjList and inDegree
        for(int[] prereq : prerequisites){
            int c1 = prereq[0];
            int c2 = prereq[1];

            //c2 -> c1
            if(!adjList.containsKey(c2)) adjList.put(c2, new ArrayList<>());

            adjList.get(c2).add(c1);
            inDegree[c1] += 1;
        }

        //adding indegree-0 courses to queue
        for(int i = 0; i < numCourses; i ++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int currCourse = queue.poll();
            topoOrder[processedCourses ++] = currCourse;

            if(!adjList.containsKey(currCourse)) continue;

            for(int depCourse : adjList.get(currCourse)){
                inDegree[depCourse] -= 1;
                if(inDegree[depCourse] == 0) queue.offer(depCourse);
            }

        }

        return processedCourses != numCourses ? new int[0] : topoOrder; 


    }

     



















//////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 13 Feb 2026

//     //intuition 1: Graphs : Topological sort
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


//     public int[] findOrder(int numCourses, int[][] prerequisites) {

//         List<Integer>[] adjList = new ArrayList[numCourses];

//         //intializing adjList with empty arraylist
//         for(int i = 0; i < numCourses; i ++){
//             adjList[i] = new ArrayList<>();
//         }

//         //filling adjList
//         for(int[] preReq : prerequisites){
//             int dependantCourse = preReq[0];
//             int parentCourse = preReq[1];

//             adjList[parentCourse].add(dependantCourse);
//         }

//         Stack<Integer> stack = new Stack<>();
//         boolean[] visited = new boolean[numCourses];
//         for(int i = 0; i < numCourses; i ++){
//             dfs(i, adjList, stack, visited);
//         }

//         int[] topoSort = new int[numCourses];
//         int[] position = new int[numCourses];

//         int k = 0;
//         while(!stack.isEmpty()){
//             int currCourse = stack.pop();
//             topoSort[k] = currCourse;
//             position[currCourse] = k;

//             k += 1;
//         }

//         for(int parentCourse = 0; parentCourse < numCourses; parentCourse ++){
//             for(int dependentCourse : adjList[parentCourse]){
//                 if(position[parentCourse] >= position[dependentCourse]) return new int[]{}; //parent courses should be
//                 //done before dependentCourses and hence should appear after dependentCourses in topological sort,
//                 //else return false
//             }
//         }

    
//         return topoSort;

//     }

//     private void dfs(int currCourse, List<Integer>[] adjList, Stack<Integer> stack, boolean[] visited){
//         if(visited[currCourse]) return;

//         visited[currCourse] = true;

//         for(int dependentCourse : adjList[currCourse]){
//             dfs(dependentCourse, adjList, stack, visited);
//         }

//         stack.push(currCourse); //pushing currCourse after traversing all its children
//     }





















// //////////////////////////////////////////////////////////////////////////////////////////////////////////
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