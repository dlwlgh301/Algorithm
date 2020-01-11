import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1107 {

	static String input;
	static boolean button[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = st.nextToken();
		int n = Integer.parseInt(br.readLine());
		button = new boolean[10];
		if (n != 0) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				button[Integer.parseInt(st.nextToken())] = true;
			}
		}
		dfs(0, false);

		min = Math.min(min, Math.abs(Integer.parseInt(input) - 100));
		System.out.println(min);
	}

	static int temp = 0;
	static int min = Integer.MAX_VALUE;

	private static void dfs(int depth, boolean flag) {
		if (flag) {
			if (depth >= input.length() - 1) {
				int ret = Math.abs(Integer.parseInt(input) - temp) + depth;
				min = Math.min(ret, min);
				if (depth >= input.length() + 1) {
					return;
				}
			}
		}
		for (int i = 0; i <= 9; i++) {
			if (!button[i]) {
				temp += i * Math.pow(10, depth);
				dfs(depth + 1, true);
				temp -= i * Math.pow(10, depth);

			}

		}

	}

}
