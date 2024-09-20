package Recursion.Two;

public class CheckSortedArrayUsingRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,33,4,90};
        System.out.println(checkSorted(arr));
    }
    static boolean checkSorted(int[] nums){
        return helper(nums,0);
    }
    private static boolean helper(int[] nums,int p){
        if(p==nums.length-1)
            return true;
        if(nums[p]>nums[p+1])
            return false;
        return helper(nums,p+1); //better to use p+1 instead of ++p since p value gets modified in ++p
    }
}
