package levelup;
import java.util.*;
public class lec04_recursion {
 
    //tree diagram is more important than the code
    public static int coin_permutation_infinite(int[] coins , int[] tar){
       
       00
        return 0;
    }

    public static int coin_combination_infinite(int[] coins , int[] tar){
        return 0;
    }

    public static int coin_permutaion_single(int[] coins , int tar, String psf, HashSet<Integer> used){
        if (tar == 0){
            // print(ans);
        }else{
           
            for (int c : coins){
                if(!used.contains(c)){
                    HashSet<Integer> set = new HashSet<>(used) ;
                    set.add(c);
                     coin_permutaion_single(coins, tar-c, psf+c, set);
                    set.remove(c);
                }
            }

        }
    }
    public static int combinationInfiCoins_subs(int[] arr, int tar, int ind , String ans){
        if(tar == 0){
            return ans;
            return 1;
        }else {
                int count = 0;
            if (tar - arr[ind] >= 0){

                count+=  combinationInfiCoins_subs(arr, tar-arr[idx], ind, ans+arr[idx]);
                count += combinationInfiCoins_subs(arr, tar, ind+1, ans);
            }
        }
    }
    public static int permutationInfiCoins_subs(int[] arr, int tar, int ind , String ans){
        if(tar == 0){
            return ans;
            return 1;
        }else {
                int count = 0;
            if (tar - arr[ind] >= 0){

                count+=  combinationInfiCoins_subs(arr, tar-arr[idx], ind, ans+arr[idx]);
                count += combinationInfiCoins_subs(arr, tar, ind+1, ans);
            }
        }
    }
}
