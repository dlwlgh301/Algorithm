import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_1181 {
	/*BOJ 1181 단어정렬*/
	static class word implements Comparable<word>{
		String s;

		public word(String s) {
			super();
			this.s = s;
		}

		@Override
		public int compareTo(word o) {
			if(o.s.length()==this.s.length()) {
				return this.s.compareTo(o.s);
			}
			return this.s.length()-o.s.length();
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		TreeSet<word> set = new TreeSet<>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String input = st.nextToken();
			set.add(new word(input));
		}
		for(word word : set) {
			System.out.println(word.s);
		}
		
	}
}
