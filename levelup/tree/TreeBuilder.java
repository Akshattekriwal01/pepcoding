import java.util.*;
public class TreeBuilder {

    public static void main(String[] args ) {
        Integer[] arr = {1,2,3,4,5,6,7,null,null,8,9,10,11,12,13,null,null,null,null,14,null,null,15};
        TreeNode root = builder(arr);
        test(root);
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
            if(arr[i] != null){
                TreeNode right = new TreeNode(arr[i]); 
                t.right = right;
                q.add(right);
               
            }
            ++i;
        }
        return tree;
    }
    // prints a tree in level order
    public static void test(TreeNode root){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>(); 
        if(root == null){
            System.out.println("nice try!");
        }
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size(); 
            List<Integer> al = new ArrayList<Integer>(); 
            for(int i = 0 ;  i< len ; i++){
                TreeNode t = q.poll();
               al.add(t.val);   
               if(t.left != null){
                   q.add(t.left);
               }    
               if(t.right != null ){
                   q.add(t.right);
               }
            }
            ans.add(al);

                
        }
        System.out.println(ans);
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