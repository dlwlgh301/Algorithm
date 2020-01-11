package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1244 {
	static int max;
	static int answer;
	static int arr[];

	public static void main(String[] args) throws Exception {//sw1244 최대상금
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String num = st.nextToken();
			int n = Integer.parseInt(st.nextToken());
			arr = new int[num.length()];
			for (int i = 0; i < num.length(); i++) {
				arr[i] = num.charAt(i) - '0';
			}
			answer=0;
			DFS(0, n);
			System.out.printf("#%d %d\n", tc, answer);
		}
	}

	private static void DFS(int depth, int n) {
		if (n == 0) {// 기저
			int mul = 1;
			int result = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				result += arr[i] * mul;
				mul *= 10;
			}
			answer = Math.max(answer, result);
			return;
		}
		for (int i =0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				swap(i, j, arr);
				DFS(depth, n - 1);
				swap(i, j, arr);
			}
		}
	}

	private static void swap(int i, int j, int[] arr) {
		int temp = 0;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
