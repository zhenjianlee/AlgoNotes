package Practise;

public class PractiseString {
    public static void main(String[] args){
        String str = " Hello, how are you my dear friend!, how is everything going on ?  ";

        System.out.println(removeWhiteSpace(str));
    }

    private static String removeWhiteSpace(String s){
        return s.replaceAll(" ","");
    }
}
