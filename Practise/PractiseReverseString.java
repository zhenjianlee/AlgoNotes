package Practise;

public class PractiseReverseString {

    public static void main(String[] args){

        String word = "Hello how are you man?";

        System.out.println(reverse(word));
    }

    private static String reverse(String s){
        String out="";
        for(int i=0;i<s.length(); i++){
            out= s.charAt(i)+ out;
        }

        return out;
    }

}
