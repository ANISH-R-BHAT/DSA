package Recursion.Two;

public class RotatedBinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] arr={4,5,6,7,8,1,2,3};
        System.out.println(search(arr,3,0,arr.length-1));
    }

    static int search(int[] nums,int target,int start,int end){
        if(start>end){
            return -1;
        }
        int mid=start+(end-start)/2;
        if(nums[mid]==target){
            return mid;
        }
        if(nums[start]<=nums[mid]){
            if(target>=nums[start] && target<=nums[mid]){
                return search(nums,target,start,mid-1);
            }else{
                return search(nums,target,mid+1,end);
            }
        }
        if(target>=nums[mid] && target<=nums[end]){
            return search(nums,target,mid+1,end);
        }
        else{
            return search(nums,target,start,mid-1);
        }
    }
}
