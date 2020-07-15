package com.hyp.suanfa;

/**
 * 选择排序，找到最小的数，跟第一个交换，接着找跟第二个交换
 * 平时:n方
 * 最好时：n方
 * 最坏：n方
 * 空：1
 * 稳：不稳
 *
 * 改进：一次找出最大最小值
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};
        for (int i = 0; i<arr.length - 1; i++){
            int minPosition = i;
            for(int j = i+1; j<arr.length; j++){
                minPosition = arr[minPosition] > arr[j] ? j:minPosition;
            }
            System.out.print("minPosition " + minPosition+" ： ");

            int t = arr[i];
            arr[i] = arr[minPosition];
            arr[minPosition] = t;

            for(int g = 0; g<arr.length; g++){
                System.out.print(arr[g] + " ");
            }
            System.out.println();
        }
    }
}
