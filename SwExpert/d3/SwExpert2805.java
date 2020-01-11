package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert2805 {//농장물 수확하기
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());
		for (int tc = 1; tc <= test; tc++) {
			int N = Integer.parseInt(reader.readLine());
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
				String nums = tokenizer.nextToken();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(nums.substring(j, j + 1));
				}
			}
			sum = 0;
			DFS((N / 2), 0, N, 1, tc);
		}
	}
	static int sum;
	private static void DFS(int x, int y, int N, int cnt, int tc) {
		int tempx = x;
		if (y == N) {
			System.out.printf("#%d %d\n", tc, sum);
			return;
		}
		if (y < N / 2) {
			for (int i = 0; i < cnt; i++) {
				sum = sum + arr[y][x];
				x = x + 1;
			}
			x = tempx;
			DFS(x - 1, y + 1, N, cnt + 2, tc);
		} else {
			for (int i = 0; i < cnt; i++) {
				sum = sum + arr[y][x];
				x++;
			}
			x = tempx;
			DFS(x + 1, y + 1, N, cnt - 2, tc);
		}
	}
}
