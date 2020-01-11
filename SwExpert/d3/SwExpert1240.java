package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1240 {

	public static void main(String[] args) throws IOException {
		String[] code = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
				"0110111", "0001011" };
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= k; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			String find;
			int[] result = new int[8];
			for (int i = 0; i < n; i++) {
				boolean flag = false;
				st = new StringTokenizer(br.readLine());
				find = st.nextToken();
				if (find.contains("1")) {
					if (!flag) {
						int last = find.lastIndexOf("1");
						find = find.substring(last - 55, last + 1);
						for (int sub = 0; sub < 8; sub++) {
							String temp = "";
							temp = find.substring(sub * 7, sub * 7 + 7);
							for (int j = 0; j < code.length; j++) {
								if (temp.equals(code[j])) {
									result[sub] = j;
								}
							}
						}
					}
					flag = true;
				}
			}
			int sum = 0;
			int answer = (result[0] + result[2] + result[4] + result[6]) * 3 + result[1] + result[3] + result[5]
					+ result[7];
			if (answer % 10 == 0) {
				for (int j = 0; j < 8; j++) {
					sum += result[j];
				}
				System.out.printf("#%d %d\n",tc,sum);
			}else System.out.printf("#%d 0\n",tc);
		}
	}
}