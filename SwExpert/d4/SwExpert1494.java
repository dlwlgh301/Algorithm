package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SwExpert1494 {
	static class posit {
		int x;
		int y;

		public posit(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<posit> list;
	static boolean visit[];
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			visit = new boolean[N];
			min = Long.MAX_VALUE;
			for(int i = 0; i< N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				list.add(new posit(x,y));
			}
			DFS(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	static long min = Long.MAX_VALUE;
	private static void DFS(int select, int depth) {
		if(select==N/2) {
			System.out.println(Arrays.toString(visit));
			long vx1=0 , vx2=0;
			long vy1=0, vy2=0;
			for(int i = 0; i<N; i++) {
				if(visit[i]) {
					vx1+=list.get(i).x;
					vy1+=list.get(i).y;
				}else if (!visit[i]){
					vx2-=list.get(i).x;
					vy2-=list.get(i).y;
				}
			}
			long rx =vx1+vx2;
			long ry =vy1+vy2;
			long v = rx*rx+ry*ry;
			min = Math.min(min, v);
			return;
		}
		if(depth>=N) return;
		visit[depth]= true;
		DFS(select+1, depth+1);
		visit[depth]= false;
		DFS(select,depth+1);
	}

}
