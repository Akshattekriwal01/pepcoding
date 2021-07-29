// this is just like diameter. find max from the left and then find max from the right ans add them.


class maxSumbten2leaves{
    public static void main(String[] args){

    }
    public static  class Pair{
        // Akshat you dont need to maintain left and right in the pair because left and right will be given by left and right node respectively. 
        int  sum ; // max from start - node to end - leaf
        int maxSum ; // max from leaf to leaf 
        Pair(int a  , int c){
            this.sum = a ;
            this.maxSum = c ; 
        }
    }
    
    public static int maxPathSum(TreeNode root) {
      // handle null
      return helper(root).maxSum ;
    }
    public static Pair helper(TreeNode root){
           if(root == null){
           return new Pair(Integer.MIN_VALUE, Integer.MIN_VALUE);
           }
           if(root.left == null && root.right == null){
            return new Pair( root.val,Integer.MIN_VALUE);
           }
       else{
           Pair left = helper (root.left);
           Pair right = helper (root.right); 
           int nodetoLeafMax = root.val + Math.max(left.sum,right.sum);
          int leafToLeafMax = Math.max(left.maxSum, Math.max(right.maxSum,left.sum + right.sum + root.val));  
       
           return new Pair(nodetoLeafMax,leafToLeafMax);
       }
       
    }
    
}