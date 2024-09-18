package Recursion.One;

public class PalindromeCheckUsingRecursion {
    public static void main(String[] args) {
        System.out.println(palindrome(12321));
    }

    static boolean palindrome(int num){
        return helper(String.valueOf(num),0,String.valueOf(num).length()-1);
    }
    private static boolean helper(String n,int s,int e){
        if(s>=e){
            return true;
        }
        if(n.charAt(s)!=n.charAt(e)){
            return false;
        }
        return helper(n,s+1,e-1);
    }
}
