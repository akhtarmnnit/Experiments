public class KadaneCircular {

	public static void main(String args[]) {
		int[] arr = { 8, -2, -3, 9 };
		int val = maxConsSum2(arr);
		System.out.println("val:" + val);
	}

	public static int maxConsSum2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int soFar = 0;
		int max = 0;
		int totalSum = 0;
		for (Integer i : arr) {
			totalSum += i;
			// totalSum is used in next step
			soFar += i;
			soFar = Math.max(soFar, 0);
			max = Math.max(max, soFar);
		}
		int min = 0;
		// calculate the min subarray
		for (Integer i : arr) {
			soFar += i;
			soFar = Math.min(soFar, 0);
			min = Math.min(min, soFar);
		}
		return Math.max(max, totalSum - min);
	}

}
