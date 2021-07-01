import java.util.*; 
/**
 * worst case when burning the left most node. The right most node will take a lot of time.  
 */
class BurningTree{
  /**
   * learn Tree edge cases :node is not present in the tree,skewe 
   * 
   */
   public static void main(String[] args){
     Integer[] arr = {1,2,3,4,5,6,7,null,null,8,9,10,11,12,13,null,null,null,null,14,null,null,null,null,null,null,15};
    //Integer[] arr = {1,2,null,3,null,4}; SKEWD
    //Integer[] arr = {1,2};

    TreeNode root = builder(arr);
    burnTree(root,2);

    List<TreeNode> path = NodetoRootPath(root, 14); //! instead of returning null in case of empty list return null

   
   }
    // main function
   public static List<List<Integer>> burnTree(TreeNode root, int start){
       List<List<Integer>> ans= new ArrayList<List<Integer>>();
       //List<Tree
       List<TreeNode> path  = NodetoRootPath(root, start);
       for(int i = 0 ; i<path.size(); i++){
            burnTree(ans, i , path.get(i), i == 0 ? null : path.get(i-1));
       }
       System.out.println(ans);
       return ans;
   }
   public static void burnTree(List<List<Integer>> ans , int k , TreeNode root, TreeNode blocker){
       if(root == null || (blocker!=null && root.val == blocker.val) ){
        return ;
       }else{
        //! added an arraylist when adding the first node of a layer. beacuse container list does not exist for that layer. 
        if(ans.size() < (k+1) ){
            ans.add(new ArrayList<Integer>());          
        }
            ans.get(k).add(root.val);
        
        burnTree(ans,k+1,root.left,blocker);
        burnTree(ans,k+1,root.right,blocker);

       }
   }


   // returns a list containing path from target to root
   public static List<TreeNode> NodetoRootPath(TreeNode root, int target){
                if(root == null ){
                 return null;
                }       
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
