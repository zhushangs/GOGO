package TwoPointer;

public class TwoSum {
    // Leetcode 167 TwoSum II

    public int[] twoSum(int[] numbers, int target){
        if(numbers.length == 0) return null;
        //create two pointer, one from the beginning and one from the ending
        int i = 0, j = numbers.length - 1;

        //while the i is less than j
        while(i < j){
            //create sum
            int sum = numbers[i]+ numbers[j];
            //if sum is equal to target
            if(sum == target){
                //return the position of those 2 number
                return new int[]{i+1, j+1};
            }else if(sum < target){
                //make the smaller one bigger
                i++;
            }else{
                //make the bigger one smaller
                j--;
            }
        }
        return null;
    }
}

/*
     Question: Given an array, find the poistion of two number that their sum is equal to the target number
     Input: numbers=[2,7,11,15], target = 9
     Output: [1,2];
*/
