package BinarySearch;
import java.util.Scanner;
import java.util.ArrayList;

public class EvenConversion {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        String s=Long.toBinaryString(n);
        System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        System.out.println(sb);
        String s2="";
        char c;
        s2= String.valueOf(sb.charAt(0));
        for(int i=1;i<sb.length();i++){
            c=sb.charAt(i);
            if(i%2!=0){
                s2+=String.valueOf('0');
            }
            else{
                s2+=String.valueOf(c);
            }
        }
        StringBuilder sb2=new StringBuilder(s2);
        sb2.reverse();
        System.out.println(sb2);
        System.out.println(Integer.parseInt(String.valueOf(sb2),2));

    }
}
