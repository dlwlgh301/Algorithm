package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SwExpert6808 {//카드게임
	static StringTokenizer token;
	static int[] me;
	static int[] you;
	static boolean[] visit;
	static int[] arr;
	static int iwin,kwin,rwin;
	static int max=9*8*7*6*5*4*3*2*1;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test = 1; test <= tc; test++) {
			me = new int[9];
			you = new int[9];
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < me.length; i++) {
				me[i] = Integer.parseInt(token.nextToken());
			}
			int cnt = 0;
			for (int i = 1; i <= 18; i++) {
				boolean flag = false;
				for (int j = 0; j < me.length; j++) {
					if (me[j] == i) {
						flag = true;
					}
				}
				if (flag == false) {
					you[cnt++] = i;
				}
			}
			visit = new boolean[me.length];
			arr= new int[me.length];
			solv(0);
			System.out.printf("#%d %d %d\n",test,rwin,(max-rwin));
			rwin=0;
		}
	}
	private static void solv(int depth) {
		if (depth ==9) {
			//System.out.println(Arrays.toString(arr));
			iwin=0;kwin=0;
			for(int i=0; i<arr.length; i++) {
				if(arr[i]>me[i]) {
					iwin+=arr[i]+me[i];
				}
				if(arr[i]<me[i]) {
					kwin+=arr[i]+me[i];
				}
			}
			if(kwin>iwin) rwin++;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!visit[i]) {
				visit[i] = true;
				arr[depth] = you[i];
				solv(depth + 1);
				visit[i] = false;
			}
		}
	}

}
