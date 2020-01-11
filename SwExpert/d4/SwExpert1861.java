package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1861 {
	static int map[][];
	static int N;
	static boolean visit[][];
	static int cnt = 0;
	static int max = Integer.MIN_VALUE;
	static int save = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			save = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new boolean[N][N];
					visit[i][j] = true;
					cnt = 1;
					DFS(i, j, map[i][j]);
					if (cnt > max) {
						max = cnt;
						save = map[i][j];
					}
					if(cnt==max) {
						if(save>map[i][j]) {
							save=map[i][j];
						}
					}
				}
			}
			System.out.printf("#%d %d %d\n", tc, save, max);
		}

	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void DFS(int si, int sj, int value) {
		for (int i = 0; i < 4; i++) {
			int tx = si + dx[i];
			int ty = sj + dy[i];
			if (tx < 0 || tx >= N || ty < 0 || ty >= N || visit[tx][ty] || (map[tx][ty] - 1) != value)
				continue;
			cnt++;
			visit[tx][ty] = true;
			DFS(tx, ty, map[tx][ty]);
		}

	}

}
