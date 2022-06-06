package Array;

public class ReorderLogFiles {
    //Leetcode 937. Reorder Data in Log Files
    public String[] reorderLogFiles(String[] logs) {
        String[] ans = new String[logs.length];
        //we do not know how many digitLogs and letterLogs are in logs
        List<String> digitLogs = new LinkedList<String>();
        List<String> letterLogs = new LinkedList<String>();
        for(String log: logs){
            //adding log accordingly
            //split the log into two parts, the first part is identifier, the second part is log itself
            //since the digitLogs contains all digits, we can check the character at index 0 if is digit
            if(Character.isDigit(log.split(" ", 2)[1].charAt(0))){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }

        //sort letterLogs
        Collections.sort(letterLogs, (a, b) ->{
            //sort log itself first
            String s = a.substring(a.indexOf(' ')+1);
            String t = b.substring(b.indexOf(' ')+1);
            int res = s.compareTo(t);
            //if logs are same, then compare two logs including their identifier
            if (res == 0) {
                return a.compareTo(b);
            }
            return res;
        });

        //since the digitLogs maintain there relative order, we add the digitLogs after all existing letterLogs
        for(String digitLog: digitLogs){
            letterLogs.add(digitLog);
        }

        //Storing all elements into Array
        for(int i = 0; i < logs.length; i++){
            ans[i] = letterLogs.get(i);
        }
        return ans;
    }
}

/*
    Given an array of logs, each log where the first word is the identifier
    There are two types of logs:
    1. letterLogs: all words consist of lowercase English letters (except identifier)
    2. digitLogs: All words consist of digits (except the identifier)

    Reorder the logs that
    1. letterLogs before digitLogs
    2. Reorder letterLogs lexicographically, if same, then sort by their identifier
    3. digitLogs maintain there relative order.

    Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
    Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
    Explanation:
    The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
    The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
 */
