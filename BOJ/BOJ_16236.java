import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static class Shark{
		int x;
		int y;
		int size=2;
		int eat;
		public Shark(int x, int y, int eat) {
			this.x = x;
			this.y = y;
			this.eat = eat;
		}
	}
	static int [][]map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map= new int[N][N];
		for(int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					Shark s = new Shark(i,j,0);
				}
			}
		}
		
		
	}
}
