package Practise;

public class PractisePalindrom {

    public static void main(String[] args){
        String palin = "Never a foot too far,even.";
        String palin2 = "I am a fatty pig,o oinkkkkk";

        System.out.println("This phrase " +palin+ "is a Palindrome? " + isPalindrome(palin));
        System.out.println("This phrase " +palin2+ "is a Palindrome? " + isPalindrome(palin2));
    }
    private static boolean isPalindrome (String s){
        String check = s.toLowerCase().replaceAll("[^a-zA-Z]","");
        System.out.println("Check ="+check);
        for (int i=0; i<(check.length()-1)/2; i++){
            //System.out.println(i);
            if(check.charAt(i)!= check.charAt(check.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
