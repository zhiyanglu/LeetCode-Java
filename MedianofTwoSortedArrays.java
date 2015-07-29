/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. 
 * Find the median of the two sorted arrays. The overall run time complexity 
 * should be O(log (m+n)).
 * @author Lu
 *
 */
public class MedianofTwoSortedArrays {
	public static void main(String[] args) {
		int[] a = {};
		int[] b = { 1000 };
		System.out.println(findMedianSortedArrays(a, b));
	}

	
	/**
	 * O(log(min(m,n))) solution
	 * binary search one array and calculate the half index in another array
	 * i = (imin + imax) / 2
	 * j = (m+n+1) / 2
	 * we need to satisfy B[j - 1] <= A[i] and A[i - 1] <= B[j]
	 *      considering edge values, we need to ensure:
	 *      (j == 0 or i == m or B[j - 1] <= A[i]) and 
	 *      (i == 0 or j == n or A[i - 1] <= B[j])
	 */
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int m = nums1.length;
		int n = nums2.length;
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}

//		if (m == 0 || n == 0) {
//			if (m == 0) {
//				if (n % 2 == 0)
//					return (nums2[n / 2] + nums2[n / 2 - 1]) / 2.0;
//				else
//					return nums2[n / 2];
//			} else {
//				if (m % 2 == 0)
//					return (nums1[m / 2] + nums1[m / 2 - 1]) / 2.0;
//				else
//					return nums1[m / 2];
//			}
//		}

		int imin = 0;
		int imax = m;

		while (imin <= imax) {
			int i = (imin + imax) / 2;
			int j = (m + n + 1) / 2 - i;

			if (j > 0 && i < m && nums2[j - 1] > nums1[i])
				imin = i + 1;
			else if (i > 0 && j < n && nums1[i - 1] > nums2[j])
				imax = i - 1;
			else {
				int num1, num2;
				if (i == 0)
					num1 = nums2[j - 1];
				else if (j == 0)
					num1 = nums1[i - 1];
				else
					num1 = Math.max(nums2[j - 1], nums1[i - 1]);

				if ((m + n) % 2 == 1)
					return num1;
				if (i == m) {
					num2 = nums2[j];
				} else if (j == n) {
					num2 = nums1[i];
				} else {
					num2 = Math.min(nums2[j], nums1[i]);
				}

				return (num1 + num2) / 2.0;

			}
		}

		return 0;
	}

}
