/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums.length == 0)
            return null;
​
        return bstHelper(nums, 0, nums.length-1);
        
    }
    
    public TreeNode bstHelper(int[] nums, int left, int right){
        
        if(left > right )        
            return null;
        
        int mid = left + (right-left)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        // its mid -1 because root is already allocated
        
        root.left = bstHelper(nums,left,mid-1);
        
        // its mid +1 because root is already allocated
        root.right = bstHelper(nums,mid+1,right);
        
        return root;
    }
}
