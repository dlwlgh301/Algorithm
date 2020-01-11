package d4;

import java.util.Scanner;
import java.util.Stack;

public class SwExpert1218 {//괄호짝 찾기

	public static void main(String[] args) {
		Stack<Character> stack=new Stack<Character>();
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10;tc++) {
			int arrLength = sc.nextInt();
			char []arr = new char[arrLength];
			for(int i=0; i<arr.length; i++) {
				if(arr[i]=='('||arr[i]=='{'||arr[i]=='['||arr[i]=='<') {
					stack.push(arr[i]);
					
				}else if (arr[i]==')') {
					
				}else if (arr[i]=='}') {
					
				}else if (arr[i]==']') {
					
				}else if (arr[i]=='>') {
					
				}
				
				
			}
			
		}
	}

}
