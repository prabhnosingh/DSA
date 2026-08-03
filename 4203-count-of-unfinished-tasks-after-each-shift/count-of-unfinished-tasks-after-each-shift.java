class Solution {

    //Solving on 02 Aug 2026

    //Intuition 3 (prefix-sum + binary search) 
        //outer loop will be for looping through shifts array
        //Have a prefix-sum array of tasks
        //Have a variable storing work completed in the current cycle
        //Apply binary search to determine how many tasks are finished
            //Apply binary search on the prefix-sum array (sorted) and find the
                //mid. After that see if that mid is:
                    //larger than the currShift -> completion will be partial, 
                        //make right = mid - 1
                    //smaller/equal than the currShift -> completion will be full, 
                        //make left = mid + 1
                    //the binary search loop ends when left > right is achieved
                    //number of tasks completed will be left - 1
    
        //TC: O()
        //SC: O()
    public int[] countTasks(int[] tasks, int[] shifts) {

        int totalTasks = tasks.length;
        int totalShifts = shifts.length;
        long[] prefixTasks = new long[totalTasks];

        prefixTasks[0] = tasks[0];
        for(int i = 1; i < totalTasks; i ++){
            prefixTasks[i] = prefixTasks[i-1] + tasks[i];
        }

        long totalTaskWork = prefixTasks[totalTasks-1];
        long completedWork = 0;
        
        int[] remTasks = new int[totalShifts];
        
        for(int i = 0; i < totalShifts; i ++){
            int currShift = shifts[i];
            
            completedWork += currShift;

            if(totalTaskWork <= completedWork){ //all tasks were completed. reset completed work and continue
                completedWork = 0;
                remTasks[i] = 0;
                continue;
            }

            //finding the number of tasks completed based on completedWork
            int completedTasks = findCompletedTasksUpperBound(prefixTasks, completedWork);

            remTasks[i] = totalTasks - completedTasks; 
            
        }

        return remTasks;
        
    }

    //finding number of tasks completed by finding elements less than the target (finding
        //first element greater than target) 
    public int findCompletedTasksUpperBound (long[] prefixTasks, long target){
        int left = 0;
        int right = prefixTasks.length;
        while(left < right){
            int mid = left + (right - left) / 2;

            long currPrefixTask = prefixTasks[mid];
        
            if(currPrefixTask <= target){ 
                left = mid + 1;
            }
            else{ //when currPrefixTask > currShift
                right = mid;
            }
        }
        return left;
        
    }





// /////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 01 Aug 2026

//     //Intuition 2 (pointer approach): Do not use stacks and instead store the state of 
//         //pending task in a one variable and another variable for index of task.
//         //when index of task reaches tasks.length, then we know that remaining tasks are 0

//         //TC: O(totalTasks x totalShifts)
//         //SC: O(1)
//     public int[] countTasks(int[] tasks, int[] shifts) {

//         int totalTasks = tasks.length;
//         int totalShifts = shifts.length; 
    
//         int remTasks = totalTasks; 
//         int currTaskIdx = 0; //index of currTask

//         int[] unfinishedTasks = new int[totalShifts];
        
//         int currTask = tasks[currTaskIdx];
//         for(int i = 0; i < totalShifts; i ++){
//             int currShift = shifts[i];

//             while(true){//need a while loop, since a single shift can complete all tasks
//                 if(currShift >= currTask){ //shift completes this task for sure and moves
//                         //to next task
//                     currShift -= currTask;
//                     remTasks -= 1;
                    
//                     // System.out.println("currShift " + currShift + " remTasks " + remTasks);
//                     currTaskIdx += 1; //moved to next task
//                     if(currTaskIdx == totalTasks){//all tasks completed. reset currTaskIdx to 0
//                         currTaskIdx = 0;
//                         currTask = tasks[currTaskIdx];
//                         break; 
//                     }
//                     currTask = tasks[currTaskIdx];
//                 }
//                 else if(currShift < currTask){ //currShift will not be able to complete the 
//                     //currTask but will help in reducing time from currTask
//                     int temp = currTask;
//                     currTask -= currShift;
//                     currShift -= temp; //to make currShift negative
//                 }

//                 if(currShift <= 0) break; //available time in shift over, move to next shift
                
//             }

//             unfinishedTasks[i] = remTasks;
//             if(remTasks == 0) remTasks = totalTasks;
//         }

//         return unfinishedTasks;

        
//     }





/////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 01 Aug 2026

    // //Intuition 1: Stacks
    //     //have a stack that stores the task in right to left order
    //     //poll the tasks until the shift have some time left, when the time is over, put the
    //         //remaing task in the stack
    //     //if the shift results in empty stack, refill the stack

    //     //TC: O(tasks x shifts)
    //     //SC: O(tasks)
    // public int[] countTasks(int[] tasks, int[] shifts) {
    //     // Stack<Integer> stack = new Stack<>();
    //     Deque<Integer> stack = new ArrayDeque<>();
    //     fillStack(stack, tasks);
    //     int[] unfinishedTasks = new int[shifts.length];
    //     int totalTasks = tasks.length;
        
    //     int totalRemTasks = totalTasks;
    //     for(int i = 0; i < shifts.length; i ++){
    //         int currShift = shifts[i];

    //         while(!stack.isEmpty()){  

                
    //             int currTask = stack.poll();
                
    //             if(currTask > currShift){ //currTask will not be finshed
    //                 currTask -= currShift;
    //                 stack.push(currTask);
    //                 break;
    //             }
    //             else if(currTask <= currShift){//currTask will be finshed
    //                 totalRemTasks -= 1;
    //                 currShift -= currTask;
    //             }

    //             if(currShift == 0) break;
    //         }

    //         if(stack.isEmpty()){ //if stack is empty (all tasks are processed), refill the stack
    //                 //and store 0 in unfishedTasks[i]
    //             fillStack(stack, tasks);
    //             totalRemTasks = totalTasks;
    //             unfinishedTasks[i] = 0;
                
    //         } 
    //         else{ //if stack is not empty, store totalRemTasks in unfishedTasks[i]
    //             unfinishedTasks[i] = totalRemTasks;
    //         }
    //     }

    //     return unfinishedTasks;
        
    // }

    // public void fillStack(Deque<Integer> stack, int[] tasks){
    //     for(int i = tasks.length - 1; i >= 0; i --){
    //         stack.push(tasks[i]);
    //     }
    // }
}