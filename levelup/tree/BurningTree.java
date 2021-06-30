import java.util.*; 

class BurningTree{
    private class TreeNode{
        TreeNode left = null ; 
        TreeNode right = null ;
        int val = null ; 

    }
   public static void main(String[] args){

   }
   /**
    *  find target node. then return the node to rooth path. 
        then move 
    */
    // main function
   public List<List<Integer>> burnTree(TreeNode root, int start){
       List<List<Integer>> ans= new ArrayList<List<Integer>>();
       //List<Tree
       List<TreeNode> path  = NodetoRootPath(root, start);
       for(int i = 0 ; i<path.size(); i++){
           //burnTree()
       }
       return ans;
   }
   public void burnTree(List<List<Integer>> ans , int k , TreeNode root){
       if(root == null ){
        return ;
       }else{
        if(ans.get(k) == null ){
            return 
        }
       }
   }


   // returns a list containing path from target to root
   public List<TreeNode> NodetoRootPath(TreeNode root, int target){
            if(root.val == target){
                List<TreeNode> al = new ArrayList<TreeNode>();
                al.add(root);
                return al ;
            }else{
              List<TreeNode> leftList =   NodetoRootPath(root.left, target);
              if(leftList != null ){
                leftList.add(root);
                  return leftList ; 
              }
              List<TreeNode> rightList = NodetoRootPath(root.right, target);
              if(rightList != null ){
                rightList.add(root);
                return rightList ; 
            }
               return null ; 
            }
   }
}