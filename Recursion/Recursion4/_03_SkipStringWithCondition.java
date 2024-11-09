package Recursion.Four;

public class SkipStringWithCondition {
    public static void main(String[] args) {
        String s="Anish is a cs student";
        System.out.println(skipPattern(s,"is","ish"));
    }

    static String skipPattern(String s,String p,String p2){
        String ans="";
        return helper(s,p,p2,ans);
    }
    private static String helper(String s,String p,String p2,String ans){
        if(s.isEmpty())
            return ans;
        if(s.startsWith(p) && !s.startsWith(p2)){
            return helper(s.substring(p.length()),p,p2,ans);
        }
        ans+=s.charAt(0);
        return helper(s.substring(1),p,p2,ans);

    }
}
