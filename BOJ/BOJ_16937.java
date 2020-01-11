import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16937 {
	static int H, W, N, R, C;
	static int max = 0;
	static int copy[][];
	static ArrayList<sticker> list;

	static class sticker {
		int r;
		int c;

		public sticker(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			list.add(new sticker(R, C));
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				sticker temp1 = list.get(i);
				sticker temp2 = list.get(j);
				solv(temp1, temp2);
				change(temp1);
				solv(temp1,temp2);
				change(temp2);
				solv(temp1,temp2);
				change(temp1);
				solv(temp1,temp2);
				
			}
		}

		System.out.println(max);
	}

	private static void change(sticker temp) {
		int tmp =temp.r;
		temp.r=temp.c;
		temp.c=tmp;
		
	}

	private static void solv(sticker temp1, sticker temp2) {
		// 가로세로
		int map[][] = new int[H][W];
		boolean flag = true;
		out: for (int i = 0; i < temp1.r; i++) {
			for (int j = 0; j < temp1.c; j++) {
				if (i <H && j <W) {
					map[i][j] = 1;
				} else {
					flag = false;
					break out;
				}
			}
		}
		if (flag) {
			out: for (int i = H - 1; i >= H - temp2.r; i--) {
				for (int j = W - 1; j >= W - temp2.c; j--) {
					if (i >= 0 && j >= 0 && map[i][j] != 1) {
						map[i][j] = 1;
					} else {
						flag = false;
						break out;
					}
				}
			}
		}
		if (flag) {
			/*System.out.println();
			for(int i =0; i<H; i++) {
				for(int j = 0; j<W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}*/
			int size = (temp1.r * temp1.c) + (temp2.r * temp2.c);
			max = Math.max(size, max);
		}
	}
}
