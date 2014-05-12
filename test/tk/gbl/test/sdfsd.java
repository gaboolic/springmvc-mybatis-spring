package tk.gbl.test;

public class sdfsd {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 7, 9, 190, 333, 2, 2444 };
		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for(int i=0;i<a.length;i++)
		System.out.println(a[i]);
	}

}

/*
 * #include <stdio.h> #include <stdlib.h> int main(){ int a[1000]; int i; int j;
 * int temp; for(i=0;i<1000;i++){ a[i] = rand(); }
 * 
 * for(i=0;i<1000;i++) for(j=0;j<i;j++){ if(a[i]<a[j]){ temp = a[i]; a[i] =
 * a[j]; a[j] = temp; } } return 0; }
 */