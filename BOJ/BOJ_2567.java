import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int map[][]= new int[102][102];
		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			
			for(int i = w; i<w+10; i++) {
				for(int j = h; j<h+10; j++) {
					map[i][j]=1;
				}
			}
		}
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
		for(int i =0; i<=100; i++) {
			for(int j = 0; j<=100; j++) {
				if(map[i][j]==1) {
					for(int k =0; k<4; k++) {
						
					}
				}
			}
		}
	}

}
