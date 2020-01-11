import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < n; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			ArrayList<Character> list = new ArrayList<>();
			int cursor = 0;
			char[] temp = input.toCharArray();
			boolean flag = false;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] == '<') {
					if (cursor != 0) {
						cursor--;
						if (list.size() > 0) {
							flag = true;
						}
					}
				} else if (temp[i] == '>') {
					if(list.size()!=0) {
						cursor++;
					}
					if(list.size()>=cursor+1) {
						continue;
					}
				} else if (temp[i] == '-') {
					if (cursor!= 0) {
						cursor--;
						list.remove(cursor);
					}
				} else {
					if (flag) {
						list.add(cursor, temp[i]);
						flag = false;
					} else {
						list.add(cursor, temp[i]);
						cursor++;
					}

				}
			}
			for (char find : list) {
				System.out.print(find);
			}
			System.out.println();
		}

	}

}
