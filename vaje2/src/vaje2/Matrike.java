package vaje2;

public class Matrike {
	
	public static void print_arr(double[] arr) {
		for (double x : arr) {
			System.out.print(x);
			System.out.print(" ");
		}
	}
	
	public static void izpisi(double[][] arr) {
		if (arr == null) {
			System.out.println("null matrix");
		} else {
			for (double[] a : arr) {
				if (a == null) {
					System.out.println("null row");
				} else {
					print_arr(a);
					System.out.println();
				}
			}
		}
	}
	
	public static boolean jeMatrika(double[][] arr) {
		if (arr == null) 
			return false;
		for (double[] a : arr) {
			if (a == null)
				return false;
			if (a.length != arr[0].length)
				return false;
		}
		return true;
	}
	
	public static double[][] T(double[][] arr) {
		if (!jeMatrika(arr))
			return null;
		
		double[][] res = new double[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				res[j][i] = arr[i][j];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		izpisi(new double[][] {
		        {1., 2., 3.},
		        {2., 1.}
		});
		System.out.println(
				jeMatrika(new double[][] {
					{1., 2., 3.},
					{2., 1.}
				}));
		izpisi(T(new double[][] {
					{1., 2., 3.},
					{2., 1., 2.}
				}));
	}

}
