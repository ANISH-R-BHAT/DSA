package BinarySearch;
/*
  Find the next greatest character than the target in the sorted character array, characters wrap around
 */
public class LargerLetter {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        System.out.println(nextGreatestLetter(letters,'g'));
    }
    static char nextGreatestLetter(char[] letters, char target){
        int start=0,end=(letters.length-1),mid;
        while(start<=end){
            mid=start+(end-start)/2;
            if(letters[mid]<target)
                start=mid+1;
            else
                end=mid-1;
        }
        return letters[start%(letters.length)]; //mod is used to return the first element when the target element is >= largest element in the array
    }
}
