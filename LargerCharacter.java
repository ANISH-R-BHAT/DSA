package BinarySearch;
//  Find the Smallest Character that is larger than the target character
public class LargerCharacter {
    public static void main(String[] args) {
        char[] c={'A','a','b'};
        System.out.println(nextGreatestLetter(c,'b'));
    }
    public static char nextGreatestLetter(char[] letters, char target){
        int start=0, end =(letters.length-1),mid;
        while(start<= end){
            mid=start+(end-start)/2;
            if(letters[mid]>target)
                end =mid-1;
            else
                start=mid+1;
        }
        return letters[start%letters.length];

    }
}
