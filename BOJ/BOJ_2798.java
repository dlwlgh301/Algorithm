import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2798 {
	static int card[];
	static int N;
	static int max;
	static boolean visit[];
	public static void main(String[] args) throws IOException {//블랙잭
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		
		card= new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N; i++) {
			card[i]= Integer.parseInt(st.nextToken());
		}
		DFS(0 ,0);
		System.out.println(ans);

	}
	static int ans = Integer.MIN_VALUE;
	private static void DFS(int select, int depth) {
		if(select==3) {
			//System.out.println(Arrays.toString(visit));
			int sum=0;
			for(int i = 0; i<N; i++) {
				if(visit[i]) {
					sum+=card[i];
				}
			}
			if(sum<=max) {
				if(ans<sum) {
					ans=sum;
				}
			}
			return;
		}
		if(depth==card.length) return;
		visit[depth]=true;
		DFS(select+1, depth+1);
		visit[depth]=false;
		DFS(select, depth+1);
	}

}
