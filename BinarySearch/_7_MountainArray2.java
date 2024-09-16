package BinarySearch;

public class MountainArray2 {
    //https:leetcode.com/problems/peak-index-in-a-mountain-array/description/
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
    public static void main(String[] args) {
        int[]arr={0,10,11,12,100,5,0};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
