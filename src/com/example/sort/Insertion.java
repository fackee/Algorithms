package com.example.sort;
/**
 * 插入排序
 * */
public class Insertion extends SortTamplate{
	public void sort(Comparable a[]){
		
	}
	public static void sort(Comparable a[],int low,int high){
		long begin = System.currentTimeMillis();
		int N = a.length;
		for(int i= 0;i<N;i++){
			for(int j=i;j>0 && less(a[j],a[j-1]);j--){
				exchange(a,j,j-1);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("算法用时："+(end-begin));
	}

}
