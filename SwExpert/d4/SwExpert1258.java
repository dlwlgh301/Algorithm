package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class SwExpert1258 {
	static class arr {
		int x;
		int y;

		public arr(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}
	static int N;
	static int map[][];
	static ArrayList<arr> list;
	static int cnt;
	static int x,y;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int tc = 0; tc < T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			cnt = 0;
			list = new ArrayList<arr>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						x=1; y=1;
						map[i][j]=0;
						boolean flag=true;;
						DFS(i, j,flag);
						list.add(new arr(y,x));
						cnt++;
					}
				}
			}
			Collections.sort(list , new Comparator<arr>() {
				public int compare(arr o1, arr o2) {
					int area1 = o1.x*o1.y;
					int area2 = o2.x*o2.y;
					if(area1==area2) {
						return o1.x-o2.x;
					}
					return area1-area2;
				}
			});
			System.out.printf("#%d %d ", (tc+1),cnt);
			for(int i =0 ; i<list.size(); i++) {
				System.out.print(list.get(i).x+" "+list.get(i).y+" ");
			}
			System.out.println();
		}
	}
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	private static void DFS(int si, int sj, boolean flag) {
		
		for(int dir = 0 ; dir<4; dir++) {
			int tx = si+dx[dir];
			int ty = sj+dy[dir];
			
			if(tx<N&&tx>=0&&ty<N&&ty>=0&&map[tx][ty]!=0) {
				map[tx][ty]=0;
				if(ty==sj+1&&flag) {
					x++;
				}
				if(tx== si+1) {
					y++;
					flag=false;
				}
				DFS(tx,ty, flag);
			}
		}
		
	}

}
