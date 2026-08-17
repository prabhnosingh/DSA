class Solution {

    //Solving on 17 Aug 2026

    //intuition 1: 
        //Topic: Graphs
        //Pattern: Topological Sort (Directed with probable Acyclic graph)
        //Sub-Pattern: Level-order BFS + Kahn's algo

        //prevCourse -> nextCourse indicates that prevCourse needs to be finished before
            //nextCourse can start. 
        //Now each prerequisite course in a course is an incoming edge (indgree ++) 
        //And for any course that have all the prerequisites satisfied will technically 
            //have indgree = 0 (indicating no incoming edge) 
        //As prerequisite courses are completed, we conceptually remove their outgoing edges.
            //When a course's indegree becomes 0, all of its prerequisites have been completed, 
            //so it can be taken in the next semester.
        //We can rephrase this as: "For a course to be eligible to be taken in a semester
            //its indegree should be 0"
        //This way we can get minimum semeseters as we take all the possible courses (with 
            //inDegree as 0) in each level
            

        //We can apply BFS - Kahn's algorithm here.
            //We can run BFS traversal and at each level we will try to process (take) courses
                //and reduce the indegree of adjacent courses
            //If number of processed courses != total courses then there must be a cycle and
                //that means that we cannot take all courses, return -1
            //Nodes in a directed cycle always retain at least one incoming edge from another
                //unprocessed node in that cycle, so none of them can enter the indegree-0 queue.
            
            //Have an array of indgree 
            //Have a qeueue to store all courses with indegree 0
            //Each iteration of BFS will be 1 semester
            //Poll courses from the queue and reduce the indgree of adjacent course
            //Increment count of takenCourses
            //See if takenCourses == totalCourses
    
        //Summary:
            //Each BFS level represents one semester.
             
            //At the beginning of a semester, the queue contains every course whose 
                //prerequisites have already been completed.
                
            //We take all of them simultaneously during that semester and remove 
                //their outgoing edges.
            
            //Courses whose indegree becomes 0 are added to the queue for the next semester.

            //If fewer than total courses are eventually processed, a cycle exists, so 
                //completing all courses is impossible.

        //V = n
        //E = relations.length

        //TC: O(V) - initialzing adjList +
            //O(E) - building adjList and inDegree +
            //O(V) - first enqueue to the queue of inDegree 0 courses
            //O(V+E) - for BFS (each course and relation is processed once)
            //TC: O(V+E)

        //SC: O(V+E) - for adjList
            //O(V) - for inDegree
            //O(V) - for queue
            //SC: O(V+E)
        
    public int minimumSemesters(int n, int[][] relations) {
        
        int totalCourses = n + 1;
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[totalCourses];
        Queue<Integer> queue = new ArrayDeque<>();
        int minimumSemesters = 0;

        //initializing adjList
        for(int i = 0; i < totalCourses; i ++){
            adjList.add(new ArrayList<>());
        }

        //building adjList and inDegree
        for(int[] relation : relations){
            int prevCourse = relation[0];
            int nextCourse = relation[1];
            
            adjList.get(prevCourse).add(nextCourse);
            inDegree[nextCourse] += 1;
        }

        //enqueuing indegree 0 courses to the queue
        for(int i = 0; i < totalCourses; i ++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        int coursesTaken = 0;
        //running BFS algo
        while(!queue.isEmpty()){
            int currQueueSize = queue.size();
            minimumSemesters += 1;

            for(int i = 0; i < currQueueSize; i ++){
                int currCourse = queue.poll();
                coursesTaken += 1;

                //reducing inDegrees of connecing courses
                for(int connectedCourse : adjList.get(currCourse)){
                    inDegree[connectedCourse] -= 1;

                    if(inDegree[connectedCourse] == 0) queue.offer(connectedCourse);
                }
            }
        }

        return n+1 != coursesTaken ? -1 : minimumSemesters; //n+1 as 0 will by default be taken
            //as a course, since array starts with 0 index




    }
}