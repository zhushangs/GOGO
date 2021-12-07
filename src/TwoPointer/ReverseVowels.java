package TwoPointer;

import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowels {
    //leetcode 345

    public String reverseVowels(String s) {
        if(s.length() == 0) return null;

        //create hashset to store vowels
        HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();

        int i = 0, j = chars.length-1;

        //compare the character from the left most and right most
        while(i < j){
            //if the character is not, move to next
            if(!set.contains(chars[i])){
                i++;
            }else if(!set.contains(chars[j])){
                j--;
            }else{
                //if the characters are vowels, change them
                char tmp = chars[i];
                chars[i++] = chars[j];
                chars[j--] = tmp;
            }
        }
        return new String(chars);
    }
}
