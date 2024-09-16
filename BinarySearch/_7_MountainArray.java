package BinarySearch;

public class MountainArray {
    //https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
    public static int peakIndexInMountainArray(int[] arr){
        int start=0,mid;
        int end=arr.length-1;
        while(start<=end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                if(arr[mid]>arr[mid-1]){
                    return mid;
                }
                end=mid-1;
            }
            else if(arr[mid]>arr[mid-1]){
                if(arr[mid]>arr[mid+1]){
                    return mid;
                }
                start=mid+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]arr={0,10,11,12,100,5,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
