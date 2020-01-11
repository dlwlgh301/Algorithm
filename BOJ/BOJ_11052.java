import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {
	/*
	 * BOJ 11052 카드 구매하기
	 */
	static int card[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		card = new int[N];
		st = new StringTokenizer(br.readLine());
		int dp[] = new int[N+1];
		for (int i = 0; i < N; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		} 
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=i; j++) {
				dp[i]=Math.max(dp[i], dp[i-j]+card[j-1]);
			}
		}
		System.out.println(dp[N]);
	}
}