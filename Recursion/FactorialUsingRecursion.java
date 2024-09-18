package Recursion.One;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        System.out.println(factorial(6));
        System.out.println(sumOf1toN(6));
        System.out.println(sumOf1toN2(6));
    }
    static int factorial(int n){
        if(n<=1){
            return 1;
        }
        return n*factorial(n-1);
    }
    static int sumOf1toN(int n){
        if(n<=1){
            return n;
        }
        return n+sumOf1toN(n-1);
    }
    static int sumOf1toN2(int n){
        return (n*(n+1)/2);
    }
}
