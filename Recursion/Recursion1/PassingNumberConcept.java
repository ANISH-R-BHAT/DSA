package Recursion.One;

public class PassingNumberConcept {
    public static void main(String[] args) {
        print(2);
    }
    static void print(int n){
        if(n==0)
            return;
        System.out.println(n);
        print(--n);
        /*
         print(n--); If we use n--, it will be infinite recursion
        */

    }
}
