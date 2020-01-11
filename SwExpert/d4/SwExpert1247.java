package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SwExpert1247 {
	static class map{
		int x;
		int y;
		public map(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T; tc++) {
			cust = Integer.parseInt(br.readLine());
			map[] c = new map[cust+2]; //map[0] == 회사 map[1]==집
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<cust+2; i++) {
				int ca = Integer.parseInt(st.nextToken());
				int cy = Integer.parseInt(st.nextToken());
				c[i] = new map(ca,cy);
			}
			visited = new boolean[cust+2];
			solv(c,2,2);
		}
	}
	static int cust;
	static ArrayList<map> list;
	static int min;
	static boolean visited[];
	private static void solv(map[] map, int index,int depth) {
		if(depth==cust) {
			return;
		}
		for(int i = 2; i<cust+2; i++) {
			if(!visited[i]) {
				visited[i]=true;
				list.add(map[i]);
				solv(map,index+1,depth+1);
				visited[i]=false;
			}
		}
	}

}
