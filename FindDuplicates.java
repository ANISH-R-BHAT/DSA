package CyclicSort;
/*
Find all Duplicates in an array
https://leetcode.com/problems/find-all-duplicates-in-an-array/description/
*/

import java.util.*;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        int i=0;
        int len=nums.length;
        while(i<len){
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
        for(i=0;i<len;i++){
            if(nums[i]!=i+1){
                list.add(nums[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums={4,3,2,7,8,2,3,1};
        int[] nums2={1,1,2};
        int[] nums3={1};
        System.out.println(findDuplicates(nums));
        System.out.println(findDuplicates(nums2));
        System.out.println(findDuplicates(nums3));
    }
}
