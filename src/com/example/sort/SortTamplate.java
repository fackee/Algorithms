package com.example.sort;
/**
 * 插入排序算法
 * */
public abstract class SortTamplate {
	public abstract void sort(Comparable a[]);
	
	public static  boolean less(Comparable v,Comparable w){
		return v.compareTo(w) < 0;
	}
	
	public  static void exchange(Comparable a[],int i,int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public  static void show(Comparable a[]){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+",");
		}
	} 
	
	public  static boolean isSort(Comparable a[]){
		for(int i=1;i<a.length;i++){
			if(less(a[i],a[i-1])){
				return false;
			}
		}
		return false;
	}

}
