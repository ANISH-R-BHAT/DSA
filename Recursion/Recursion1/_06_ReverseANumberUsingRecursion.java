package Recursion.One;

public class ReverseANumberUsingRecursion {
    public static void main(String[] args) {
        System.out.println(reverseNumber(1234,0));
        System.out.println(reverseNumber2(1234));
    }

    static int reverseNumber(int num,int sum){
        if(num==0)
            return sum;
        sum=sum*10+ num%10;
        return reverseNumber(num/10,sum);
    }
    //Time complexity: O(log(n)),
    //since no. of digits can be calculated using log(n) base b, hence that many times function calls are performed

    static int reverseNumber2(int num){
        int base=(int)Math.log10(num)+1;
        return helper(num,base);
    }
    private static int helper(int num,int base){
        if(num==0)
            return 0;
        return (num%10)*(int)Math.pow(10,base-1)+helper(num/10,base-1);
    }
    //Time complexity: O(log(n)),
    //since no. of digits can be calculated using log(n) base b, hence that many times function calls are performed
}
