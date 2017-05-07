package com.example.sort;
/**
 * 选择排序算法
 * */
public class Selection extends SortTamplate{
	public  void sort(Comparable a[]){
		long begin = System.currentTimeMillis();
		int N = a.length;
		
		for(int i=0;i<N;i++){
			//最小数索引
			int min = i;
			//循环找出数组中最小的数的索引
			for(int j=i+1;j<N;j++){
				if(less(a[j],a[min])){
					min = j;
				}
			}
			//将最小数索引置于数组前面
			exchange(a,i,min);
		}
		long end = System.currentTimeMillis();
		System.out.println("算法用时："+(end-begin));
	}
}
