package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SwExpert4408 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc<= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int nRoom = Integer.parseInt(st.nextToken());
			int room[] = new int[201];
			for(int i = 0; i<nRoom; i++) {
				st = new StringTokenizer(br.readLine());
				int startr=Integer.parseInt(st.nextToken());
				int endr = Integer.parseInt(st.nextToken());
				if(startr>endr) {
					int temp = startr;
					startr=endr;
					endr=temp;
				}
				if(startr%2==1) startr++;
				startr/=2;
				if(endr%2==1) endr++;
				endr/=2;
				for(int j=startr; j<=endr; j++) {
					room[j]++;
				}
			}
			Arrays.sort(room);
			System.out.printf("#%d %d\n",tc,room[200]);
		}
	}
}
