package BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[]arr={-22,3,9,45,333,456};
        System.out.println(BS(arr,22));
    }
    public static int BS(int[]arr,int target){
        int start=0,end=(arr.length-1),mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if (arr[mid]==target)
                return mid;
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return -1;
    }
}
