import java.util.*;

class Main {
    public static void main(String[] args)
    {
            System.out.println(mazePath_HVD(0,0,3,3));
    }
    public static ArrayList<String> mazePath_HVD(int sr, int sc , int er, int ec){
        if(sr==er && sc == ec){

        }else{
            mazePath_HVD(sr+1, sc, er,ec);
            mazePath_HVD(sr+1, sc+1, er,ec);
            mazePath_HVD(sr, sc+1, er,ec);
        }
    }
}