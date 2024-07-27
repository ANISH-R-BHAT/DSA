package CyclicSort;

import java.util.Arrays;

public class CyclicSort {
    public static void sort(int[] nums){
        int i=0;
        while(i<(nums.length-1)){
            if(i==nums[i]-1){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[temp-1];
                nums[temp-1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={3,5,2,1,4};
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
