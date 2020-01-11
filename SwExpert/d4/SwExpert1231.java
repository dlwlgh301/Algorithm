package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1231  {

	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int k =1 ;k<=10; k++) {
			int num=Integer.parseInt(br.readLine());
			char []arr=new char[num+1];
			for(int i = 1; i<=num; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				arr[index]=data.charAt(0);
			}
			System.out.printf("#%d " ,k);
			inOrder(arr,1);
			System.out.println();
		}
	}

	private static void inOrder(char[] arr, int index) {
		if(index>=arr.length) {
			return;
		}
		inOrder(arr,index*2);
		System.out.print(arr[index]);
		inOrder(arr,index*2 +1);
	}

}
