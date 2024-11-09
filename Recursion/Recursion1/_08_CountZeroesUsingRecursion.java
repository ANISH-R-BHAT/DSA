package Recursion.One;

public class CountZeroesUsingRecursion {
    public static void main(String[] args) {
        System.out.println(countZeroes(3098704));
        System.out.println(countZeroes2(124));
    }
    static int countZeroes(int n){
        return helper(n,0);
    }
    private static int helper(int n, int c){
        if(n==0)
            return c;
        if(n%10==0)
            return helper(n/10,c+1);
        else
            return helper(n/10,c);
    }

    private static int countZeroes2(int n){
        if(n!=0 && n%10==n)
            return 0;
        if(n==0)
            return 1;
        if(n%10==0){
            return 1+ countZeroes2(n/10);
        }
        else{
            return countZeroes2(n/10);
        }
    }
}
