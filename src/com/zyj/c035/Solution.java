package com.zyj.c035;

class Solution {

    private int[] nums;
    private int target;

    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
//        return binarySearch();
        return binarySearchRecursion(0, nums.length - 1);
    }

    private int binarySearch() {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midValue = nums[mid];
            if (target < midValue) {
                hi = mid - 1;
            } else if (target > midValue) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    private int binarySearchRecursion(int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int midValue = nums[mid];
        if (target < midValue) {
            hi = mid - 1;
            return binarySearchRecursion(lo, mid - 1);
        } else if (target > midValue) {
            return binarySearchRecursion(mid + 1, hi);
        } else {
            return mid;
        }
    }
}

class BinarySearch {
    // Returns index of x if it is present in arr[l..
    // r], else return -1
    int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return l;
    }

    // Driver method to test above
    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 5, 8, 12, 16, 23, 38,56,72,91 };
        int n = arr.length;
//        int x = 23;
        int x = 1;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present:" + result);
        else
            System.out.println("Element found at index " + result);
    }
}