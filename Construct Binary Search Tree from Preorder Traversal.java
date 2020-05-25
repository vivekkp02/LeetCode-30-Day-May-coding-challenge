/*
Return the root node of a binary search tree that matches the given preorder traversal.
(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
It's guaranteed that for the given test cases there is always possible to find a binary search tree with the given requirements.

Example 1:
Input: [8,5,1,7,10,12]
Output: [8,5,10,1,7,null,12]

Constraints:
1 <= preorder.length <= 100
1 <= preorder[i] <= 10^8
The values of preorder are distinct.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    int pIndex = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
        int len = preorder.length;
        
        int[] inorder = new int[len];
        
        for(int i=0; i<len; i++)
            inorder[i]=preorder[i];
        
        Arrays.sort(inorder);
        
        return createBST(0, len-1, preorder, inorder);
        
    }
    
    private TreeNode createBST(int start, int end, int[] preorder, int[] inorder){
        
        if(start > end)
            return null;
        
        TreeNode node = new TreeNode(preorder[pIndex++]);
        
       // if(start==end)
         //   return node;
        
        int inIndex = search(node.val, inorder, start, end);
        
        node.left = createBST(start, inIndex-1, preorder, inorder);
        node.right = createBST(inIndex+1, end, preorder, inorder);
        
        return node;
    }
    
    private int search(int key, int[] inorder, int start, int end){
        int searchIndex = start;
        
        for(;searchIndex<end; searchIndex++){
            if(inorder[searchIndex] == key)
                return searchIndex;
        }
        
        return searchIndex;
    }
}
