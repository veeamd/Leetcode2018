package com.weizhang;


/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 * Example 1:
 *
 * Input:
 * nums = [1, 7, 3, 6, 0, 0, 0, 6, -6, 0, 6, 5, 6]
 *
 * Output: 3
 *
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 *
 * Output: -1
 *
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 * Example 3:
 * Input:
 * nums = [-1,-1,-1,0,1,1]
 *
 * output: 0
 *
 *
 * Note:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        // get the sum
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }

        // starting from the left
        int left = 0;
        for (int p = 0; p < nums.length; p++) {
            if (p != 0) left += nums[p - 1];
            if (sum - left - nums[p] == left) return p;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex problem = new FindPivotIndex();
        int[] nums = {-1,-1,-1,0,1,1};
        int output = problem.pivotIndex(nums);
    }
}
