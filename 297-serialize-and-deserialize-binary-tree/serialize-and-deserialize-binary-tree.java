/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    String ans = "";
    int count = 0;

    public String serialize(TreeNode root) {       
        
        dfs(root);
        return ans;
    }
     public TreeNode dfs(TreeNode root){
            
            
            if(root == null){
                ans += "n";
                ans += ",";
                return null;
            }

            ans += root.val;
            ans += ",";


            TreeNode leftChild = dfs(root.left);
            TreeNode rightChild = dfs(root.right);

            return root;
        }   

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");        
        
        return buildTree(arr);
    }

    public TreeNode buildTree(String[] arr){
            
            if(arr[count].equals("n")){
                count ++;
                return null;
            }
            System.out.println(arr[count]);
            TreeNode node = new TreeNode(Integer.parseInt(arr[count]));
            count ++;
            node.left = buildTree(arr);
            node.right = buildTree(arr);
            return node;

    }

    
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));