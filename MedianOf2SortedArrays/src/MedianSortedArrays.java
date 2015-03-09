public class MedianSortedArrays {
	public static void main(String args[]) {
		int A[] = { 1, 4, 5, 11, 13 };
		int B[] = { 2, 3, 6, 14, 15 };
		// int C[] = {1, 2, 3, 4, 5, 6,11, 13, 14, 15 };
		float median = getMedian(A, B, 5);

		System.out.println(median);

	}

	public static float getMedian(int A[], int B[], int n) {
		if (n == 0)
			return -1;
		else if (n == 1)
			return (A[0] + B[0] / 2);
		int k = 0;
		int i = 0;
		int j = 0;
		int first = 0, second = 0;
		for (k = 0; k < (n - 1); k++) {
			if (A[i] < B[j]) {
				first = A[i];
				i++;
			} else {
				first = B[j];
				j++;
			}
		}
		if ((i < n) && (j < n) && A[i] < B[j]) {
			second = A[i];
		} else if (i < n) {
			second = A[i];
		} else if (j < n) {
			second = B[j];
		} else {

		}
		return (float) (first + second) / (float) 2;
	}
}
