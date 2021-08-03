import java.util.*;
public class genericTree {
    public class Node {

        int data = 0;
        ArrayList<Node> children;

        Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public List<Node> rootToNode(Node root, int target){
        List<Node> ans  = new ArrayList<Node>();
        helper(ans, root, target);
        return ans ;
    }
    // Void TYPE
    public void helper(List<Node> psf , Node root, int target){
        if(root.data == target ){
            return ;
        }else{
            for(int i = 0 ; i < root.children.size() ; i++){
                psf.add(root.children.get(i));
                helper(psf,root.children.get(i) , target);
                psf.remove(root.children.size() -1 );
            }
        }
    }
    class Pair{
        int height ;
        int maxDia ;
        Pair(int a, int b){
         this.height = a ;
         this.maxDia = b ; 
        }
    }
     public Pair diameter(Node root){
        ArrayList<Integer> heights = new ArrayList<Integer>() ;
        int maxDia = 0 ;
        for( Node n : root.children){
            Pair p = diameter(n);
            heights.add(p.height);
            maxDia = Math.max(p.maxDia, maxDia);
        }
        Collections.sort(heights);
        int dia ;
        if(heights.size() > 1){
            dia = 2 + heights.get(0) + heights.get(1);
        }else if (heights.size() == 1) {
            dia = heights.get(1) + 1 ;
        }else {
            dia = 1 ;
        }
        maxDia = Math.max(maxDia, dia);
        int maxHeight = heights.size() == 0 ? 0 : 1 + heights.get(0);
        return new Pair( maxDia, maxHeight );
     }
}
