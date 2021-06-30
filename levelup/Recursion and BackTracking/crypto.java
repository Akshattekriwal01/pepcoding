import java.util.HashSet;

public class crypto {
    public static void main(String[] args){

        crypto("send","more","money");
    }
    public static void crypto(String word1, String word2, String word3){
        char[] encoding = new char[10];
        String = generateSet(word1,word2,word3);
        helper(encoding,set,word1,word2,word3,0);
        for(int i = 0 ; i< 10 ; i++){
          System.out.print(", "+i+":"+encoding[i]);
        }
        
    }
    public boolean helper(char[] encoding, String set, String word1, String word2, String word3, int index){
        if(set.length() == 0){
            if(isEncodingCorrect(encoding,word1,word2,word3)){
                return true;
            }else return false;
        }else{
            for(int i = 0 ; i < set.length () ; i++ ){
                encoding[index] = set.charAt(i);
                String set1 = set.substring(0, i)+set.substring(i+1);
               boolean flag =  helper(encoding,set1,word1,word2,word3,index+1);
               if(flag){
                return true;
               }
            }
            return false;
        }
    }
    public String generateString(String word1, String word2, String word3,){
        char symbols[] = {'!','@','#','$','%','^'};
        HashSet<Character> set = new HashSet<>();
        String word = word1+word2+word3;
        for(char c : word.toCharArray()){
            set.add(c);
        }
        int i = 0 ;
        while(set.size < 10){
            set.add(symbols[i]);
            i++;
        }

        return set.toString();
    }
    public boolean isEncodingCorrect(char[] encoding, String word1, String word2, String word3){


        int w1 = 0 ;
        int w2 = 0 ;
        int w3 = 0 ;

        for(char c : word1.toCharArray()){
            w1 += (10*posOfChar(encoding,c));
        }
        for(char c : word2.toCharArray()){
            w2 += (10*posOfChar(encoding,c));
        }
        w3 = w1+w2 ;
        String result = decode(encoding, ""+w3);

    }
    public static String decode(char[] encoding, String w3){
        String result = "";
        
        for(char c : w3.toCharArray()){
            result += encoding[c - '0'];
        }
        return result;
    }

    public static int posOfChar(char[] encoding,char c){
        for(int i = 0 ; i< 10; i++){
            if(encoding[i]==c){
                return i;
            }
        }
        return 0;
    }
}
