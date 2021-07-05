// REVIEW  Reverse inorder in a tree

import java.util.*;
import java.util.Collections ;
public class kthlargest {
    public static void main(String[] args ) {
        Integer[] arr = {100, 50, 150, 25, 75, 125, 175, null, 35, null , null , null, 135,165};
        //Integer[] arr = {1,2    };

        TreeNode root = builder(arr);
         int ans = kthlargest1(root,5);
         System.out.println(ans);
    }
    
    public static int kthlargest1(TreeNode root, int k ){

      //return usingStack(root, k);
      return reverseMorris(root,k);  
        
    }
    public static void insertAllRight(TreeNode node, LinkedList<TreeNode> stack){
        while(node != null){
            stack.push(node);
            node = node.right ;
        }
        
    }
    // O(n) O(n)
    public static int usingStack(TreeNode root, int k ){
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        insertAllRight(root,stack);
        int count = 0 ;
        while(!stack.isEmpty()){
            count ++;
            TreeNode n = stack.pop();
            if(count == k ){
                return n.val;
            }
            insertAllRight(n.left, stack);
        }
       return 0 ; 
    }
    // O(n) O(1)
    public static int reverseMorris(TreeNode root, int k){
       TreeNode curr = root; 
       int count = 0 ;
        while(curr != null){
            TreeNode right = curr.right ;
            if(right == null){ // leaf
                count ++ ;
                if(count == k ){
                    return curr.val;
                }
                curr = curr.left;
            }else{
                TreeNode leftMost = leftMost(right,curr);
                 // create thread 
                if(leftMost.left == null){
                    leftMost.left = curr ; 
                    curr = curr.right;
                }else{
                //delete thread 
                    leftMost.left = null ; 
                    count ++ ;
                    if(count == k ){
                        return curr.val;
                    }
                    curr = curr.left ;
                }
            }
        }
        return 0 ;
    }
    public static TreeNode leftMost(TreeNode node , TreeNode curr){
        while(node.left !=  null && node.left != curr){
            node = node.left ;
        }
        return node;
    }
    
    
    
    
    
    
    // builds a tree in level order
        public static TreeNode builder(Integer[] arr){
            TreeNode tree = new TreeNode() ;
            if(arr.length == 0 ){
                return tree;
            }
            LinkedList<TreeNode> q = new LinkedList<TreeNode>(); 
            tree = new TreeNode(arr[0]);
            q.add(tree);
            int i = 1 ; 
           while(i<arr.length){
    
                TreeNode t = q.poll();
                //! check array length, when checking for null 
                //LEARN check ARRAY null and its length also 
               //
                if(arr[i]!=null){
                    TreeNode left = new TreeNode(arr[i]); 
                    t.left = left;
                    q.add(left);
                    
                }
                ++i;
                if(arr.length !=i && arr[i] != null){
                    TreeNode right = new TreeNode(arr[i]); 
                    t.right = right;
                    q.add(right);
                   
                }
                ++i;
                //System.out.println(i);
            }
            return tree;
        }
}


class TreeNode {
    TreeNode left ; 
    TreeNode right ; 
    int val ;
    public TreeNode(int val){
        left = null;
        right = null ; 
        this.val = val; 
    }
    public TreeNode(){
        left = null ;
        right = null ;
    }
}
