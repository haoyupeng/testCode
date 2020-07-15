package com.hyp.suanfa;

/**
 * 快速排序：也叫轴排序，可以随机在数组里找一个数，或者最后一个当做轴，把小于轴的数，放到轴的左边，大于放到右边，然后递归左边和右边
 * 平均时间：n* log2n 画图，分层最好的情况下每次都是左右两边各半，最多log2n层，每层大约n次比较
 * 最差：n*n 轴最后在一遍，这样会要有n层
 * 空间复杂度：log2n
 * 稳定性：不稳定
 *
 * 改进：双轴
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8,9,0,1,2,3,7,5,6,7,4};//11个
        sort(arr, 0, arr.length-1);
    }

    private static void sort(int[] arr, int l, int r) {
        //最后一个当轴
        if(l == r) return;
        int pivot = arr[r];
        int ll = l;
        int rr = r - 1;
        while (ll < rr){

        }
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
