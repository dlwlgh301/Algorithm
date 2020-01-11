package d4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert3289 {
	static int [] parent;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int tc =1 ; tc<= N; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int maxSize = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			parent = new int[maxSize+1];
			makeSet(parent);
			for(int i = 0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int set = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(set==0) {
					unionSet(a,b);
				}else if(set==1) {
					int tmp1=findSet(a);
					int tmp2=findSet(b);
					if(tmp1==tmp2) {
						sb.append(1);
					}else sb.append(0);
				}
			}
			System.out.printf("#%d ",tc);
			System.out.println(sb.toString());
		}
	}
	private static void unionSet(int x,int y) {
		x = findSet(x);
		y = findSet(y);
		if(x!=y) {
			parent[y]=x;
		}
	}
	private static int findSet(int x) {
		if(x==parent[x]) {
			return x;
		}else {
			int p = findSet(parent[x]);
			parent[x]=p;
			return p;
		}
	}
	private static void makeSet(int[] parent) {
		for(int i =0; i<parent.length; i++) {
			parent[i]=i;
		}
	}
}
