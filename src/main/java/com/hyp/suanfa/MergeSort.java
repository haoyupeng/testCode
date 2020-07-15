package com.hyp.suanfa;

import java.util.Arrays;

/**
 * 二路归并排序，把一个数组分成两半，左边那半看成有序，右边看成有序，最后合并左右，递归的方式处理左边，右边
 * 时间复杂度：n*log2n:个数n的数组，分层，第一层被分成2个，第二层分成4个，直到最后一层无法在分成两瓣，一共有log2n层，每层会比较n次
 * 空间复杂度：n 额外空间存储合并后的结果
 * 稳定性：稳定
 */
public class MergeSort {
    public static void main(String[] args) {
//        Arrays.sort();
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};//11个
        sort(arr, 0, arr.length-1);
        print(arr);
    }

    private static void sort(int[] arr, int l, int r) {
        if(l == r) return;
        int m = l + (r-l)/2;
        sort(arr, l, m);
        sort(arr, m+1, r);
        merge(arr, l, m, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] temp = new int[r - l + 1];
        int tIndex = 0;
        int j = 0;
        int k = l;

        int rl = m+1;
        while (l<= m && rl <= r) temp[tIndex++] = arr[l] <= arr[rl]? arr[l++]:arr[rl++];
        while (l<=m) temp[tIndex++] =  arr[l++];
        while (rl<=r) temp[tIndex++] =  arr[rl++];
        while(k<=r) arr[k++] = temp[j++];
    }

    static void print( int[] arr){
        for(int k = 0; k<arr.length; k++){
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }
}
