import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {// suzy의 suzy맞는 여행
	static char map[][];
	static int N, M;
	static boolean visit[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visit = new boolean[N][M];
		map = new char[N][M];
		max=Integer.MIN_VALUE;
		char save[] = new char[N * M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			map[i] = input.toCharArray();
		}
		visit[0][0] = true;
		DFS(0, 0, 0, save);
		System.out.printf("%d",max+1);
		
	}

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int max = Integer.MIN_VALUE;
	private static void DFS(int si, int sj, int depth, char save[]) {
		
		save[depth] = map[si][sj];
		if(depth>max) {
			max=depth;
		}
		if(max==25) return;
		for (int i = 0; i < 4; i++) {
			int tx = si + dx[i];
			int ty = sj + dy[i];
			if (tx >= 0 && tx < N && ty >= 0 && ty < M && !visit[tx][ty]) {
				boolean flag = true;
				for (int s = 0; s <= depth; s++) {
					if (save[s] == map[tx][ty]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					DFS(tx, ty, depth + 1, save);
					save[depth+1]=' ';
				}
			}
		}
	}
}
