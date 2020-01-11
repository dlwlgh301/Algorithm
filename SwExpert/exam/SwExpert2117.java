package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * SWEA2117 홈방법서비스
 */

public class SwExpert2117 {
	static class posit {
		int x;
		int y;

		public posit(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int map[][];
	static boolean visit[][];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			ans = Integer.MIN_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());// 집 한개의 비용
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visit = new boolean[N][N];//모든 점에 대하여 BFS(완전탐색)
					BFS(i, j);
				}
			}
			System.out.printf("#%d %d\n",tc,ans);
		}

	}
	
	static int ans = Integer.MIN_VALUE;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	private static void BFS(int si, int sj) {
	 
		Queue<posit> q = new LinkedList<>();
		q.add(new posit(si, sj));
		visit[si][sj] = true;
		int K = 1;
		int count=0;
		
		if(map[si][sj]==1) { //맨처음 K 가 1일때의 경우
			count++;
			int cost = K*K+(K-1)*(K-1);
			if(count*M>=cost) {
				ans = Math.max(ans, count);
			}
		}
		while(!q.isEmpty()) {	//그 이후 BFS를 통해 완전탐색
			int size = q.size();
			for (int s = 0; s < size; s++) {
				posit temp = q.poll();
				for (int i = 0; i < 4; i++) {
					int tx = temp.x + dx[i];
					int ty = temp.y + dy[i];
					if (tx < 0 || tx >= N || ty < 0 || ty >= N || visit[tx][ty])
						continue;
					visit[tx][ty] = true;
					q.add(new posit(tx,ty));
					if (map[tx][ty] == 1) {// 탐색한곳이 1이면 집이므로 count를 증가
						count++;
					}
				}
			}
			K++;// 범위를 증가 시킨후 비용을 계산
			int cost = K*K+(K-1)*(K-1);
			if(count*M>=cost) {// 회사가 손해 안보는 수준이면 이 경우의 최대 집을 저장함
				ans = Math.max(ans, count);
			}
		}

	}

}
