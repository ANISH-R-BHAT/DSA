package BinarySearch;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class RotatedSortedArrayBS {
    public static int search(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int pivot=0;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                pivot=mid;
                break;
            }
            else if(mid>start && nums[mid]<nums[mid-1]){
                pivot=mid-1;
                break;
            }
            else if(nums[start]>=nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        int position=BS(nums,target,0,pivot);
        if(position!=-1){
            return position;
        }
        position=BS(nums,target,pivot+1,nums.length-1);
        return position;
    }
    public static int BS(int[]arr,int target,int start,int end){
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if (arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(arr,target));
    }
}
