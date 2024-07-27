package BinarySearch;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Even {
    public static long evenn(long x){
        String s=Long.toBinaryString(x);
        StringBuilder p=new StringBuilder(s);
        String q= String.valueOf(p.reverse());
        char[]c =q.toCharArray();
        for(int i=1;i<c.length;i+=2){
            if(c[i]=='1'){
                c[i]=0;
            }
        }
        String t=new String(c);
        long result=Integer.parseInt(t);
        return result;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        long x=sc.nextLong();
        System.out.println(x);
        long y=evenn(x);
        System.out.println(y);
    }
}
