package com.example.sort;
/**
 * 希尔排序
 * */
public class ShellSort extends SortTamplate{
	public void sort(Comparable a[]){
		long begin = System.currentTimeMillis();
		int N = a.length;
		int h = 1;
		while(h<N/3){
			h = h*3 + 1;
		}
		while(h >= 1){
			for(int i = h;i<N ;i++){
				for(int j=i;j>=h && less(a[j],a[j-h]);j=j-h){
					exchange(a,j,j-h);
				}
			}
			h = h/3;
		}
		long end = System.currentTimeMillis();
		System.out.println("算法用时："+(end-begin));
	}

}
