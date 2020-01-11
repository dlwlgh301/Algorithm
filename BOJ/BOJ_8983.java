import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_8983 {
	static class posit implements Comparable<posit>{
		int x;
		int y;
		public posit(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(posit o) {
			// TODO Auto-generated method stub
			return this.x- o.x;
		}		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<posit> list = new ArrayList<>();
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int sh[] = new int[M];
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i<M; i++) {
			sh[i]=Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(new posit(x,y));
		}
		Arrays.sort(sh);
		Collections.sort(list);
/*		System.out.println(Arrays.toString(sh));
		for(int i = 0 ; i<list.size(); i++) {
			System.out.println(list.get(i).x+" "+list.get(i).y);
		}*/
		
		int cnt = 0;
		int s=0;
		for(int i = 0; i<N; i++) {
			int tx = list.get(i).x;
			int ty = list.get(i).y;
			
			if(ty<=L) {
				for(int j = s; j<M; j++) {
					int pos = Math.abs(sh[j]-tx)+ty;
					if(pos<=L) {
						cnt++;
						s=j;
						break;
					}
					if(tx<sh[j]) {
						System.out.println("걸림"+tx+" "+sh[j]+" "+pos);
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}

}
