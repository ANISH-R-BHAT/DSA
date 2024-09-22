package Recursion.Four;

public class SkipString {
    public static void main(String[] args) {
        String s="apple is grown in apple tree";
//        System.out.println(demo(s,"is"));
        System.out.println(skipPattern(s,"ap"));
    }

    static String skipPattern(String s,String p){
        String ans="";
        return helper(s,p,ans);
    }
    private static String helper(String s,String p,String ans){
        if(s.isEmpty())
            return ans;
        if(!s.startsWith(p)){
            ans+=s.charAt(0);
            return helper(s.substring(1),p,ans);
        }
        return helper(s.substring(p.length()),p,ans);
    }
    static String demo(String s,String p){
        String s2=s.replace(p,"");
        return s2;
    }
}
