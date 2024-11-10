package Recursion.Four;

import java.util.ArrayList;
import java.util.Arrays;

public class _06_SubsetsWithDuplicates {
    public static void main(String[] args) {
        int[] nums={2,1,2};
        System.out.println(getSubsets(nums));
    }

    static ArrayList<ArrayList<Integer>> getSubsets(int[] nums){
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        int start=0,end=0;
        for(int i=0;i<nums.length;i++){
            start=0;
            //if current and previous elements are equal
            if(i!=0 && nums[i]==nums[i-1]){
                start=end+1;
            }
            end=outer.size()-1;
            ArrayList<Integer> inner;
            //take separate variable n to store the size of initial outer list and then use it in the loop since outer list's size will be increased
            int n=outer.size();
            for(int j=start;j<n;j++){
                inner=new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;
    }
}
