package Recursion.One;

public class ProductOfDigitsUsingRecursion {
    public static void main(String[] args) {

    }
    static int productOfDigits(int num){
        if(num%10==num)
            return num;
        return num%10 * productOfDigits(num/10);
    }
    //Time complexity: O(log(n)),
    //since no. of digits can be calculated using log(n) base b, hence that many times function calls are performed
}
