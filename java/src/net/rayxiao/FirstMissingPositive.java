package net.rayxiao;

/**
 * Created by Ray Xiao on 9/24/17.
 * LeetCode #41/Hard
 *https://leetcode.com/problems/first-missing-positive/description/
 *
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.


 1, partition the array, clear negative numbers
 2, swap each element k into array[k-1] location, keep looping
 3, if it's exceed, ignore that according to pigeonhole principle
 4, find the only element k that k!=array[k-1]
 */
public class FirstMissingPositive {
    public static void main(String[] args){
        int[] test= {3,4,-1,1};
        int[] test1= {3,4,-1,1,2,7,-5,-7,8,11};
        System.out.println(find(test1));
    }

    public static int  find(int[] nums){
        int[] input = partition(nums,1);

        for (int i=0;i<input.length;){
            if ((input[i]-1)!=i && input[i]!=0){
                swapOrDiscard(input,i,input[i]-1);
            }else {
                i++;
            }
        }
        for (int i=0;i<input.length;i++){
            if (input[i]==0){
                return i+1;
            }
        }
        return -1;


    }
    private static void swapOrDiscard(int[] input,int i,int j){
        final int temp = input[i];
        if (j<input.length) {
            input[i] = input[j];
            input[j] = temp;
        }else{
            input[i]=0;
        }
    }

    private static int[] partition(int[] input,int key){
        int j=input.length;
        for (int i=0;i<j;i++) {
            if (input[i]<key) {
                input[i]=input[--j];
            }
        }
        int[] result = new int[j];
        System.arraycopy(input,0,result,0,j);
        return result;
    }
}
