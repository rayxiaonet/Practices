package net.rayxiao;

/**
 * LeetCode #177. Nth Highest Salary
 * https://leetcode.com/problems/nth-highest-salary/discuss/
 *
 * Use Quick Select
 */
public class NthHighestSalary {
    public static void main(String[] args){
        int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};

        for(int i = 0; i < array.length; i++) {
            System.out.println(selectRecursive(array, i));
        }

    }
    public static int selectRecursive(int[] array, int n) {
        return recursive(array, 0, array.length - 1, n);
    }

    private static int recursive(int[] array, int left, int right, int n) {
        if (left == right) { // If the list contains only one element,
            return array[left]; // return that element
        }

        // select a pivotIndex between left and right
        int pivotIndex = randomPivot(left, right);
        pivotIndex = partition(array, left, right, pivotIndex);
        // The pivot is in its final sorted position
        if (n == pivotIndex) {
            return array[n];
        } else if (n < pivotIndex) {
            return recursive(array, left, pivotIndex - 1, n);
        } else {
            return recursive(array, pivotIndex + 1, right, n);
        }
    }
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right); // move pivot to end
        int storeIndex = left;
        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex); // Move pivot to its final place
        return storeIndex;
    }

    private static int randomPivot(int left, int right) {
        return left + (int) Math.floor(Math.random() * (right - left + 1));
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
