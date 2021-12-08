package TwoPointer;

public class MergeSortedArray {
    //Leetcode 88

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //storing two arrays so the total length should be m+n
        int idx = m + n - 1;
        //storing from end of the array
        int idx1 = m-1, idx2 = n-1;
        while(idx1 >= 0 && idx2 >= 0){
            if(nums1[idx1] > nums2[idx2]){
                nums1[idx--] = nums1[idx1--];
            }else{
                nums1[idx--] = nums2[idx2--];
            }
        }
        //combine only nums2 because if nums1 is bigger, nothing needs to be done in nums1, it remains the same
        //we combine nums2 into nums1
        while(idx2 >= 0){
            nums1[idx--] = nums2[idx2--];
        }
    }

    // OR same approach

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        while(n > 0){
            if(m > 0 && nums1[m-1] > nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
    }
}

/*
    Given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
    representing the number of elements in nums1 and nums2 respectively.

    Merge nums1 and nums2 into a single array sorted in non-decreasing order.

    Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    Output: [1,2,2,3,5,6]

    Input: nums1 = [1], m = 1, nums2 = [], n = 0
    Output: [1]
 */