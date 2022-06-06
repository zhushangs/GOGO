package Array;

public class MaximumUnits {
    //Leetcode 1710. Maximum Units on a Truck
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int ans = 0;

        //create array count to store how many boxes per unit
        //count[1] = 3 means unit 1 has 3 boxes
        int[] count = new int[1001];
        for(int[] box : boxTypes){
            count[box[1]] += box[0];
        }

        //from the large unit to smaller unit
        for(int i = 1000; i >= 0; i--){
            if(count[i] == 0) continue;
            //if the boxes of this unit is larger than truckSize
            //adding truckSize boxes this unit into answer
            if(count[i] > truckSize){
                ans += truckSize * i;
                break;
            }
            //when boxes of this unit is smaller than truckSize
            //reduce applied boxes from truckSize
            truckSize -= count[i];
            //adding units per box into answer
            ans += count[i] * i;
        }

        return ans;
    }
}

/*
    Given 2D array boxTypes where boxTypes[i] = [numberOfBoxes(i), numberOfUnitsPerBox(i)]:
    1. numberOfBoxes(i): number of boxes of type i.
    2. numberOfUnitsPerBoxi is the number of units in each box of the type i.
    Also given an integer truckSize, which is the maximum number of boxes that can be put on the truck

    Return the maximum total number of units that can be put on the truck(the number of boxes does not exceed truckSize.)

    Greedy Algorithm can be used in this problem




 */
