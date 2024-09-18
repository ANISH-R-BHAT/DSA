package Recursion.One;

public class SumOfDigitsUsingRecursion {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(1230));
    }

    static int sumOfDigits(int num){
        if(num==0)
            return 0;
        int rem=num%10;
        return rem+sumOfDigits(num/10);
    }
    //Time complexity: O(log(n)),
    //since no. of digits can be calculated using log(n) base b, hence that many times function calls are performed
}
