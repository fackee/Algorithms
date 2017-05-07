package com.example.sort;
/**
 * 归并排序
 * */
public class Merge extends SortTamplate{
	private static Comparable aux[];
	public static void merge(Comparable a[],int low,int mid,int high){
		int i = low;
		int j = mid+1;
		for(int k=low;k<=high;k++){
			aux[k] = a[k];
		}
		for(int k=low;k<=high;k++){
			if(i > mid){
				a[k] = aux[j++];
			}else if( j > high){
				a[k] = aux[i++];
			}else if(less(aux[j],aux[i])){
				a[k] = aux[j++];
			}else{
				a[k] = aux[i++]; 
			}
		}
	}
	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a,0,a.length-1);
	}
	public static void sort(Comparable a[],int low,int high){
		if(low >= high){
			return;
		}
		int mid = low + (high-low)/2;
		sort(a,low,mid);
		sort(a,mid+1,high);
		merge(a,low,mid,high);
	}
	public static void sortBU(Comparable a[]){
		int N = a.length;
		aux = new Comparable[a.length];
		for(int i = 1;i<N;i+=i){
			for(int low = 0;low<N-i;low+=i+i){
				merge(a,low,low+i-1,Math.min(low+i+i-1, N-1));
			}
		}
	}
}
