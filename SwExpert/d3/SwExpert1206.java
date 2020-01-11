package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1206 {

	public static void main(String[] args) throws Exception {//sw1206 view
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc<=10; tc++) {
			int nums = Integer.parseInt(br.readLine());
			int [] buildings = new int[nums];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i<nums; i++) {
				buildings[i]=Integer.parseInt(st.nextToken());
			}
			int sum = 0;
			for(int i = 2;i<nums-2;i++) {
				int temp = 0; int result = 0;
				for(int j=i-2; j<=i+2;j++) {
					if(j==i) continue;
					if(temp<buildings[j]) {
						temp=buildings[j];
					}
				}
				result = buildings[i]-temp;
				if(result>0) {
					sum=sum+result;
				}
			}
			System.out.printf("#%d %d\n",tc,sum);
		}
	}

}
