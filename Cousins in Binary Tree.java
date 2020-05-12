/*

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false

Note:
The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.

Solution Approach :
Here we can perform level order traversal to check if x and y are at the same depth, at the same time check if parent of the both the elements is same.

*/

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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root==null) return false;
        boolean xExstFlg=false,yExstFlg=false;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            
            xExstFlg=false;
            yExstFlg=false;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                
                if(curr.val==x) xExstFlg=true;
                if(curr.val==y) yExstFlg=true;
                
                if((curr.left!=null && curr.right!=null) && 
                   ((curr.left.val==x && curr.right.val==y)||
                    (curr.left.val==y && curr.right.val==x))){
                    return false;
                }
                
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            if(xExstFlg && yExstFlg) return true;
        }
        return false;        
    }
}

