import java.util.*;
/**
 * 
LEARN
 Run While loop . 
 find left  ; 
 if leaf then use thread to jump 
 else 
    1 find rightMost Node of the left ; 
    if rmn.right is null then create thread and traverse to the left ;
    else delte thread (rmn.right = null) and traverse to the right ;

    NOTE
 * INORDER REGION: if(left == null) and the else region of thread deletion .
 * PREORDER REGION: if(left == null) and the if part of thread creation
 * 
 */
class morrisTemplate{
    public static void main(String[] args){

    }
    public static TreeNode rightMost(TreeNode node, TreeNode curr){
        while(node.right != null && node.right != curr){
            node = node.right ;
        }return node;
    }
    public static ArrayList<Integer> morrisInTraversal(TreeNode root) {
        TreeNode curr = root ;
        while(curr != null){// keep running untill curr is not null
            TreeNode left = curr.left ;
            if(left == null){ // if left is null then move left ; and visit if needed. 
               // do some work if needed. 
                curr = curr.right ;
            }else{
                TreeNode rightMost = rightMost(left, curr);
                if(rightMost.right == null){// create thread and traverse to the left 
                    rightMost.right = curr ;
                    curr = curr.left ;
                }else{// delete thread and traverse to the right ;
                    righMost.right = null ;
                    curr = curr.right;
                }
            }
        }
}