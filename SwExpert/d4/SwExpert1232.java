package d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwExpert1232  {
	static int [][]numbers;
	static String [] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		for(int k =1 ;k<=10; k++) {
			int num=Integer.parseInt(br.readLine());
			arr=new String[num+1];
			numbers= new int[num+1][3];
			String[] inputs;
			for(int i = 1; i<=num; i++) {
				String temp = br.readLine();
				inputs = temp.split(" ");
				arr[i]=inputs[1];
				 if(inputs.length>2) {
	                    numbers[i][1] = Integer.parseInt(inputs[2]);
	                    numbers[i][2] = Integer.parseInt(inputs[3]);
	                }
			}
			System.out.printf("#%d " ,k);
			System.out.println(inOrder(1));
		}
	}

	private static int inOrder(int index) {
		if(index>=arr.length) {
			return Integer.parseInt(arr[index]);
		}
		if(arr[index].equals("+")) {
			return inOrder(numbers[index][1])+inOrder(numbers[index][2]);
			
		}else if(arr[index].equals("-")){
			return inOrder(numbers[index][1])-inOrder(numbers[index][2]);
		}
		else if(arr[index].equals("*")){
			return inOrder(numbers[index][1])*inOrder(numbers[index][2]);
		}
		else if(arr[index].equals("/")){
			return inOrder(numbers[index][1])/inOrder(numbers[index][2]);
		}else {
			return Integer.parseInt(arr[index]);
		}
	}

}
