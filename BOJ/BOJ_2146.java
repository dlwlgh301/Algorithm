import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146 {
	static int map[][],dist[][];
	static boolean visit[][];
	static int N,label;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		label = 1;
		
		dist = new int[N][N];
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1&&!visit[i][j]) {
					map[i][j]=label;
					visit[i][j] = true;
					dfs(i, j);
					label++;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(map[i][j]!=0) {
					for(int k = 0; k<4; k++) {
						int tx = i+dx[k];
						int ty = j+dy[k];
						if(tx<0||ty<0||tx>=N||ty>=N) continue;
						if(map[tx][ty]==0) {
							visit = new boolean[N][N];
							dist = new int[N][N];
							bfs(i,j,map[i][j]);
						}
					}
				}
			}
		}
		System.out.println(ans);
		/*
		 * for(int i = 0; i<N; i++) { for(int j = 0; j<N;j++) {
		 * System.out.print(map[i][j]+" "); } System.out.println(); }
		 */
	}
	static int ans = Integer.MAX_VALUE;
	private static void bfs(int sx, int sy,int label){
		Queue<Integer> q = new LinkedList<>();
		q.add(sx);
		q.add(sy);
		visit[sx][sy]=true;
		while(!q.isEmpty()) {
			int px = q.poll();
			int py = q.poll();
			for(int i = 0; i<4 ; i++) {
				int tx = px+dx[i];
				int ty = py+dy[i];
				if(tx<0||ty<0||tx>=N||ty>=N||visit[tx][ty]||map[tx][ty]==label) continue;
				if(map[tx][ty]!=0&&map[tx][ty]!=label) {
					ans = Math.min(ans, dist[px][py]);
					return;
				}
				dist[tx][ty]=dist[px][py]+1;
				visit[tx][ty]=true;
				q.add(tx);
				q.add(ty);
				
			}
		}
	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void dfs(int si, int sj) {//라벨링
		for (int i = 0; i < 4; i++) {
			int tx = si + dx[i];
			int ty = sj + dy[i];
			if(tx<0||ty<0||tx>=N||ty>=N||visit[tx][ty]||map[tx][ty]==0) continue;
			visit[tx][ty]=true;
			map[tx][ty] = label;
			dfs(tx,ty);
			
		}
	}
}
