package TwoPointer;

public class ReversePrefix {
    public String reversePrefix(String word, char ch) {
        //Leetcode 2000

        //if character ch doesn't exist, return word
        if(!word.contains(String.valueOf(ch))){
            return word;
        }

        //find the index of character which we do reverse from 0 to reverseIndex
        int reverseIdx = word.indexOf(ch);
        char[] arr = word.toCharArray();
        char[] ans = new char[word.length()];
        //reverse the string from index 0 to reverseIndx of word
        for(int i = 0; i <= reverseIdx; i++){
            ans[i] = arr[reverseIdx-i];
        }
        //adding remaining character of word into the answer
        for (int i = reverseIdx + 1; i < word.length(); i++) {
            ans[i] = arr[i];
        }
        //return string
        return String.valueOf(ans);
    }

    //OR
    public String reversePrefix2(String word, char ch) {
        for(int i = 0; i < word.length(); i++) {
            //if word contains character
            if(word.charAt(i) == ch) {
                //reverse the substring from index 0 to the index of character
                //(i+1 since the substring(int start, int end) return from start to end-1 th character)
                String reversedString = reverse(word.substring(0, i+1));
                //return the reversed string + remaining character of word which start at i+1
                return reversedString + word.substring(i + 1);
            }
        }
        return word;
    }

    //reverse the string
    public static String reverse(String s){
        int left = 0, right = s.length() - 1;
        char[] letters = s.toCharArray();
        while(left < right) {
            char temp = letters[left];
            letters[left++] = letters[right];
            letters[right--] = temp;
        }
        return String.valueOf(letters);
    }
}


      // valueOf(char[] data) − Returns the string representation of the char array argument.


/*
    Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0
    and ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word, do nothing.

    For example, if word = "abcdefd" and ch = "d",
    then you should reverse the segment that starts at 0 and ends at 3 (inclusive).
    The resulting string will be "dcbaefd".
    Return the resulting string.
 */