package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert5653 {

	static int map[][];
	static int N,M,K;//N,M 크기 K 배양시간
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T= Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int K = Integer.parseInt(st.nextToken());
			map = new int [N][M];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i =1; i<=K; i++) {
				
			}	
		}
	}
	static class cell{
		int x ,y ,life,status,time;
		public cell(int x, int y, int life, int status, int time) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.status = status;
			this.time = time;
		}
	}
}
