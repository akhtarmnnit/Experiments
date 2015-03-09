public class Test {

	public static void main(String[] args) {
		// int arr[] = { 8, 9, 13, 14, 15, 19, 1, 2, 4, 6 };int n =
		// 10;//Testcase1
		// int arr[] = { 4, 6, 7, 9, 13, 16, 17, 19, 20, 32 };int n =
		// 10;//TestCase2
		// int arr[] = { 6 };int n = 1;// Array with 1 element
		// int arr[] = { 10, 9, 1, 2, 3, 4, 5, 6, 7, 8 };// First partition is
		// small
		// int n = 10;

		int arr[] = { 100, 90, 11, 22, 23, 24, 25, 26, 27, 28 };// key is not
																// there
		// small
		int n = 10;

		SearchInPartiallyOrderedArray ob = new SearchInPartiallyOrderedArray(
				arr, n);
		int key = 6;
		int foundAt = ob.searchKey(key);
		if (foundAt == -1) {
			System.out.println("Key not found");
		} else {
			System.out.println("found At:" + foundAt);
		}

	}
}
