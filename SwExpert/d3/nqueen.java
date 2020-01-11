package d3;

import java.util.Arrays;
import java.util.Scanner;

public class nqueen {
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int k=sc.nextInt();
		for(int tc=1; tc<=k; tc++) {
			cnt = 0;
			int N = sc.nextInt();
			int [] arr = new int[N];
			solv(arr,0,N);
			System.out.printf("#%d %d\n",tc , cnt);
		}
	}
	private static void solv(int[] arr,int depth, int n) {
		if(depth==arr.length) {
			System.out.println(Arrays.toString(arr));
			cnt++;
			return;
		}
		for(int i = 0; i < n; i++) {
			boolean flag=true;
			arr[depth]= i;
			for(int j = 0; j<depth; j++) {
				if(arr[j]==arr[depth]) {
					flag=false;
					break;
				}
				if(Math.abs(arr[j]-arr[depth])==depth-j){
					flag=false;
					break;
				}
			}
			if(flag==true) {
				solv(arr,depth+1, n);
			}
		}
	}
}
