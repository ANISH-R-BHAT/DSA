package BinarySearch;

import static java.lang.System.exit;

public class SearchInMountain {
    public static int peakIndexInMountainArray(int[] arr){
        int start=0,mid;
        int end=arr.length-1;
        while(start<end){
            mid=start+(end-start)/2;
            if(arr[mid]>arr[mid+1]){
                //you are in descending part of array, this might be the answer but look at the left
                //this is why end!=mid-1
                end=mid;
            }
            else{
                //you are in ascending part of array
                start=mid+1; //because we know that mid+1 element > mid element
            }

        }
        //in the end start=end and pointing to the largest number because of the 2 checks above
        //start and end always try to find max element in the above 2 checks
        //hence when they are pointing to the just same/one element that is the maximum one because that is what the checks say
        //more elaboration: at every point of time for start and end they have the best possible answer till that time,
        //and if are saying only one item is remaining , hence because of above line that is the best possible answer
        return start; //or return end since both are equal
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
    public static void main(String[] args) {
        int[] arr={0,1,2,4,2,1};
        int target=3;
        int start=0;
        int end=peakIndexInMountainArray(arr);
        int result=BS(arr,target,start,end);
        if(result!=-1){
            System.out.println("The element is present at position: "+result);
            exit(0);
        }
        start=end++;
        end=arr.length-1;
        result=BS(arr,target,start,end);
        System.out.println("The element is present at position: "+result);
    }
}
