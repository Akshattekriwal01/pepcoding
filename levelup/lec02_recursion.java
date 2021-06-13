import java.util.*;

class Main {
    public static void main(String[] args)
    {
            System.out.println(mazePath_HVD(0,0,3,3));

            ArrayList<String> al = new ArrayList<String> ();
            int total_number_of_leaves = mazePath_HVD(0, 0, 3, 3, al, ""); // returns total number of paths for a 4x4 matrix.
            System.out.println(al);
            System.out.println(total_number_of_leaves);


            
    }

    // return type of recursion or backtracking.
    public static ArrayList<String> mazePath_HVD(int sr, int sc , int er, int ec){
        // if(sr==er && sc == ec){
        //         ArrayList<String> al = new ArrayList<String>();
        //         al.add("");
        //         return al;
        // }else{
            
        //    ArrayList<String> temp = new ArrayList<String>();

        //    mazePath_HVD(sr+1, sc, er,ec);
        //    mazePath_HVD(sr+1, sc+1, er,ec);
        //    mazePath_HVD(sr, sc+1, er,ec);
        //    return 
        // }
    }

    // void type of recursion. Easier to code. 
    public static int mazePath_HVD( int sr, int sc, int er, int ec, ArrayList<String> ans , String sofar){
        if(sr == sc && sr == er){
            ans.add(sofar);
            return 1;  // count the number of leaves in a generic tree.
        }else{
            int count  = 0;
            count += mazePath_HVD(sr+1, sc, er,ec , ans,sofar +"H");
           count += mazePath_HVD(sr+1, sc+1, er,ec, ans, sofar +"D");
           count += mazePath_HVD(sr, sc+1, er,ec, ans, sofar +"V");
            return count ;
        }
    }
    // void type of recursion easier to code. 
    public static int mazePath_MVD_multi(int sr, int sc, int er, int ec, ArrayList<String> ans, String sofar){
        if(sr > er || sc > ec){
            return 0;
        }
        else if(sr == er &&  sc == ec){
            ans.add(sofar);
            return 1;
        }else{
            int count = 0 ;
            int n = Math.max(sr-er,sc-ec);
            for(int i = 1 ; i <= n ; i++){
            count += mazePath_HVD(sr+i, sc, er,ec , ans,sofar +"H"+i);
            count += mazePath_HVD(sr+i, sc+i, er,ec, ans, sofar +"D"+i);
            count += mazePath_HVD(sr, sc+i, er,ec, ans, sofar +"V"+i);      
            }
        }
    }

    public static int equiset(int[] arr){
        long sum =0;
        for(int x : arr){
            sum += x;
        }
        equisetHelper(arr,0,sum);
    }
    public static void equisetHelper(int[] arr , int ind , int sum,ArrayList<Integer> al ){
            if(sum == 0){
               // print
            }else{
                ArrayList<Integer>  al1 = new ArrayList<Integer>(al);
                al1.add(arr[ind]);
                equisetHelper(arr, ind+1 , sum - arr[ind], al1);
                al1.remove(al1.size()-1);
                equisetHelper(arr, ind+1,  sum ,al );
            }
    }
    // https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans = new ArrayList<String>();
        int[][] visited = m; 
        if(visited[0][0] == 0 || visited[n-1][n-1] == 0 )
        return ans;
        // DlRU
        int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
        String[] dirs = {"D","L","R","U"};
        floodfill("", visited, ans, dir, dirs, 0, 0, n-1, n-1 );
        return ans;
    }
    
    public static int floodfill(String psf, int[][] visited, ArrayList<String> ans , int[][] dir, String[] dirs,
    int sr, int sc, int dr, int dc){
      
        if(sr == dr && sc == dc){
            ans.add(psf);
            return 1;
        }else{
            visited[sr][sc] = 0;
            int count =0;
            for(int i = 0 ; i< dir.length ; i++){
                int x = sr +  dir[i][0];
                int y = sc + dir[i][1];
                
                if(x <= dr && y <= dc && x >=0 && y>=0 && visited[x][y] != 0){
                   count += floodfill(psf+dirs[i] , visited, ans, dir,dirs,x, y , dr, dc );
                }
                
            }
              visited[sr][sc] = 1;
              return count;
            
            
        }
        
        
        
    }
}