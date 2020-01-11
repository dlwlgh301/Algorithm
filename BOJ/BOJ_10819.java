import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10819 {
	static int Max;
	static int result;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int[]arr= new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=sc.nextInt();
		}
		solv(arr,0,N);
		System.out.println(result);
	}

	private static void solv(int[] arr, int depth, int n) {
		if(depth==n) {
			Max=0;
			for(int i =0; i<n-1; i++) {
				Max=Max+Math.abs(arr[i]-arr[i+1]);
			}
			if(Max>result) {
				result=Max;
			}
			return;
		}
		for(int i=depth; i<n; i++) {
			swap(arr,i,depth);
			solv(arr,depth+1,n);
			swap(arr,i,depth);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = 0;
		temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
