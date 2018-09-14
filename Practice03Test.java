import java.util.Random;
import java.util.Arrays;


public class Practice03Test {

	protected int count = 0;
	protected double [] arr;


	/**
	 * Constructor
	 */
	public Practice03Test (String [] args) {
		try {
			count = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.out.println("Defaulting array size to 20.");
			count = 20;
		}
		arr = new double[count];
		generate_array();
	}


	/**
	 * print_array: prints the array of doubles... formatted so it fits
	 * ... on many small screens.
	 */
	public void print_array() {
		System.out.println("------------------------------------");
		System.out.println("Array contains the values:");
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%.2f ", arr[i]);
			if (i > 0 && i % 9 == 0)
				System.out.println();
		}
		System.out.println("\n------------------------------------");
	}


	/**
	 * Fills the array with random double instances.
	 */
	public void generate_array() {
		Random rand = new Random();
		double min = 1.0;
		double max = 100.0;

		for (int i = 0; i < arr.length; i++) {
			arr[i] = min + rand.nextDouble() * (max-min);
		}
	}


	public int find_min_iterative (double[] arr) {
		int min = 0; // Initialize minimum as the first element.
		for (int i = 0; i<arr.length; i++) { // Traverse through array seeing if there are smaller elements than initial minimum.
			if (arr[min] > arr[i]) { // If current minimum is smaller than another element, set the element as the minimum.
				min = i;
			}
		}
		return min;
	}


	public int find_min_recursive (double[] arr) {
		if (arr.length == 1) { // Base case: return the first index if array has only one element.
			return 0;
		}
		if (arr[0] < arr[arr.length - 1]) { // Traversing array from right comparing to left.
			return find_min_iterative(Arrays.copyOfRange(arr, 0, arr.length-1));
		} else { // Traversing array from left comparing right.
			return 1 + find_min_iterative(Arrays.copyOfRange(arr, 1, arr.length));
		}
	}


	/**
	 * print_min: determines the min iteratively and recursively.
	 * ... and prints them both.
	 */
	public void print_min() {
		System.out.println("Iteratively determined min at index " + find_min_iterative(arr));
		System.out.println("Recursively determined min at index " + find_min_recursive(arr));
	}


	/**
	 * main for Practice 03: print the array and determine the min.
	 */
	public static void main(String [] args) {
		Practice03Test test = new Practice03Test(args);
		test.print_array();
		test.print_min();
	}

}
