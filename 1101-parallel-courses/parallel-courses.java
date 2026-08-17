class Solution {

    //Solving on 17 Aug 2026

    //intuition 1: 
        //Topic: Graphs
        //Pattern: Topological Sort (as a DAG is there)
        //Sub-Pattern: BFS (Kahn's algo)

        //prevCourse -> nextCourse indicates that prevCourse needs to be finished before
            //nextCourse can start. 
        //Now each prerequisite course in a course is an incoming edge (indgree ++) 
        //And for any course that have all the prerequisites satisfies will technically 
            //have indgree = 0 (indicating no incoming edge) 
        //We can rephrase this as: "For a course to be eligible to be taken in a semester
            //its indegree should be 0"
        //This way we can get minimum semeseters as we take all the possible courses (with 
            //inDegree as 0) in each level

        //We can apply BFS - Kahn's algorithm here.
            //We can run BFS traversal and at each level we will try to process (take) courses
                //and reduce the indegree of adjacent courses
            //If number of processed courses != total courses then there must be a cycle and
                //that means that we cannot take all courses, return -1
            
            //Have an array of indgree 
            //Have a qeueue to store all courses with indegree 0
            //Each iteration of BFS will be 1 semester
            //Poll courses from the queue and reduce the indgree of adjacent course
            //Increment count of takenCourses
            //See if takenCourses == totalCourses
        
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