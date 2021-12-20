package TwoPointer;

public class ContainerWithMostWater {
    //Leetcode 11
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            //always find the max of max and area
            //area = width * min_height
            max = Math.max(max,(j-i)*Math.min(height[i], height[j]));
            //move the pointer with smaller height to try to get a higher height
            if(height[i] < height[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}
