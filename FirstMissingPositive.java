package CyclicSort;
/*
First Missing Positive
https://leetcode.com/problems/first-missing-positive/description/
*/
public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        int len=nums.length;
        if(nums[0]==1 && len==1){   //this block is not necessarily required here
            return 2;
        }
        while(i<len){
            if(nums[i]<=0){
                i++;
                continue;
            }
            if(nums[i]<=len){
                if(nums[i]==i+1 || nums[i]==nums[nums[i]-1]){
                    i++;
                }
                else{
                    int temp=nums[i];
                    nums[i]=nums[temp-1];
                    nums[temp-1]=temp;
                }
            }
            else
                i++;


        }
        for(i=0;i<len;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] nums={1,2,0};
        int[] nums2={3,4,-1,1};
        int[] nums3={7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
        System.out.println(firstMissingPositive(nums2));
        System.out.println(firstMissingPositive(nums3));
    }
}
