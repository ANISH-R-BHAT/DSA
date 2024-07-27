package BinarySearch;

import java.util.Arrays;

public class StartEndPosition2 {
    public static void main(String[] args) {

    }
    public static int[] searchRange(int[] nums,int target){
        int[] ans={-1,-1};
        ans[0]=BS(nums,target,true);
        ans[1]=BS(nums,target,false);
        return ans;
    }
    public static int BS(int[]arr,int target,boolean findStartIndex){
        int start =0,end=(arr.length-1),mid,ans=-1;
        while(start <=end){
            mid=(start +end)/2;
            if (arr[mid]==target){
                ans=mid;
                if(findStartIndex){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else if(arr[mid]<target)
                start =mid+1;
            else
                end=mid-1;
        }
        return ans;
    }
}
