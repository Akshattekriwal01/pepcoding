import java.util.* ;
public class lec1{
    public static void main(Stirng[] args){
       int[][] edges = {{1,2,2},{1,3,4},{2,3,3},{2,4,3},};
       int size = 4 ; 
        ArrayList<Edges> graph = build(size, edges); 
        System.out.println(hasPath(graph,1,4));

    }
    public static boolean hasPath(ArrayList<Edges> graph, int a , int b){
        
        if(a == b)return true;
        else{
            boolean ans = false ; 
            for(Edge e: graph[a]){
              ans = ans || hasPath(graph,a,b);
              if(ans) return true ;
            }
            return false ;
        }
    
    }
    public class Edge{
        int v, w ;
        Edge(int v, int w ){
            this.v = v ;  
            this.w = w ;
        }
    }
//asd
    public  static ArrayList<Edges>  build( int size, int[][] edges){
        ArrayList<Edges>[] graph = new ArrayList[size+1];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i]= new ArrayList<Edges>() ;
        }
        for(int[] arr : edges){
            graph[arr[0]].add(new Edge(arr[1],arr[2]));
            graph[arr[1]].add(new Edge(arr[0],arr[2]));
        }
    }
}