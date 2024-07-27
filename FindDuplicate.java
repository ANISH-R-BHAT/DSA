package CyclicSort;
/*
Find the Duplicate Number
https://leetcode.com/problems/find-the-duplicate-number/description/
*/
public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
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
        return nums[len-1];
    }

    public static void main(String[] args) {
        int[] nums={3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
