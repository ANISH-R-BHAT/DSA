package Recursion.Recursion6;

import java.util.ArrayList;

public class _02_Dice {
    public static void main(String[] args) {
        System.out.println(getDiceCombinations(5));
    }

    public static ArrayList<String> getDiceCombinations(int target){
        return getDiceCombinations(target,"");
    }
    private static ArrayList<String> getDiceCombinations(int target,String p){
        ArrayList<String> list=new ArrayList<>();
        if(target==0){
            list.add(p);
            return list;
        }
        else if(target<0){
            return list;
        }
        for(int i=1;i<=6;i++){
            list.addAll(getDiceCombinations(target-i,p+i));
        }
        return list;
    }
}
