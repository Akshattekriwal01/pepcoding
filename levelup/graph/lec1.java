import java.util.* ;
public class lec1{
   static int size  ;
    public static void main(String[] args){
    //    int[][] edges = {{1,2,2},{1,3,4},{2,3,3},{2,4,3},{1,5,3},{5,4,3}};
    int[][] edges = {{0,2,5},{0,1,2},{1,3,1},{3,2,4},{2,4,6},{4,6,3},{4,5,5},{5,6,2},{6,0,1}};
        size = 7 ; 
        ArrayList<Edge>[] graph = build(size, edges); 
        for(ArrayList<Edge> list : graph){
            System.out.println(list);
        }
        //System.out.println(hasPath(graph,1,4));
       // System.out.println(allPath(new boolean[size+1],graph,1,4,"1,"));
       ArrayList<String> ans  = new ArrayList<>() ;
       hamiltonianPathAndCycle(new boolean[size], graph , 0,0,0,"0", ans);
        System.out.println(ans);
    }
    public static boolean hasPath(ArrayList<Edge>[] graph, int a , int b){
        return  helper(new boolean[size+1],graph,a , b);
   
    }

  
    public static int allPath(boolean visited[] ,ArrayList<Edge>[] graph, int a , int b, String psf){
      visited[a] = true ;
        if(a == b) {
          System.out.println(psf);
          visited[a] = false ; 
          return 1 ; 
      }
          int count = 0 ; 
          for(Edge e: graph[a]){
              if(! visited[e.v]){
                String s =psf + e.v +"," ;
                count+= allPath(visited,graph,e.v ,b,s );
              }
          }
          visited[a] = false ;  
          return count ;
      
       
    }
    // helper for has path
    public static boolean helper(boolean vis[],ArrayList<Edge>[] graph, int a , int b){
        vis[a] = true ;
          if(a == b)return true;
              boolean ans = false ; 
              for(Edge e: graph[a]){
                  if(!vis[e.v]){
                  ans = ans || helper(vis,graph, e.v,b);
                  }
                  if(ans) return true ;
              }
              return false ;
          
   
    }
    public static class Edge{
        int v, w ;
        Edge(int v, int w ){
            this.v = v ;  
            this.w = w ;
        }
        public String toString(){
            return v + ","+ w ;
        }
    }
//asd
    public static ArrayList<Edge>[]  build( int size, int[][] edges){
         ArrayList<Edge>[] graph = new ArrayList[size];
        for(int i = 0 ; i < graph.length ; i++){
            graph[i]= new ArrayList<Edge>() ;
        }
        for(int[] arr : edges){
            graph[arr[0]].add(new Edge(arr[1],arr[2]));
            graph[arr[1]].add(new Edge(arr[0],arr[2]));
        }
        return graph ;
    }
    public static class pair {
        int heavyPath = 0;
        String psf = "";

        pair() {

        }

        pair(int heavyPath, String psf) {
            this.heavyPath = heavyPath;
            this.psf = psf;
        }
    }
   // public static pair heavyPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
       // return findHeavyPath(graph , src, dest, vis);
    //}
    // public static pair findHeavyPath(ArrayList<Edge>[] graph, int src, int dest , boolean [] visited){
    //     visited[src] = true ;
    //     if(src == dest){
    //         new Pair(dest, 0);
    //     }else{
    //         Pair p = new Pair() ;
    //         for(  Edge e : graph[src]){
    //             if(!visited[e.v]){
    //            Pair k = findHeavyPath(graph, e, dest , visited);
    //            if( (k.heavyPath + e.w ) > maxWeight  ){
    //                maxWeight = k.heavyPath + e.w ;
    //                psf = 
    //            }
    //         }
    //      }
    //     }
    //     visited[src] = false ;
    //     return new Pair() ;
    // }
    public static class pair2 {
        int length = 0;
        String psf = "";

        pair2() {

        }

        pair2(int length, String psf) {
            this.length = length;
            this.psf = psf;
        }
    }
    // return -1 if the path between the src and destination doesn exist. 
    public static pair2 longestPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        return new pair2();
    }
    public static boolean hasEdge(ArrayList<Edge>[] graph , int src , int dest){
        for(Edge e : graph[src]){
            if(e.v == dest){
                return true ;
            }
        }
        return false ;
    }
    // remeber in graph dfs, add src to psf before calling dfs . 
    public static void hamiltonianPathAndCycle(boolean vis[] , ArrayList<Edge>[] graph, int src, int orignalsrc, int edgeCount , String psf, ArrayList<String> ans){
        if( edgeCount == graph.length - 1 ){
          // this means there is a hamiltonian path. 
            boolean hasCycle = hasEdge(graph, src, orignalsrc);
          // if there is an edge  between curr src to orignalsrc means there is a hamiltoninan cycle. 
                if (hasCycle){
                    ans.add(psf+"*");
                }else{
                    ans.add(psf);
                }
        }
        vis[src] = true ; 
        for(Edge e : graph[src]){
            if(!vis[e.v]){ 
                hamiltonianPathAndCycle(vis, graph , e.v , orignalsrc, edgeCount + 1 , psf + e.v , ans);
            }
        }
        vis[src] = false ;
    }
}