import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16197 {
	static class coin{
		int x;
		int y;
		public coin(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<coin> list;
	static int N, M;
	static char map[][];
	static boolean visit1[][], visit2[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			for(int j = 0 ; j<M; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='o') {
					list.add(new coin(i,j));
				}
			}
		}
		DFS(list.get(0).x,list.get(0).y,list.get(1).x,list.get(1).y,0);
	}
	static int count;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	private static void DFS(int x, int y, int x2, int y2,int cnt) {
		
		for(int i = 0; i<4; i++) {
			int tx1 = x+dx[i];
			int ty1 = y+dy[i];
			int tx2 = x2+dx[i];
			int ty2 = x2+dy[i];
			
		}
	}
}
