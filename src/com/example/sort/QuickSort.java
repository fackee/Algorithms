package com.example.sort;

public class QuickSort extends SortTamplate{
	private final static int M = 10; /*对于小数组使用插入排序比快速排序效率高*/
	@Override
	public void sort(Comparable[] a) {
		// TODO Auto-generated method stub
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable[] a,int low,int high){
		if(high <= low +M){
			Insertion.sort(a,low,high);
			return;
		}
		int j = partition(a,low,high);
		sort(a,low,j-1);
		sort(a,j+1,high);
		
	}
	private static int partition(Comparable[] a, int low, int high) {
		int i = low;
		int j = high+1;
		Comparable v = a[low];
		while(true){
			while(less(a[++i],v)){
				if(i == high){
					break;
				}
			}
			while(less(v,a[--j])){
				if(j==low){
					break;
				}
			}
			if(i>=j){
				break;
			}
			exchange(a,i,j);
		}
		exchange(a,low,j);
		return j;
	}

}
