import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6593 {
	static class posit {
		int z;
		int x;
		int y;

		public posit(int z, int x, int y) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;

		}
	}

	static int dist[][][];
	static char map[][][];
	static boolean visit[][][];
	static int ex, ey, ez, sx, sy, sz, L, R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0)
				break;
			map = new char[L][R][C];
			visit = new boolean[L][R][C];
			dist = new int[L][R][C];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					st = new StringTokenizer(br.readLine());
					String input = st.nextToken();
					for (int k = 0; k < C; k++) {
						map[i][j][k] = input.charAt(k);
						if (map[i][j][k] == 'S') {
							sz = i;
							sx = j;
							sy = k;
						}
						if (map[i][j][k] == 'E') {
							ez = i;
							ex = j;
							ey = k;
						}
					}
				}
				st = new StringTokenizer(br.readLine());
			}
			/*
			 * for(int i =0 ; i<L; i++) { for(int j = 0; j<R; j++) { for(int k = 0; k<C;
			 * k++) { System.out.print(map[i][j][k]); } System.out.println(); }
			 * System.out.println(); }
			 */

			BFS(sx, sy, sz);
			if(dist[ez][ex][ey]==0) {
				System.out.println("Trapped!");
			}else {
				System.out.printf("Escaped in %d minute(s).\n",dist[ez][ex][ey]);
			}
			
		}
	}

	static int dx[] = { 0, 0, 1, -1, 0, 0 };
	static int dy[] = { 1, -1, 0, 0, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	private static void BFS(int sx, int sy, int sz) {
		Queue<posit> q = new LinkedList<>();
		visit[sz][sx][sy] = true;

		q.add(new posit(sz, sx, sy));

		while (!q.isEmpty()) {
			posit p = q.poll();

			for (int i = 0; i < 6; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				int tz = p.z + dz[i];
				
				if(tz==ez&&tx==ex&&ty==ey) {
					dist[tz][tx][ty]=dist[p.z][p.x][p.y]+1;
					break;
				}
				if (tx < 0 || ty < 0 || tz < 0 || tx >= R || ty >= C || tz >= L || visit[tz][tx][ty]||map[tz][tx][ty]=='#')
					continue;
				
				visit[tz][tx][ty]=true;
				dist[tz][tx][ty]=dist[p.z][p.x][p.y]+1;
				
				q.add(new posit(tz,tx,ty));

			}
		}

	}

}
