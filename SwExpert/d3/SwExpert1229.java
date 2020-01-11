package d3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SwExpert1229 {//암호문2
	static StringTokenizer token;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int tc = 1; tc <= 10; tc++) {
			int first = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			ArrayList<Integer> code = new ArrayList<>();
			for (int i = 0; i < first; i++) {
				code.add(Integer.parseInt(token.nextToken()));
			}
			int second = Integer.parseInt(br.readLine());
			token = new StringTokenizer(br.readLine());
			for (int i = 0; i < second; i++) {
				String insert = token.nextToken();
				if (insert.equals("D")) {
					int index = Integer.parseInt(token.nextToken());
					int test = Integer.parseInt(token.nextToken());
					for(int j = index; j<index+test; j++) {
						code.remove(index);
					}
				} else {
					int index = Integer.parseInt(token.nextToken());
					int test = Integer.parseInt(token.nextToken());
					for (int j = index; j < index + test; j++) {
						code.add(j, Integer.parseInt(token.nextToken()));
					}
				}
			}
			System.out.printf("#%d ", tc);
			for (int i = 0; i < 10; i++) {
				System.out.print(code.get(i) + " ");
			}
			System.out.println();
		}

	}

}
