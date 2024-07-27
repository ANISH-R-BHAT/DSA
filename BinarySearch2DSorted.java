package BinarySearch;

import java.util.Arrays;

public class BinarySearch2DSorted {
    public static int[] search(int[][] nums,int target){
        int rows=nums.length;
        int columns=nums[0].length;
        int midColumn=columns/2-1;
        if(rows==0){
            return BS(nums,target,0,0,columns-1);
        }
        int rowStart=0;
        int rowEnd=rows-1;
        while(rowStart<rowEnd-1){
            int mid=rowStart+(rowEnd-rowStart)/2;
            if(nums[mid][midColumn]==target){
                return new int[]{mid,midColumn};
            }
            else if(nums[mid][midColumn]<target){
                rowStart=mid;
            }
            else{
                rowEnd=mid;
            }
        }
        if(nums[rowStart][midColumn]==target){
            return new int[]{rowStart,midColumn};
        }
        else if(nums[rowStart][midColumn]>target){
            return BS(nums,target,rowStart,0,midColumn-1);
        }
        else if(nums[rowStart][midColumn]<target && nums[rowStart][columns-1]>target){
            return BS(nums,target,rowStart,midColumn+1,columns-1);
        }

        if(nums[rowStart+1][midColumn]==target){
            return new int[]{rowStart+1,midColumn};
        }
        else if(nums[rowStart+1][midColumn]>target){
            return BS(nums,target,rowStart+1,0,midColumn-1);
        }
        else if(nums[rowStart+1][midColumn]<target){
            return BS(nums,target,rowStart+1,midColumn+1,columns-1);
        }

        return new int[]{-1,-1};
    }
    public static int[] BS(int[][]nums,int target,int row,int cStart,int cEnd){
        int mid;
        while(cStart<=cEnd){
            mid=(cStart+cEnd)/2;
            if (nums[row][mid]==target)
                return new int[]{row,mid};
            else if(nums[row][mid]<target)
                cStart=mid+1;
            else
                cEnd=mid-1;
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[][] nums={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(Arrays.toString(search(nums,80)));
    }
}
