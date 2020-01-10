import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1520 {

	static int N, M;
	static int map[][], dp[][];
	static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(DFS(0, 0));
		/*for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		//System.out.println(dp[N-1][M-1]);
	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static int DFS(int x, int y) {
		if(x==N-1&&y==M-1) {
			return 1;
		}
		if(visit[x][y]) {
			return dp[x][y];
		}
		for(int i = 0; i<4; i++) {
			int tx = x+dx[i];
			int ty = y+dy[i];
			if(tx<0||ty<0||tx>=N||ty>=M) continue;
			if(map[x][y]>map[tx][ty]) {
				dp[x][y]+=DFS(tx,ty);
				visit[tx][ty]=true;
			}
		}
		return dp[x][y];
	}

}
