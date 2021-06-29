import java.util.*;
class lec1 {
    private class Pair{
    List<Integer> al ; 
    int distFromTarget ;
    public Pair(){
        al = new ArrayList<Integer>();
        distFromTarget = 0 ; 
    }
}

public List<Integer> distanceK(TreeNode root, TreeNode target, int k){
    return path(root,target,k).al ;  
}

public void findAns(List<Integer> ans, TreeNode root, int distance, TreeNode blocker){
    if(root == null || distance < 0  ){
        return ;
    }
    if(blocker!= null && root.val == blocker.val){
        return ; 
    }if(distance == 0){
        ans.add(root.val);
        return ; 
    }else{
        findAns(ans, root.left, distance -1 , blocker);
        findAns(ans, root.right, distance -1 , blocker);       
    }
}

public Pair path (TreeNode root, TreeNode target, int k ){
    if(root == null ){
        return null;
    }if(root.val == target.val){
        Pair p = new Pair(); 
        p.distFromTarget = 0 ; 
        findAns(p.al, root, k -  p.distFromTarget, null);
        return p; 
    }else{
        Pair left = path(root.left,target,k);
        if(left != null){
           left.distFromTarget += 1;
          findAns(left.al, root, k -  left.distFromTarget ,root.left);
            return left ; 
        }
        
        Pair right = path(root.right,target,k);
        if(right != null){
           right.distFromTarget += 1;
            findAns(right.al, root, k -  right.distFromTarget ,root.right);
            return right; 
        }
        return null;
    }
}
}