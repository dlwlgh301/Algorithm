import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1592 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int people[] = new int[N];
		people[0] = 1;
		int ans = 0;
		int thr = 0;
		start: while (true) {
			for (int i = 0; i < N; i++) {
				if (people[i] == M) {
					break start;
				}
			}
			if (people[thr] % 2 == 1) {//시계방향
				thr = (thr + L) % N;
				people[thr]++;
				ans++;
			}else {//반시계 방향
				thr= thr-L;
				if(thr<0) {
					thr=N+thr;
				}
				people[thr]++;
				ans++;
			}
		}
		System.out.println(ans);
	}
}
