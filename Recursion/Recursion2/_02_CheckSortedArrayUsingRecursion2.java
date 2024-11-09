package Recursion.Two;

public class CheckSortedArrayUsingRecursion2 {
    public static void main(String[] args) {
        int nums[] ={1,3,2,8,9};
        System.out.println(checkSorted(nums));
    }

    static boolean checkSorted(int[] nums){
        return helper(nums,0);
    }
    private static boolean helper(int[] nums,int p){
        if(p==nums.length-1)
            return true;
//        System.out.println(nums[p]);
        return nums[p]<=nums[p+1] && helper(nums,p+1); //better to use p+1 instead of ++p since p value gets modified in ++p
//        return helper(nums,p+1) && nums[p]<=nums[p+1]; This also can be used but it takes more time to solve since it first solves left part of end first(recursive part)
    }
}
