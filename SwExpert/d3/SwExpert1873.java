package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1873 {
	static char map[][];
	static int ti;
	static int tj;
	static char dir;
	static int H, W;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				String inputs = st.nextToken();
				for (int j = 0; j < W; j++) {
					map[i][j] = inputs.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
						ti = i;
						tj = j;
						if (map[i][j] == '<') {
							dir = 'L';
						} else if (map[i][j] == '^') {
							dir = 'U';
						} else if (map[i][j] == '>') {
							dir = 'R';
						} else if (map[i][j] == 'v') {
							dir = 'D';
						}
					}
				}
			}
			int cNum = Integer.parseInt(br.readLine());
			String temp = br.readLine();
			for (int c = 0; c < cNum; c++) {
				char commend = temp.charAt(c);
				if (commend == 'U' || commend == 'R' || commend == 'L' || commend == 'D') {
					move(commend);
				} else {
					shoot();
				}
				/*System.out.println();
				for(int i=0; i<H; i++) { for(int j = 0; j<W; j++) {
				System.out.print(map[i][j]); } System.out.println(); } System.out.println();
				 */
			}
			System.out.printf("#%d ",tc);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	private static void shoot() {
		if (dir == 'L') {
			for (int i = tj; i >= 0; i--) {
				if (map[ti][i] == '*') {
					map[ti][i] = '.';
					break;
				} else if (map[ti][i] == '#') {
					break;
				}
			}
		} else if (dir == 'R') {
			for (int i = tj; i < W; i++) {
				if (map[ti][i] == '*') {
					map[ti][i] = '.';
					break;
				} else if (map[ti][i] == '#') {
					break;
				}
			}
		} else if (dir == 'U') {
			for (int i = ti; i >= 0; i--) {
				if (map[i][tj] == '*') {
					map[i][tj] = '.';
					break;
				} else if (map[i][tj] == '#') {
					break;
				}
			}
		} else if (dir == 'D') {
			for (int i = ti; i < H; i++) {
				if (map[i][tj] == '*') {
					map[i][tj] = '.';
					break;
				} else if (map[i][tj] == '#') {
					break;
				}
			}
		}
	}

	private static void move(char commend) {
		switch (commend) {
		case 'R':
			tj++;
			if (tj >= 0 && tj < W) {
				if (map[ti][tj] == '.') {
					map[ti][tj] = '>';
					map[ti][tj - 1] = '.';
				} else {
					tj--;
				}
			}else tj--;
			map[ti][tj] = '>';
			dir = 'R';
			break;
		case 'L':
			tj--;
			if (tj >= 0 && tj < W) {
				if (map[ti][tj] == '.') {
					map[ti][tj] = '<';
					map[ti][tj + 1] = '.';
				} else {
					tj++;
				}
			}else tj++;
			map[ti][tj] = '<';
			dir = 'L';
			break;
		case 'U':
			ti--;
			if (ti >= 0 && ti < H) {
				if (map[ti][tj] == '.') {
					map[ti][tj] = '^';
					map[ti + 1][tj] = '.';
				} else {
					ti++;
				}
			}else ti++;
			map[ti][tj] = '^';
			dir = 'U';
			break;
		case 'D':
			ti++;
			if (ti >= 0 && ti < H) {
				if (map[ti][tj] == '.') {
					map[ti][tj] = 'v';
					map[ti - 1][tj] = '.';
				} else {
					ti--;
				}
			}else ti--;
			map[ti][tj] = 'v';
			dir = 'D';
			break;
		}

	}

}
