package BinarySearch;

public class RotatedSortedArrayWithDuplicatesBS {
    public static boolean search(int[] nums,int target){
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
            if(nums[mid]==nums[start]&&nums[mid]==nums[end]){
                if(nums[start]>nums[start+1]){
                    pivot=start;
                    break;
                }
                start++;
                if(nums[end]<nums[end-1]){
                    pivot=end-1;
                    break;
                }
                end--;
            }
            else if(nums[start]<nums[mid]||nums[start]==nums[mid]&&nums[mid]>nums[end]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        int position=BS(nums,target,0,pivot);
        if(position!=-1){
            return true;
        }
        position=BS(nums,target,pivot+1,nums.length-1);
        if(position!=-1){
            return true;
        }
        return false;
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
        int[]arr={4,5,6,6,6,7,0,1,2};
        int target=90;
        System.out.println(search(arr,target));
    }
}
