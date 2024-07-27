package CyclicSort;
/*
Find the missing number
https://leetcode.com/problems/missing-number/description/
*/
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int i=0;
        int len=nums.length;
        while(i<(nums.length)){
            if(i==nums[i] || nums[i]==len){
                i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        for(i=0;i<len;i++){
            if(nums[i]!=i)
                return i;
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums={3,0,1};
        System.out.println(missingNumber(nums));
    }
}
