package TwoPointer;

public class SumOfSquareNumbers {
    //Leetcode 633

    public boolean judgeSquareSum(int c){
        if(c < 0) return false;
        //declare long in order to avoid overflow
        //the max number is no bigger than the sqrt of c since we are looking for sum of 2 numbers' square
        long i = 0, j = (int) Math.sqrt(c);

        while(i <= j){
            //create sum to compare with c
            long sum = i*i + j*j;
            if(sum == c){
                return true;
            }else if(sum < c){
                i++;
            }else {
                j--;
            }
        }
        return false;
    }
}

/*
    Given a non-negative integer c, decide if there are two integers a and b such a^2 + b^2 = c
    Input:5
    Output: true

    Input: 18
    Output true

    Input:3
    Output:false

 */
