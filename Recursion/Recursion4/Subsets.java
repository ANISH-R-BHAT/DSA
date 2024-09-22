package Recursion.Four;

import java.util.ArrayList;

public class Subsets {
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(getSubsetsUsingIteration(arr));
    }

    static ArrayList<ArrayList<Integer>> getSubsetsUsingIteration(int[] arr){
        ArrayList<ArrayList<Integer>> outerList=new ArrayList<>();

        outerList.add(new ArrayList<>());

        for(int num:arr){
            int n=outerList.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> innerList=new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }

        return outerList;
    }
}
