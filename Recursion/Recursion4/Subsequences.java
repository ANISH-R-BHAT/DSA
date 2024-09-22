package Recursion.Four;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        String s="abc";
//        getSubsets(s,"");
//        ArrayList<String> list=new ArrayList<>();
//        System.out.println(getSubsequences(s,"",list));
//        System.out.println(getSubsequences2(s,""));
        System.out.println(getSubsequencesWithAscii(s,""));
    }

    static void getSubsets(String s,String ans){
        if(s.isEmpty()){
            System.out.println(ans);
            return;
        }
        char c=s.charAt(0);
        getSubsets(s.substring(1),ans+c);
        getSubsets(s.substring(1),ans);
    }

    static ArrayList<String> getSubsequences(String s, String ans, ArrayList<String> list){
        if(s.isEmpty()){
            list.add(ans);
            return list;
        }
        char c=s.charAt(0);
        getSubsequences(s.substring(1),ans+c,list);
        return getSubsequences(s.substring(1),ans,list);
    }

    static ArrayList<String> getSubsequences2(String s,String ans){
        if(s.isEmpty()){
            ArrayList<String> list=new ArrayList<String>();
            list.add(ans);
            return list;
        }
        char c=s.charAt(0);
        ArrayList<String> list=new ArrayList<String>();
        list.addAll(getSubsequences2(s.substring(1),ans+c));
        list.addAll(getSubsequences2(s.substring(1),ans));
        return list;
    }

    static ArrayList<String> getSubsequencesWithAscii(String s,String ans){
        if(s.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(ans);
            return list;
        }
        char c=s.charAt(0);
        int ascii=c;
        ArrayList<String> list=getSubsequencesWithAscii(s.substring(1),ans+" "+c+" "+ascii);
        list.addAll(getSubsequencesWithAscii(s.substring(1),ans));
        return list;
    }
}
