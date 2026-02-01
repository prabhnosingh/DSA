class Solution {

    //Re-solving on 01 Feb 2026

    //intuition 2: Graphs
        //Have a trustArr array that tracks the trust value of each person at its index
        //Now as the judge do not trust anyone and is trusted by everyone else, it should
            //have trust value of exactly n-1

    public int findJudge(int n, int[][] trust) {
        
        if(n == 1 && trust.length == 0){
            return 1;
        }

        int[] trustArr = new int[n+1];

        for(int[] trustNode : trust){
            int node1 = trustNode[0];
            int node2 = trustNode[1];

            trustArr[node1] -= 1; //trust value of node1 is decreased by 1
            trustArr[node2] += 1; //trust value of node2 is increased by 1
        }

        for(int i = 1; i < n + 1; i ++){
            if(trustArr[i] == n - 1) return i;
        }

        return -1;
    }







////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 01 Feb 2026

//     //intuition 1: Graphs :
//         //This is a directed graph problem
//         //If a node i is a town just, then it should not have any children
//         //We need to build an adjacency list

//         //Traverse the trust list from 

//         //TC: O(n^2)
//         //SC: O(n)
//     public int findJudge(int n, int[][] trust) {
//         List<Integer>[] adjList = new ArrayList[n + 1];

//         for(int i = 1; i < n + 1; i ++){
//             adjList[i] = new ArrayList<>();
//         }

//         for(int[] trustNode : trust){
//             int node1 = trustNode[0];
//             int node2 = trustNode[1];

//             adjList[node1].add(node2);
//         }


//         for(int i = 1; i < n + 1; i ++){
//             List<Integer> childNodes = adjList[i];

//             if(childNodes.size() == 0){ //i node do not trust anyone. Now check if i node is trusted by everyone
//                 if(isJudge(i, adjList, n)){
//                     return i;
//                 }
//             }
//         }

//         return -1;
        
//     }


//     private boolean isJudge(int probableJudge, List<Integer>[] adjList, int n){
//         for(int j = 1; j < n + 1; j ++){
//             if(j == probableJudge) continue;
//             if(!adjList[j].contains(probableJudge)){
//                 return false;
//             }
//         }
//         return true;
// }

































/////////////////////////////////////////////////////////////////////////////////////////////////////
    //intuition 1: Have a set for storing not judge people, i.e. the people represented trust[i][0].
    //Also assign judge based on trust[0][1] and then verify for each trust[i]. If any trust[i] have a
    //different trusted person other than previously assigned judge, return -1
    // public int findJudge(int n, int[][] trust) {
    //     if(trust.length == 0){
    //         return -1;
    //     }
    //     int judge = trust[0][1];

    //     for(int[] t : trust){
    //         if(t[1] != judge){
    //             return -1;
    //         }
    //     }
    //     return judge;

    // }

    //////////////////////////////////////////////////////////////////////////////////////////////////

    //intuition 2(beats 5%): Have a hashMap to store each person and their trust count. 
    //decrement trust count for a person in the first index of each array and increment the trust count
    //for the person on the second index. The judge will be trusted by exactly n - 1 people (+ (n - 1))
    // public int findJudge(int n, int[][] trust) {
    //     if(trust.length == 0){
    //         if(n == 1){
    //             return 1;
    //         }
    //         return -1;
    //     }
    //     HashMap<Integer, Integer> trustMap = new HashMap<>();

    //     for(int[] t : trust){
    //         trustMap.put(t[0], trustMap.getOrDefault(t[0], 0) - 1);
    //         trustMap.put(t[1], trustMap.getOrDefault(t[1], 0) + 1);
    //     }

    //     for(int people : trustMap.keySet()){
    //         if(trustMap.get(people) == n - 1){
    //             return people;
    //         }
    //     }
    //     return -1;
    // }

    ///////////////////////////////////////////////////////////////////////////////////////////

    // // intuition 2: store trust in an array where its indices represent people's labels
    // public int findJudge(int n, int[][] trust) {
    //     if(trust.length == 0){
    //         if(n == 1){
    //             return 1; //if trust length = 0 and n = 1, means that there is only 1 person in the town
    //             //and he trusts no one. So he should be the judge
    //         }
    //         return -1;
    //     }
    //     int[] trustArr = new int[n + 1];

    //     for(int[] trustPair : trust){
    //         trustArr[trustPair[0]] --;
    //         trustArr[trustPair[1]] ++;

    //     }

    //     for(int person = 0; person < trustArr.length; person ++){
    //         if(trustArr[person] == n - 1){ //n - 1 because judge will trust everyone in the town except 
    //         //himself
    //             return person;
    //         }
    //     }
    //     return -1;
    // }

    // ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    // static{
    //     int i=0;
    //     while(i<500){
    //         findJudge(2,new int[][]{{1,2}});i++; //HotSpot JIT-compiles the method (findJudge) down to optimized native 
    //         //code (because we exercised it 500 times). This warmup time is not included in leetcode's time calculations.
    //         //Therefore, when the real execution starts, the optimized code is ran and the calculated time is less.
    //     }
    // }
    // public static int findJudge(int n, int[][] trust) {
        
    //     if(n == 1 && trust.length == 0) return 1;
    //     int[] trustCount = new int[n + 1];

    //     for(int[] edge : trust){
    //         int a = edge[0],b = edge[1];
    //         trustCount[a]--;
    //         trustCount[b]++;
    //     }

    //     for(int i = 1; i <= n; i++){
    //         if(trustCount[i] == n - 1){
    //             return i;
    //         }
    //     }

    //     return -1;
    // }
}