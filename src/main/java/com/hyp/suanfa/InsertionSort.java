package com.hyp.suanfa;

/**
 * 就像扑克牌一样，来了一张牌，找到排序的位置，直接插入
 * 样本小，基本有序的时候，效率特别高
 *
 * 平时:n方
 * 最好时：n
 * 最坏：n方
 * 空：1
 * 稳：稳
 *
 * 改进：
 *
 * 抽方法可以整理思路，主逻辑会更清晰
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};//11个
        for (int i = 1; i<arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            for (;j>=0 && arr[j] > temp;j--){
                 arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
        print(arr);
    }

    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void print( int[] arr){
        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
