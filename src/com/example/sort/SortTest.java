package com.example.sort;

import java.util.Random;

public class SortTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortTamplate selection = new Selection();
		SortTamplate insertion = new Insertion();
		SortTamplate shellSort = new ShellSort();
		SortTamplate quickSort = new QuickSort();
		Merge merge = new Merge();
		Integer a[] = new Integer[101];
		Random r = new Random();
		for(int i=0;i<101;i++){
			a[i] = r.nextInt(110);
		}
		quickSort.sort(a);
		quickSort.show(a);
		//merge.sortBU(a);
		//merge.show(a);
		//shellSort.sort(a);
		//shellSort.show(a);
		//selection.sort(a);
		//selection.show(a);
		//insertion.sort(a);
		//insertion.show(a);
	}

}
