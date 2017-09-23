package net.rayxiao;

/**
 * Created by Ray Xiao on 9/22/17.
 * LeetCode #29 /Medium
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public static void main(String[] args){
        System.out.println(DivideTwoIntegers.divide(132,3));
    }

    //132,3
    //3->6, power=1
    //6->12, power=2
    //12->24,power=3
    //24->48,power=4
    //48->96,power=5
    //192, fallback to 96, 132-96=36, result=0+2^5=32
    //32,3
    //3->6 power=1
    //6->12, power=2
    //12->24,power=3
    //24->48
    // fallback to 24, 36-24=12, result=32+2^3=40



    public static int divide(int dividend, int divisor) {
        int d= divisor;
        int power =0;
        int result =0;
        while (dividend>0){
            if (d<=dividend) {
                d = d << 1;
                power++;
            }else{
                dividend -= (d>>1);
                result +=Math.pow(2,power-1);
                d=divisor;
                power=0;
            }

        }
        return result;


    }
}
