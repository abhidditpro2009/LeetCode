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
class BSTIterator {
​
    List<Integer> list = new ArrayList<>();
    int count = -1;
    //int backward = 0;
    
    public BSTIterator(TreeNode root) {
        
        BSTIteratorHelper(root);
    }
    
    public void BSTIteratorHelper(TreeNode root) {
     
        if(root == null)
            return;
        
        BSTIteratorHelper(root.left);
        list.add(root.val);
        BSTIteratorHelper(root.right);
    }
    
    public boolean hasNext() {
        
        if(count < list.size() -1)
            return true;
        else
            return false;
    }
    
    public int next() {
    
        return list.get(++count);
