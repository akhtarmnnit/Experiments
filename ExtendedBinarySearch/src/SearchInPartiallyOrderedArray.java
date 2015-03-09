public class SearchInPartiallyOrderedArray {
	int arr[];
	int size;

	SearchInPartiallyOrderedArray(int a[], int n) {
		arr = a;
		size = n;
	}

	public int searchKey(int key) {
		int foundIndex = 1;
		// Get the point where order differs
		int partitionIndex = modified_binary_search(arr, 0, size - 1);
		System.out.println("partitionIndex:" + partitionIndex);
		foundIndex = binary_search(arr, key, 0, partitionIndex);// search in
																// 1st
																// partition
		if (foundIndex == -1) {
			foundIndex = binary_search(arr, key, partitionIndex + 1, size - 1);// search
																				// in
																				// partition
		}

		return foundIndex;

	}

	private int binary_search(int A[], int key, int low, int high) {
		while (high >= low) {
			int mid = (low + high) / 2;
			if (A[mid] == key) {
				// key found at mid
				return mid;
			}
			// determine which subarray to search
			else if (A[mid] < key) {
				// search in 2nd subarray
				low = mid + 1;
			} else {
				// search in 1st subarray
				high = mid - 1;
			}
		}
		// key was not found
		return -1;
	}

	// the method returns the pivot element from where the numbers order changes
	private int modified_binary_search(int arr[], int low, int high) {
		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1]) {
			// the next number is smaller
			// than this number so we got the point of difference
			return mid;
		}
		if (mid > low && arr[mid] < arr[mid - 1]) {
			// This number is smaller than the previous number. So we got the
			// point of differnece
			return (mid - 1);
		}
		// If the neighbours of mid are all ok, search in the the 2 halfes
		if (arr[low] >= arr[mid])
			return modified_binary_search(arr, low, mid - 1);
		else
			return modified_binary_search(arr, mid + 1, high);
	}
}
