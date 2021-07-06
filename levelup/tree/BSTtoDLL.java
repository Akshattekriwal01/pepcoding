
// this is fastest possible solution to the question
class Solution {
    // please
    // lets do a morris traversal
    // we can build succeccor relation ship and store prev to build predicessor relation ship
    public Node treeToDoublyList(Node root) {
       if(root == null){
           return root;
       }
        Node curr = root ;
        Node prev =  new Node(-1,null,root);
        Node head = prev ;    
        
        while(curr != null ){
            if(curr.left == null ) // left case
            {
                prev.right = curr ;
                curr.left = prev;
                prev = curr ;
                
                curr = curr.right ; 
            }else{
                Node rightMost = rightMost(curr.left , curr);
                //create thread
                if(rightMost.right == null){
                    rightMost.right = curr ;
                    curr = curr.left ;
                }else{
                    // dont delete the thread
                   
                    prev.right = curr ;
                    curr.left = prev ;
                    prev = curr;
                    
                    curr = curr.right;
                }
            }
            
        }
        head = head.right ; 
        prev.right = head ;
        head.left = prev ;
        return head;
    }
    public  Node rightMost(Node n, Node curr){
        while(n.right != null && n.right!=curr){
            n = n.right ; 
        }
        return n ;
    }
}