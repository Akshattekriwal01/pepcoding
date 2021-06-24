import java.util.*;
public class lec06_recursion{

    public static void main(String args[]){
       // pairing("","ABDC");
        countGoodSubstrings("abcd");
    }
    public static int pairing(String psf,String str){
        if(0 == str.length()){
          System.out.println(psf);
          return 1;
        }else{
            int count = 0;
          String t = ""+str.charAt(0);
          count+=pairing(psf+"("+t+")",str.substring(1));
          for(int i = 1 ; i< str.length(); i++ ){
            String t1 = "("+t+str.charAt(i)+")";
            String remaining =  str.substring(1,i)+str.substring(i+1);
           count += pairing(psf+t1, remaining);
          }
          return count;
        }
       
    
      }
      public static int countGoodSubstrings(String s) {
        Integer[] arr= new Integer[3];
        for(int i = 0 ; i< arr.length ; i++){
            arr[i] = i ; 
        }
        // cannot custom sort PRIMITIVE array. 
        Arrays.sort(arr,(a,b)->{ return -1*(a-b);} );
        return 0;
    }
}

