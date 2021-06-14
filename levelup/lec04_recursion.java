package levelup;
import java.util.*;
public class lec04_recursion {

    public static void main(String[] args){
        int[] coins = {1,2,3};
    //  int count =    permutationInfiCoins(coins, 10, "");
    //int count =    combinationInfiCoins(coins, 10, "",0);
    // int count =     permutationSingleCoins(coins,0, 3, "");
    int count =     combinationSingleCoins(coins, 3, "",0);
  
        System.out.print(count);
    }
    // Permutation of Infinite coins to make target sum
    public static int permutationInfiCoins(int [] arr, int tar, String ans){
        if(tar == 0 ){
            System.out.println(ans);
        return 1;
        }else{
            int count = 0;
            for(int i  = 0; i< arr.length ; i++){
                if(tar-arr[i] >= 0)
                count += permutationInfiCoins(arr, tar- arr[i], ans+" "+arr[i]);

            }
            return count;
        }
    }    
    // cmbination of infinte coins to make target sum
    public static int combinationInfiCoins(int[] arr, int tar, String ans, int idx){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }else{
            int count = 0 ;
            for(int i = idx ; i< arr.length ; i++){
                if(tar - arr[i] >= 0)
                count += combinationInfiCoins(arr, tar- arr[i], ans+" "+arr[i], i);
            }
            return count;
        }
    }

    // THIS IS V V V V Important
    // Remember we use visited here to stop the current used coin from going to next call
     public static int permutationSingleCoins(int [] arr, int vis , int tar , String ans){
        if(tar == 0){
            System.out.println(ans);
            return 1;
        }else{

            int count = 0;
            for(int i = 0 ; i < arr.length ; i++){
                if( tar - arr[i] >=0 && (vis & (1 << i)) == 0){
                    vis^= (1 << i);
                    count +=  permutationSingleCoins(arr, vis ,tar - arr[i], ans + arr[i]);
                    vis^= (1 << i);
                }
            }
            return count;
        }
     }
     public static int combinationSingleCoins(int [] arr, int tar , String ans, int idx){
        if(tar ==  0){
            System.out.println(ans);
            return 1;
        }else{
            int count = 0;
            for(int i = idx ; i < arr.length; i++){
                if(tar - arr[i] >= 0)
                count +=  combinationSingleCoins(arr, tar - arr[i], ans + arr[i], idx+1);
            }
            return count;
        }
    }

}


