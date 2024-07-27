package BinarySearch;

import static java.lang.System.exit;

public class SearchInMountain2 {
    public static int findInMountainArray(int target,int[] arr){
        int start=0,mid;
        int end=arr.length-1;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end=mid;
            }
            else{
                start=mid+1; //because we know that mid+1 element > mid element
            }

        }
        int result=BS(arr,target,0,start);
        if(result!=-1)
            return result;
        result=BS(arr,target,start+1,arr.length-1);
        return result;
    }
    public static int BS(int[]arr,int target,int start,int end){
        int mid;
        while(start<=end){
            mid=(start+end)/2;
            if (arr[mid]==target)
                return mid;
            if(arr[0]<arr[arr.length-1]){
                if(arr[mid]<target)
                    start=mid+1;
                else if(arr[mid]>target)
                    end=mid-1;
            }
            else{
                if(arr[mid]>target)
                    start=mid+1;
                else if(arr[mid]<target)
                    end=mid-1;
            }

        }
        return -1;
    }
//    public static void main(String[] args) {
//        int[] arr={0,1,2,4,2,1};
//        int target=3;
//        int start=0;
//        int end=peakIndexInMountainArray(arr);
//        int result=BS(arr,target,start,end);
//        if(result!=-1){
//            System.out.println("The element is present at position: "+result);
//            exit(0);
//        }
//        start=end++;
//        end=arr.length-1;
//        result=BS(arr,target,start,end);
//        System.out.println("The element is present at position: "+result);
//    }
}
