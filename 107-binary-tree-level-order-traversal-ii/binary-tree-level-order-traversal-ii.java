/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // intuition 1: Use queue to store and retrieve accordingly. Add sub lists to ans from front rather than last
    // public List<List<Integer>> levelOrderBottom(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if(root == null){
    //         return ans;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int qSize = queue.size();
    //         List<Integer> tempList = new ArrayList<>();
    //         for(int i = 0; i < qSize; i ++){
    //             TreeNode tempNode = queue.poll();
    //             if(tempNode != null){
    //                 tempList.add(tempNode.val);
    //                 queue.offer(tempNode.left);
    //                 queue.offer(tempNode.right);
    //             }
    //         }
    //         if(tempList.size() > 0){
    //             ans.add(0, tempList);    // to add the elements from the start rather than adding at last
    //         }
    //     }
    //     // return Collections.reverse(ans);
    //     return ans;

    // }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // intuition 2 (without using extra memory, i.e. not using queue): Use helper function and create new lists per level.
    // Add sub lists to ans from front rather than last.
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return ans;
        }
        levelTraversal(root, 0);
        return ans;
    }

    private void levelTraversal(TreeNode root, int level){
        if(root == null){
            return;
        }

        // System.out.println("ans.size() : " + ans.size());
        // System.out.println("root.val : " + root.val);
        // System.out.println("level : " + level);
        if(ans.size() == level){ // control is one level down than the size of ans. i.e. there is a need to have a new sublist in ans
        // as previous sublists must have been populated by previous levels
            ans.add(0, new ArrayList<>());
        }
        
        ans.get(ans.size() - level - 1).add(root.val); // ans.size() - level - 1 to add elements to 
        // the latest added sublist in ans (from front) 
        // System.out.println("ans.get(level) : " + ans.get(level));
        // System.out.println("***********");

        // levelTraversal(root.left, level ++);
        // levelTraversal(root.right, level ++); 
        // level ++ increments the variable for subsequent recursive calls, which messes up recursion, 
        // level + 1 only affects the current call, keeping levels accurate.

        // level = 0 
        // level ++ -> this will send the level as 0 in this call and update the level to 1 after this call
        // leve + 1 -> this will send the level as 1 in this call, leaving next call independent
        levelTraversal(root.left, level + 1);
        levelTraversal(root.right, level + 1);
    }

}