package CyclicSort;

import java.util.Arrays;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        int i=0;
        int len=nums.length;
        while(i<(nums.length)){
            if(i==nums[i] || nums[i]==nums[nums[i]-1]){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
        for(i=0;i<len;i++){
            if(nums[i]!=i+1)
                return new int[]{nums[i],i+1};
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] nums={1,2,2,4};
        int[] nums2={1,1};
        System.out.println(Arrays.toString(findErrorNums(nums)));
        System.out.println(Arrays.toString(findErrorNums(nums2)));
    }
}
