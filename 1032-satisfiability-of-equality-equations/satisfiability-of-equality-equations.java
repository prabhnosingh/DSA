class DSU{
    int[] parent;
    int[] rank;

    DSU(){
        parent = new int[26];
        rank = new int[26];

        for(int i = 0; i < 26; i ++){
            parent[i] = i;
        }
    }

    public int findUltimateParent(int node){
        if(node != parent[node]){
            parent[node] = findUltimateParent(parent[node]);
        }
        return parent[node];
    }

    public boolean unite(int node1, int node2){
        int parent1 = findUltimateParent(node1);
        int parent2 = findUltimateParent(node2);

        if(parent1 == parent2) return false;

        int rank1 = rank[parent1];
        int rank2 = rank[parent2];

        if(rank1 > rank2){
            parent[parent2] = parent1;
        }
        else if(rank2 > rank1){
            parent[parent1] = parent2;
        }
        else{ //when rank1 == rank2
            rank[parent1] += 1;
            parent[parent2] = parent1;
        }
        return true;
    }
}

class Solution {

    //Solving on 23 Jan 2026:

    //intuition 3: Graph : DSU
        //run two iterations:
            //In first iteration unite the variables with "=="
            //In second itertion check if any variables with "!=" have same parents, if yes, return false 
    public boolean equationsPossible(String[] equations) {
        
        DSU dsu = new DSU();

        //iteration 1: uniting all "==" equations
        for(String equation : equations){
            char variable1 = equation.charAt(0);
            char equality1 = equation.charAt(1);
            char equality2 = equation.charAt(2);
            char variable2 = equation.charAt(3);

            // String equality = equality1 + "" + equality2 + "";

            StringBuilder sb = new StringBuilder();
            sb.append(equality1);
            sb.append(equality2);
            String equality = sb.toString();

            if(equality.equals("==")){
                dsu.unite(variable1 - 'a', variable2 - 'a');
            }
        }

        //iteration 2: uniting all "!=" equations
        for(String equation : equations){
            char variable1 = equation.charAt(0);
            char equality1 = equation.charAt(1);
            char equality2 = equation.charAt(2);
            char variable2 = equation.charAt(3);

            // String equality = equality1 + "" + equality2 + "";
            StringBuilder sb = new StringBuilder();
            sb.append(equality1);
            sb.append(equality2);
            String equality = sb.toString();

            if(equality.equals("!=")){
                int parent1 = dsu.findUltimateParent(variable1-'a');
                int parent2 = dsu.findUltimateParent(variable2-'a');
                if(parent1 == parent2) return false;
            }
        }
        return true;
       
    }




////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// class DSU{
//     int[] parent;
//     int[] rank;

//     DSU(){
//         parent = new int[26];
//         rank = new int[26];

//         for(int i = 0; i < 26; i ++){
//             parent[i] = i;
//         }
//     }

//     public int findUltimateParent(int node){
//         if(node != parent[node]){
//             parent[node] = findUltimateParent(parent[node]);
//         }
//         return parent[node];
//     }

//     public boolean unite(int node1, int node2){
//         int parent1 = findUltimateParent(node1);
//         int parent2 = findUltimateParent(node2);

//         if(parent1 == parent2) return false;

//         int rank1 = rank[parent1];
//         int rank2 = rank[parent2];

//         if(rank1 > rank2){
//             parent[parent2] = parent1;
//         }
//         else if(rank2 > rank1){
//             parent[parent1] = parent2;
//         }
//         else{ //when rank1 == rank2
//             rank[parent1] += 1;
//             parent[parent2] = parent1;
//         }
//         return true;
//     }

// }

// class Solution {

//     //Solving on 23 Jan 2026:

//     //intuition 2: Graph : DSU
//          //failing at ["a==b","b==c","a==c"]
//         //solve with DSU findultimate parent:

//             //if any one of the variables are not already visited
//                 //unite variables of each "==" equation
//                 //for every "!=" equation check if both the variables have different parents,
//                     //if they have same parents, then return false
//             //if both the variables are already visited
//                 //if the sign is == and the parents are differnt return false
//                 //if the sign is != and the parents are same return false
//     public boolean equationsPossible(String[] equations) {
        
//         HashSet<Character> set = new HashSet<>();

//         DSU dsu = new DSU();

//         for(String equation : equations){
//             char c1 = equation.charAt(0);
//             char c2 = equation.charAt(1);
//             char c3 = equation.charAt(2);
//             char c4 = equation.charAt(3);


//             String equality = c2 + "" + c3 + "";
//             int parent1 = dsu.findUltimateParent(c1-'a');
//             int parent2 = dsu.findUltimateParent(c4-'a');


//             if(!set.contains(c1) || !set.contains(c4)){
//                 set.add(c1);
//                 set.add(c4);

//                 if(equality.equals("==")){
//                     dsu.unite(c1 - 'a', c4 - 'a');
//                 }
//                 else{ //"!="

//                     if(parent1 == parent2) return false;
//                 }
//             }
//             else{ //when both the characters are already present in the set
//                 if(equality.equals("==")){
//                     if(parent1 != parent2) return false;
//                 }
//                 else{ //"!="
//                     if(parent1 == parent2) return false;
//                 }
//             }

//         }
//         return true;

//     }












//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 23 Jan 2026:

    // //intuition 1 (Did not work for all test cases): Graph : adjList
    //     //Feels like dfs -> Assign integers -> check if any equation fails 

    //     //Create an adjacency list
    //     //Iterate over the equations and add the characters that are not already in the adjList
    //     //if any equation points to an edge that "should be" or "should not be" present return false


    //     //failing at ["a==b","b==c","a==c"]
    //     //can this be done with DSU findultimate parent:
    //         //if the sign is == and the parents are differnt return false
    //         //if the sign is != and the parents are same return false
    // public boolean equationsPossible(String[] equations) {
        
    //     HashMap<Character, List<Character>> adjList = new HashMap<>();

    //     for(String equation : equations){
    //         char c1 = equation.charAt(0);
    //         char symbol1 = equation.charAt(1);
    //         char symbol2 = equation.charAt(2);
    //         char c2 = equation.charAt(3);
            
    //         String equality = symbol1 + "" + symbol2 + "";

    //         if(!adjList.containsKey(c1) || !adjList.containsKey(c2)) {
    //             if(!adjList.containsKey(c1)){
    //                 adjList.put(c1, new ArrayList<>());
    //                 adjList.get(c1).add(c1);
    //             }
    //             if(!adjList.containsKey(c2)){
    //                 adjList.put(c2, new ArrayList<>());
    //                 adjList.get(c2).add(c2);
    //             } 

    //             if(equality.equals("==") && c1 != c2){
    //                 adjList.get(c1).add(c2);
    //                 adjList.get(c2).add(c1);
    //             }
    //         }
    //         else{
    //             if(equality.equals("==")){ //there should be an edge between c1 and c2
    //                 if(!adjList.get(c1).contains(c2) || !adjList.get(c2).contains(c1)){
    //                     return false; 
    //                 }
    //             }
    //             else{ //when the equality is !=. There should not be an edge between c1 and c2
    //                 if(adjList.get(c1).contains(c2)) return false;
    //             }

    //         }


    //     }
    //     return true;

    // }
}