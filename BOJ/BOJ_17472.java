import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_17472 {
	static class posit {
		int x;
		int y;

		public posit(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class edge implements Comparable<edge> {
		int s;
		int e;
		int w;

		public edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		@Override
		public int compareTo(edge o) {
			// return this.weight - o.weight;
			return this.w > o.w ? 1 : -1;
		}

	}

	static int N, M, map[][], graph[][];
	static boolean visit[][];
	static final int INF = 999999;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int iNum = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					bfs(i, j, iNum++);
				}
			}
		}
		/*
		 * System.out.println(); for (int i = 0; i < N; i++) { for (int j = 0; j < M;
		 * j++) { System.out.print(map[i][j]+" "); } System.out.println(); }
		 */
		graph = new int[iNum][iNum];
		for (int i = 0; i < iNum; i++) {
			Arrays.fill(graph[i], INF);
		}
		TreeSet<edge> pq = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					int island = map[i][j];
					for (int k = j + 1; k < M; k++) {// 동쪽에 섬있는지 탐색
						if (map[i][k] == island) {
							break;
						} else if (map[i][k] != 0) {
							int edge = k - j - 1;
							if (edge == 1)
								break;
							graph[map[i][j]][map[i][k]] = Math.min(graph[map[i][j]][map[i][k]], edge);
							break;
						}
					}
					for (int k = j - 1; k >= 0; k--) {// 서쪽에 섬있는지 탐색
						if (map[i][k] == island) {
							break;
						} else if (map[i][k] != 0) {
							int edge = j - k - 1;
							if (edge == 1)
								break;
							graph[map[i][j]][map[i][k]] = Math.min(graph[map[i][j]][map[i][k]], edge);
							break;
						}
					}
					for (int k = i + 1; k < N; k++) {// 남쪽에 섬있는지 탐색
						if (map[k][j] == island) {
							break;
						} else if (map[k][j] != 0) {
							int edge = k - i - 1;
							if (edge == 1)
								break;
							graph[map[i][j]][map[k][j]] = Math.min(graph[map[i][j]][map[k][j]], edge);
							break;
						}
					}
					for (int k = i - 1; k >= 0; k--) {// 북쪽에 섬있는지 탐색
						if (map[k][j] == island) {
							break;
						} else if (map[k][j] != 0) {
							int edge = i - k - 1;
							if (edge == 1)
								break;
							graph[map[i][j]][map[k][j]] = Math.min(graph[map[i][j]][map[k][j]], edge);
							break;
						}
					}
				}
			}
		}
		parent = new int[iNum];//iNum = 마을개수 인데 하나가 더플러스 됐음.
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < iNum; i++) {
			for (int j = 0; j < iNum; j++) {
				if (graph[i][j] == 1) {
					graph[i][j] = INF;
				} else if (graph[i][j] != INF) {
					pq.add(new edge(i, j, graph[i][j]));
				}
			}
		}
		int vertex = iNum - 1;
		for (edge e : pq) {//유니온 파인드
			unionSet(e);
		}
		//System.out.println(Arrays.toString(parent));
		if (cnt == vertex - 1) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}

		/*
		 * System.out.println(); for (int i = 0; i <iNum; i++) { for (int j = 0; j
		 * <iNum; j++) { System.out.print(graph[i][j]+" "); } System.out.println(); }
		 */

	}
	static int cnt,ans;
	private static void unionSet(edge e) {
		int x = findSet(e.s);
		int y = findSet(e.e);
		if (x != y) {
			parent[y] = x;
			ans += e.w;
			cnt++;
		}

	}

	static int parent[];

	private static int findSet(int x) {
		if (x == parent[x]) {
			return x;
		}
		else {
			int tmp = findSet(parent[x]);
			parent[x]=tmp;
			return tmp;
		}
	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void bfs(int sx, int sy, int iNum) {
		Queue<posit> q = new LinkedList<>();
		map[sx][sy] = iNum;
		visit[sx][sy] = true;
		q.offer(new posit(sx, sy));
		while (!q.isEmpty()) {
			posit p = q.poll();
			for (int i = 0; i < 4; i++) {
				int tx = p.x + dx[i];
				int ty = p.y + dy[i];
				if (tx < 0 || ty < 0 || tx >= N || ty >= M || visit[tx][ty] || map[tx][ty] == 0)
					continue;
				visit[tx][ty] = true;
				map[tx][ty] = iNum;
				q.offer(new posit(tx, ty));
			}
		}
	}

}
