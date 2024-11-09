package Recursion.Four;

public class SkipCharacter {
    public static void main(String[] args) {
        String s="Anish r bhat dshjdshdm s js kssjghs";
        String s2="an";
        System.out.println(skip(s,'s'));
    }
    static String skip(String s,char c){
        String ans="";
//        return helper(s,c,0,ans);
//        return helper2(s,c,0);
//        return helper3(s,c,ans);
        return helper4(s,c);
    }
    private static String helper(String s,char c,int p,String ans){
        if(s.length()==p)
            return ans;
        if(c!=s.charAt(p))
            ans+=s.charAt(p);
        return helper(s,c,p+1,ans);
    }

    private static String helper2(String s,char c,int p){
        if(s.length()==p)
            return "";
        String ans="";
        if(c!=s.charAt(p))
            ans+=s.charAt(p);
        return ans+helper2(s,c,p+1);
    }
    private static String helper3(String s,char c,String ans){
        if(s.isEmpty())
            return ans;
        if(s.charAt(0)!=c)
            ans+=s.charAt(0);
        return helper3(s.substring(1),c,ans);
    }
    private static String helper4(String s,char c){
        if(s.isEmpty())
            return "";
        String ans="";
        if(s.charAt(0)!=c)
            ans+=s.charAt(0);
        return ans+helper4(s.substring(1),c);
    }
}
