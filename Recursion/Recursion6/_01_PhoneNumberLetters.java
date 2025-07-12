package Recursion.Recursion6;

import java.util.ArrayList;
import java.util.List;

public class _01_PhoneNumberLetters {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return letterCombinations("",digits);
    }
    private List<String> letterCombinations(String p,String up){
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char[] letters=getLetters(up.charAt(0)-'0');
        List<String> list=new ArrayList<>();
        for(int i=0;i<letters.length;i++){
            list.addAll(letterCombinations(p+letters[i],up.substring(1)));
        }
        return list;
    }
    private static char[] getLetters(int n){
        if(n>=2 && n<=6){
            char[] c=new char[3];
            int p=3*(n-2);
            for(int i=0;i<3;i++){
                c[i]= (char) ('a'+p);
                p++;
            }
            return c;
        }
        if(n==7){
            char[] c=new char[4];
            int p=3*(n-2);
            for(int i=0;i<4;i++){
                c[i]= (char) ('a'+p);
                p++;
            }
            return c;
        }
        if(n==8){
            char[] c=new char[3];
            int p=19;
            for(int i=0;i<3;i++){
                c[i]= (char) ('a'+p);
                p++;
            }
            return c;
        }
        char[] c=new char[4];
        int p=22;
        for(int i=0;i<4;i++){
            c[i]= (char) ('a'+p);
            p++;
        }
        return c;
    }

    static char[][] letters={
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };
    public List<String> letterCombinations2(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<>();
        }
        return letterCombinations2("",digits);
    }
    private List<String> letterCombinations2(String p,String up){
        if(up.isEmpty()){
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<letters[up.charAt(0)-'0'].length;i++){
            list.addAll(letterCombinations2(p+letters[up.charAt(0)-'0'][i],up.substring(1)));
        }
        return list;
    }
}
