package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1952 {

	static int cost[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<=T; tc++) {
			cost = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<4; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			
			
		}

	}

}
