package TwoPointer;

import java.util.List;

public class LongestWordInDic {
    //Leetcode 524

    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for(String target: dictionary){
            int l1 = ans.length(), l2 = target.length();
            //we want the longest string in the dictionary
            //we want the smallest lexicographical order if there are more than one possible result
            if(l1 > l2 || (l1 == l2 && ans.compareTo(target) < 0)){
                continue;
            }
            //if we can get answer by deleting character, the target must be a subsequence of s
            if(isSubstr(s, target)){
                ans = target;
            }
        }
        return ans;
    }

    public boolean isSubstr(String s, String target){
        int j = 0;
        //two pointer goes here
        for (int i = 0; i < s.length() && j < target.length(); i++){
            //compare if target is a subsequence of the string s
            //if the character match, compare next character of target
            //if the character not match, move the index of s to next only
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
        }
        //j would be the length of target after finishing the comparison
        //because j++ if match even it is the end of the string
        return j == target.length();
    }
}

/*
    compareTo(): str1.compareTp(str2)
    return:
    An int value: 0 if the string is equal to the other string.
    < 0 if the string is lexicographically less than the other string
    > 0 if the string is lexicographically greater than the other string (more characters)
 */