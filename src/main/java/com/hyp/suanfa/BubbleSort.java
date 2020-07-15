package com.hyp.suanfa;

/**
 * 找到最大的放到最后位置
 * 平时:n方
 * 最好时：n
 * 最坏：n方
 * 空：1
 * 稳：稳
 *
 * 改进：已经有序一遍便利退出
 *
 * 抽方法可以整理思路，主逻辑会更清晰
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};//11个

        for(int i = arr.length - 1; i>0; i--){
            if(!bubbleMax(arr, i)){
                break;
            }
        }
        print(arr);
    }

    //如果没有交换过，已经有序退出循环
    static boolean bubbleMax(int[] arr, int end){
        boolean isSwap = false;
        for(int j = 0;j<end;j++){
            if(arr[j] > arr[j+1]){
                swap(arr, j,j+1);
                isSwap = true;
            }
        }
        return isSwap;
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
