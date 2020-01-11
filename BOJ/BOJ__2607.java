import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ__2607 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		int word[] = new int[26];
		int result = 0;
		String startWord = br.readLine();
		for (int i = 0; i < startWord.length(); i++) {
			char temp = startWord.charAt(i);
			word[temp - 'A']++;
		}
		for (int tc = 0; tc < K - 1; tc++) {
			int compare[] = new int[26];
			String compareWord = br.readLine();
			for (int i = 0; i < compareWord.length(); i++) {
				char temp = compareWord.charAt(i);
				compare[temp - 'A']++;
			}
			int c=0;
			for (int i = 0; i < 26; i++) {
				c+=Math.abs(word[i] - compare[i]);
			}
			if (Math.abs(startWord.length() - compareWord.length()) <=1 && c<=2) {
				result++;
			}
		}
		System.out.println(result);
	}

}
