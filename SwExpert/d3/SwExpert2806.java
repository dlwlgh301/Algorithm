package d3;

import java.util.Arrays;
import java.util.Scanner;

public class SwExpert2806 { //nqueen
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		for (int tc = 1; tc <= k; tc++) {
			cnt=0;
			int N = sc.nextInt();
			int[] arr = new int[N];
			backTracking(arr, 0, N);
			System.out.printf("#%d %d\n",tc,cnt);
		}
	}
	static int cnt = 0;
	static void backTracking(int[] arr, int depth, int n) {
		if (depth == arr.length) {
			cnt++;
			return;
		}
		for (int i = 0; i < n; i++) {
			arr[depth] = i;
			if (isPromising(arr, depth)) {
				backTracking(arr, depth + 1, n);
			}
		}
	}
	static boolean isPromising(int[] arr, int depth) {
		boolean flag = true;
		for (int i = 0; i < depth; i++) {
			if (arr[i] == arr[depth]) {// 수직부분 검사
				flag = false;
				break;
			}
			if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {// 대각 역대각 검사
				flag = false;
				break;
			}
		}
		return flag;
	}
}
