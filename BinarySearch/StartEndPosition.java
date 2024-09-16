package BinarySearch;

public class StartEndPosition {
    public static void main(String[] args) {
        int [] arr={5,7,7,8,8,10};
        searchRange(arr,10);
    }
    public static int[] searchRange(int[]nums,int target){
        int start=0,end=(nums.length-1),mid;
        while(start<=end){
            mid=(start+end)/2;
            if (nums[mid]==target){
                int start1=mid,end1=mid;
                while(nums[start1]==target){
                    start1--;
                    if(start1==-1)
                        break;
                }
                start1++;
                while(nums[end1]==target){
                    end1++;
                    if(end1==nums.length)
                        break;
                }
                end1--;
                System.out.println(start1+","+end1);
                return new int[]{start1,end1};
            }
            else if(nums[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return new int[]{-1,-1};
    }
}
