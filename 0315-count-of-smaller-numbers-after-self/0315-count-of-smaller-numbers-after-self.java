import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        
        // Store pairs: arr[i][0] = value, arr[i][1] = original index
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        mergeSort(arr, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int[][] arr, int start, int end) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);

        merge(arr, start, mid, end);
    }

    private void merge(int[][] arr, int start, int mid, int end) {
        int[][] temp = new int[end - start + 1][2];
        int i = start;      // Pointer for left subarray
        int j = mid + 1;    // Pointer for right subarray
        int k = 0;          // Pointer for temp array
        int rightCount = 0; // Number of elements from right half that are smaller

        while (i <= mid && j <= end) {
            // If right element is smaller, it moves before left element
            if (arr[j][0] < arr[i][0]) {
                rightCount++;
                temp[k++] = arr[j++];
            } else {
                // Add rightCount to original index of left element
                count[arr[i][1]] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        // Process remaining left subarray elements
        while (i <= mid) {
            count[arr[i][1]] += rightCount;
            temp[k++] = arr[i++];
        }

        // Process remaining right subarray elements
        while (j <= end) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array segment
        System.arraycopy(temp, 0, arr, start, temp.length);
    }
}