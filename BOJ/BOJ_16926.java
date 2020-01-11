import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16926 {
	static int N,M,R;
	static int array[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				array[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		int depth = Math.min(N,M)/2;
		DFS(depth);
	}
	private static void DFS(int depth) {
		if(depth==0) {
			return;
		}
		
		DFS(depth-1);
		
	}

}
