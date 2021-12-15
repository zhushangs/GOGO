package Others;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
    //Leetcode 1286
    //reference https://leetcode.jp/leetcode-1286-iterator-for-combination-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
    int maxLength;
    Queue<String> list = new LinkedList<>();

    public CombinationIterator(String characters, int combinationLength) {
        maxLength = combinationLength;
        //Find subsets that have length of combinationLength
        helper(characters, 0, "");
    }

    public String next() {
        return list.poll();
    }

    public boolean hasNext() {
        return list.size() > 0;
    }

    void helper(String s, int index, String tmp){
        //if the length of tmp is equal to maxLength
        //add it to queue and exist
        if(tmp.length() == maxLength){
            list.offer(tmp);
            return;
        }
        //add next character into the tmp
        for(int i = index; i<s.length(); i++){
            helper(s, i+1, tmp+s.charAt(i));
        }
    }
}

    // In C#

    public class CombinationIterator2 {
        int maxLength;
        Queue<string> queue = new Queue<string>();

        public CombinationIterator2(string characters, int combinationLength) {
            maxLength = combinationLength;
            helper(characters, 0, "");
        }

        public string Next() {
            return queue.Dequeue();
        }

        public bool HasNext() {
            return queue.Count > 0;
        }

        void helper(String s, int index, String tmp){
            //if the length of tmp is equal to maxLength
            //add it to queue and exist
            if(tmp.Length == maxLength){
                queue.Enqueue(tmp);
                return;
            }
            //add next character into the tmp
            for(int i = index; i<s.Length; i++){
                helper(s, i+1, tmp+s[i]);
            }
        }
    }



/*
    CombinationIterator(string characters, int combinationLength) Initializes the object with a string characters of
    sorted distinct lowercase English letters and a number combinationLength as arguments.
    next() Returns the next combination of length combinationLength in lexicographical order.
    hasNext() Returns true if and only if there exists a next combination.

    Input
    ["CombinationIterator", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
    [["abc", 2], [], [], [], [], [], []]
    Output
    [null, "ab", true, "ac", true, "bc", false]

    Explanation
    CombinationIterator itr = new CombinationIterator("abc", 2);
    itr.next();    // return "ab"
    itr.hasNext(); // return True
    itr.next();    // return "ac"
    itr.hasNext(); // return True
    itr.next();    // return "bc"
    itr.hasNext(); // return False
 */