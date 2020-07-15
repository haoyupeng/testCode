package com.hyp.suanfa;

/**
 * 跟插入排序一个思想，但是有个gap参数，一次间隔排序后间隔上顺序有序，
 *
 * 平时:n的1.3次方
 * 最好时：n
 * 最坏：n方
 * 空：1
 * 稳：不稳
 *
 * 改进：间隔knuth算法，h=1,h=h*3+1
 *
 * 抽方法可以整理思路，主逻辑会更清晰
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};//11个
        int h = 1;
        while(h<= arr.length/3){
            h = h*3 + 1;
        }
        for (int gap = h; gap > 0; gap = (gap -1)/3){
            for (int i = gap; i<arr.length; i++){
                int temp = arr[i];
                int j = i - gap;
                for (;j>=0 && arr[j] > temp;j=j-gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = temp;
            }
        }
        print(arr);
    }

    static void print( int[] arr){
        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
