package BinarySearch;
/*Ceiling of a Number:
  Find the shortest number that is greater than or equal to target number
*/
public class Ceiling {
    public static void main(String[] args) {
        int[]arr={-22,3,9,45,333,456};
        System.out.println(CeilingOfNumber(arr,45));
    }
    public static int CeilingOfNumber(int[]arr,int target){
        if(target>arr[arr.length-1]){
            return -1;
        }
        int start=0,end=(arr.length-1),mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==target){
                return arr[mid]; //When target element is present in the given array
            }
            else if(arr[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        //Since the target element is not found,
        // the start pointer will be pointing to the next element greater than target element
        //whereas the end pointer will be pointing to the previous and the greatest element that is lesser than target element
        //since start moves ahead of end by 1, while loop breaks
        return arr[start];
    }
}
