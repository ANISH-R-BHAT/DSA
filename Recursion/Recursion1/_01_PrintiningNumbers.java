package Recursion.One;

public class PrintiningNumbers {
    public static void main(String[] args) {
        print1toN(5);
        System.out.println();
        printNto1(5);
    }

    static void printNto1(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" ");
        printNto1(n-1);
    }
    static void print1toN(int n){
        if(n==1){
            System.out.print(n+" ");
            return;
        }
        print1toN(n-1);
        System.out.print(n+" ");
    }
}
