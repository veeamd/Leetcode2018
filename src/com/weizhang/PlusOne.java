package com.weizhang;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */


public class PlusOne {

    public int[] plusOne(int[] digits) {
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 ; i--) {
            int current = digits[i];
            if (carry) {
                current++;
                if (current == 10) {
                    carry = true;
                    current -= 10;
                } else {
                    carry = false;
                }
            }
            digits[i] = current;
        }
        if (carry) {
            int[] output = new int[digits.length + 1];
            output[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                output[i + 1] = digits[i];
            }
            return output;
        } else {
            return digits;
        }
    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();
        int inputs[] = {0};
        int digits[] = solution.plusOne(inputs);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
        digits = solution.plusOne(digits);
    }

}
