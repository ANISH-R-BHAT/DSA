package CyclicSort;
/*
Find all numbers disappeared in an array
https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
*/

import java.util.*;
public class MissingNumbers {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i=0;
        int n=nums.length;
        //ensure that last element is also checked since there are duplicate elements,
        // last element need not be placed in its correct position, hence traverse till nums.length-1
        while(i<(nums.length)){
            if(i==nums[i]-1 || nums[i]==nums[nums[i]-1]){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        List<Integer> list=new ArrayList<Integer>();
        for(i=0;i<n;i++){
            if(nums[i]!=i+1)
                list.add(i+1);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={1,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
