package Others;

public class MergeSort {

    //MergeSort in c#

    void sort(int[] arr, int l, int r)
    {
        if (l < r) {
            // Find the middle use this to avoid overflow
            int m = l+ (r-l)/2;

            // Sort first and second halves that divide array into the smallest pieces
            sort(arr, l, m);
            //middle number is include in first half, there for m+1
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    //array, 0(left most), middle, arr.length-1(rightmost)
    void merge(int[] arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];
        int i, j;

        // Copy data to temp arrays
        for (i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (j = 0; j < n2; ++j)
            //middle is include in first half so m+1
            R[j] = arr[m + 1 + j];

        // Initial indexes of first and second subarrays
        i = 0;
        j = 0;

        // Initial index of merge, and then merge subarray into the array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
