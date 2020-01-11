import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16988 {

	static class pos {
		int x;
		int y;

		public pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<pos> list;
	static int map[][];
	static boolean visit[][];
	static int N, M, ans, cnt;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					list.add(new pos(i, j));
				}
			}
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				pos p1 = list.get(i);
				pos p2 = list.get(j);
				map[p1.x][p1.y] = 1;
				map[p2.x][p2.y] = 1;
				int sum = 0;
				visit = new boolean[N][M];
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < M; l++) {
						if (map[k][l] == 2 && !visit[k][l]) {
							flag = true;
							visit[k][l] = true;
							cnt = 1;
							DFS(k, l);
							if (flag) {
								sum = sum + cnt;
							}
						}
					}
				}
				ans = Math.max(ans, sum);
				map[p1.x][p1.y] = 0;
				map[p2.x][p2.y] = 0;
			}
		}
		System.out.println(ans);
	}

	static boolean flag;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void DFS(int si, int sj) {
		for (int i = 0; i < 4; i++) {
			int tx = si + dx[i];
			int ty = sj + dy[i];
			if (tx >= 0 && tx < N && ty >= 0 && ty < M && !visit[tx][ty]&&map[tx][ty]!=1) {
				if (map[tx][ty]==2) cnt++;
				if (map[tx][ty]==0) flag=false;
				visit[tx][ty] = true;
				DFS(tx, ty);
			}
		}
	}
}
