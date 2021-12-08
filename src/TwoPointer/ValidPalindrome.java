package TwoPointer;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        if(s.length() == 0) return false;

        //since we are going to validate the palindrome, we compare the left most and right most
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            //if not the original string is not palindrome, try to delete(skip) one character
            if(s.charAt(i) != s.charAt(j)){
                //we can try either skip one from left most or right most
                //validate after removing that character to see if the string is palindrome or not
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j){
        while (i < j) {
            //if the string is not palindrome, then return false
            //don't forget to increase and decrease the index
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}

/*
    Given a string s, return true if the s can be palindrome after deleting at most one character from it.

    Input: s = "aba"
    Output: true

    Input: s = "abc"
    Output: false

 */