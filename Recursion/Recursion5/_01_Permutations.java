package Recursion.Five;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        permutation("abc");
        System.out.println(permutationsCount("abc"));
    }

    static void permutation(String s){
        System.out.println(helper2("",s));
    }
    private static void helper(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String str=p.substring(0,i)+ch+p.substring(i,p.length());
            helper(str,up.substring(1));
        }

    }
    private static ArrayList<String> helper2(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String str=p.substring(0,i)+ch+p.substring(i,p.length());
            list.addAll(helper2(str,up.substring(1)));
        }
        return list;
    }

    /*
        The permutation count can be deduced using formula= n!, But this program is written to understand the recursive flow
        and the function calls of the program
    */
    static int permutationsCount(String s){
        return permutationsCount("",s);
    }
    private static int permutationsCount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        char c=up.charAt(0);
        int count=0;
        for(int i=0;i<=p.length();i++){
            String str=p.substring(0,i)+c+p.substring(i);
            count+=(permutationsCount(str,up.substring(1)));
        }
        return count;
    }
}
