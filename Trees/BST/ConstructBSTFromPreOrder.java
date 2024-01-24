//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

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
    public TreeNode bstFromPreorder(int[] preorder) {

       return bstFromPreorderHelper(preorder,0,preorder.length-1);
    }

    public TreeNode bstFromPreorderHelper(int[] preorder,int start,int end){
        if(start>end)return null;
        TreeNode root=new TreeNode(preorder[start]);

        int idx = start; 
        //can do binary search as well - Arrays.binarySearch(preorder, preorder[st]);
        for(idx = start; idx<=end; idx++) {
            if(preorder[idx] > preorder[start]) break;
        }

        root.left = bstFromPreorderHelper(preorder, start+1, idx-1);
        root.right = bstFromPreorderHelper(preorder, idx, end);
        
        return root;
        
    }
}
