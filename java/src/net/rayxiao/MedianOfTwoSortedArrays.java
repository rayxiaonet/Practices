package net.rayxiao;

/**
 * Created by Ray Xiao on 9/21/17.
 * LeetCode #4/Hard
  https://leetcode.com/problems/median-of-two-sorted-arrays/
  There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


 */
public class MedianOfTwoSortedArrays {
    public static void main(String[] args){
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
        int[] a = {1,2,3,4,7,10,11,13,15};
        int[] b = {0,1,2,3};
        System.out.println(m.findMedian(a,b));
    }

    private double findMedian(int[] a, int[] b){
        int totalLength = a.length+b.length;
        if (1== totalLength % 2){
            //total length is even
            return findKth(a,0,b,0,totalLength/2+1);
        }else{
            return (findKth(a,0,b,0,totalLength/2)+findKth(a,0,b,0,totalLength/2+1))/2.0 ;
        }
    }
    //1,2,3,4,7
    //0,5,6,9, k=5
    // newK = 2, aFrom=0, bFrom=0

    //1,2,3,   4,5
    //0,5,6,9  k=2
    // newK = 1, aFrom=3, bFrom=0

    //1,2,3  4,5 k=1
    //0,   5,6,9
    // newK=1, afrom=3, bfrom=0



    private int findKth(int[] a,int aFrom, int [] b,int bFrom,int k){
        //like k=5, pick 5th from the whole list, we need pick 3 elements from a and b
        // k=4 , 2 elements from a/b
        // if k==1, just find the first element in a/b, which is the smaller one

        if (aFrom>=a.length){
            return b[bFrom+k-1-(bFrom-b.length)];
        }
        if (bFrom>=b.length){
            System.out.println(bFrom+":"+b.length);
            return a[aFrom+k-1-(bFrom-b.length)];
        }

        if (1==k){
            return Math.min(a[aFrom],b[bFrom]);
        }else {
            int newK = k/2;

            //exceed a's length , just trim b
            int valA = (aFrom+newK>=a.length)?Integer.MAX_VALUE:a[aFrom+newK];
            int valB = (bFrom+newK>=b.length)?Integer.MAX_VALUE:b[bFrom+newK];

            //this is the new kth element for next iteration  k=5, newK=2, need to remove 3 elements in this round
            if (valA>valB){
                return findKth(a,aFrom,b,bFrom+(k-newK),newK);
            }else if (valB>valA){
                return findKth(a,aFrom+(k-newK),b,bFrom,newK);
            }else {
                return valA;
            }

        }
    }

}
