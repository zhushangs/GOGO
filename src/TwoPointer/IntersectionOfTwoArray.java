package TwoPointer;

public class IntersectionOfTwoArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();

        int i = 0, j = 0;
        //since the two array is sorted, compare those two array from beginning to the end
        //move to next index if the current value is less than the other one
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }

        //copy the value of arraylist to array
        int size = list.size();
        int[] ans = new int[size];
        for(int idx = 0; idx < size; idx++){
            ans[idx] = list.get(idx);
        }
        return ans;
    }
}

/*
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]
 */

/*
    ArrayList: dynamic size, it can resize when needed, and use size() to compute the size of arraylist
    Array: fixed length data structure, use length keyword
 */