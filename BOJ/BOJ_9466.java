import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9466 {

	static int term[];
	static boolean visit[], fin[];
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 0; tc < T; tc++) {
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			term = new int[n + 1];
			visit = new boolean[n + 1];
			fin = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				term[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 1; i <= n; i++) {
				if (!visit[i]) {
					DFS(i);
				}
			}
			System.out.println(n - cnt);
		}

	}

	private static void DFS(int cur) {
		if (visit[cur]) {
			return;
		}

		visit[cur] = true;
		int next = term[cur];

		if (!visit[next]) {
			DFS(next);
		} else {
			if (!fin[next]) {
				for (int i = next; i != cur; i = term[i]) {
					cnt++;
				}
				cnt++;
			}
		}
		fin[cur] = true;
	}

}
