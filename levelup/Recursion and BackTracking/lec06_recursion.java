import java.util.*;
public class lec06_recursion{

    public static void main(String args[]){
       // pairing("","ABDC");

       int[] arr = {1,2,3,4,5,6};
       kSubsetSum(arr,3);
      
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
      /**
       * The trick of this question is that if have to maintain sum of each set. 
       * IMP: avoid permutation- if n is the first number to choose a subset. dont let it go to another set, otherwise it will create permutation. 
       * @param arr
       * @param k
       * @return
       */
     public static  List<List<List<Integer>>>  kSubsetSum(int[] arr,int k){
        List<List<List<Integer>>> ans = new ArrayList<List<List<Integer>>>();
        List<List<Integer>> ksets = new ArrayList<List<Integer>>();
        for(int i = 0 ; i< k ; i++){
          ksets.add(new ArrayList<Integer>());
        }
        int[] ar = new int[k];
     
        helper(arr, k, ans, ar, 0, ksets);
        System.out.println(ans);
        return ans;
     } 
     public static void helper(int[] arr, int k , List<List<List<Integer>>> ans , int[] sum, int index, List<List<Integer>> ksets ){

        if(index == arr.length){
        
          for(int i = 1 ; i< k ; i++){
            // check if all the sums are the same;
            if(sum[i] == sum[i-1]){

            }else{
              return ;
            }
          }
          List<List<Integer>> temp = new ArrayList<List<Integer>>();
          for(List<Integer> l : ksets){  
            temp.add(new ArrayList<Integer>(l));
          }
          ans.add(temp); //! Deep copy of 2d array ;
          return ;
        }else{
          for(int i = 0 ; i< k; i++){
           ksets.get(i).add(arr[index]);
           sum[i]+=arr[index];
           helper(arr,k,ans, sum,index+1, ksets);
           ksets.get(i).remove(ksets.get(i).size() - 1);
           sum[i]-=arr[index];
           //!  this is important to remove arrangements/duplicay. Comment the below condition to see permutations. 
            if(ksets.get(i).size() == 0){
              break;
            }
          }
        }
     }
    
}

