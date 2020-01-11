import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17825 {

	static int dice[];

	static int map[] = { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 13/* 21 */, 16,
			19, 22, 24, 28, 27, 26, 25/* 29 */, 30, 35, -1 };
	// 5번 인덱스(10) -> 21번 인덱스 (13) ~ 23번 인덱스 (19) -> 29번 인덱스 (25) ~ 31번 인덱스(35) ->
	// 20번 인덱스(40)
	// 10번 인덱스(20) -> 24번 인덱스 (22) ~ 25번 인덱스 (24) -> 29번 인덱스 (25) ~ 31번 인덱스(35) ->
	// 20번 인덱스(40)
	// 15번 인덱스(30) -> 26번 인덱스 (28) ~ 28번 인덱스 (26) -> 29번 인덱스 (25) ~ 31번 인덱스(35) ->
	// 20번 인덱스(40)
	static int route[][] = { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 }, { 6, 21 }, { 7, 7 }, { 8, 8 }, { 9, 9 },
			{ 10, 10 }, { 11, 24 }, { 12, 12 }, { 13, 13 }, { 14, 14 }, { 15, 15 }, { 16, 26 }, { 17, 17 }, { 18, 18 },
			{ 19, 19 }, { 20, 20 }, { -1, -1 }, { 22, 22 }, { 23, 23 }, { 29, 29 }, { 25, 25 }, { 29, 29 }, { 27, 27 },
			{ 28, 28 }, { 29, 29 }, { 30, 30 }, { 31, 31 }, { 20, 20 } };

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dice = new int[10];
		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}
		horse = new int[10];
		DFS(0);
		System.out.println(ans);
	}

	static int ans = Integer.MIN_VALUE;
	static int horse[];

	private static void DFS(int depth) {
		if (depth == 10) {
			// System.out.println(Arrays.toString(horse));
			int total = solve();
			ans = Math.max(total, ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			horse[depth] = i;
			DFS(depth + 1);
		}
	}

	private static int solve() {
		int sum = 0;
		int location[] = new int[4];
		boolean visit[] = new boolean[33];
		point: for (int i = 0; i < 10; i++) {
			int horse_num = horse[i];
			int next = location[horse_num];

			if (next == -1)
				continue;

			visit[next] = false;
			for (int j = 0; j < dice[i]; j++) {// 한칸씩 이동
				if (j == 0) {
					next = route[next][1];
				} else {
					next = route[next][0];
				}
				if (next == -1)
					continue point;
			}
			if (visit[next])
				return 0;

			location[horse_num] = next;
			visit[next] = true;
			sum += map[next];

		}
		return sum;

	}

}
