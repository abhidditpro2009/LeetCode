/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
​
    public Node() {}
​
    public Node(int _val) {
        val = _val;
    }
​
    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
​
class Solution {
   
    Node head = null;
    Node tail = null;
    public Node treeToDoublyList(Node root) {
        
       if(root == null)
            return null;
         
        bst(root);
        tail.right = head;
        head.left = tail;
        
        return head;
    }
    
    public void bst(Node root){
        
        if(root == null)
            return ;
        
        bst(root.left);
        
        if(head != null){
            root.left = tail ;
            tail.right = root;
        }
        else
            head = root;
        
        tail = root;
        
        bst(root.right);
         
        
    }
}
