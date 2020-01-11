import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_6987 {

	static int win[];
	static int draw[];
	static int lose[];
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			check = false;
			;
			win = new int[6];
			draw = new int[6];
			lose = new int[6];
			for (int i = 0; i < 6; i++) {
				win[i] = Integer.parseInt(st.nextToken());
				draw[i] = Integer.parseInt(st.nextToken());
				lose[i] = Integer.parseInt(st.nextToken());
			}

			int sum = 0;
			for (int i = 0; i < 6; i++) {
				sum += win[i] + draw[i] + lose[i];
			}
			if (sum != 30) {
				check = false;
			} else {
				solve(0);
			}
			System.out.print(check ? 1 : 0);
			System.out.print(" ");
		}
	}

	static int game1[] = { 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4 };
	static int game2[] = { 1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5 };

	private static void solve(int depth) {
		if (depth == 15) {
			check = true;
			return;
		}
		if (win[game1[depth]] > 0 && lose[game2[depth]] > 0) {
			win[game1[depth]]--;
			lose[game2[depth]]--;
			solve(depth + 1);
			win[game1[depth]]++;
			lose[game2[depth]]++;
		}
		if (win[game2[depth]] > 0 && lose[game1[depth]] > 0) {
			win[game2[depth]]--;
			lose[game1[depth]]--;
			solve(depth + 1);
			win[game2[depth]]++;
			lose[game1[depth]]++;
		}
		if (draw[game1[depth]] > 0 && draw[game2[depth]] > 0) {
			draw[game1[depth]]--;
			draw[game2[depth]]--;
			solve(depth + 1);
			draw[game1[depth]]++;
			draw[game2[depth]]++;
		}
	}

}
