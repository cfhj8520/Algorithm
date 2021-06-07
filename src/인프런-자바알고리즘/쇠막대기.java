package coding_test;

import java.util.*;
  
public class Main {
	public static int solution(String S) {
		int answer = 0;
		
		char[] arr = new char[S.length()];
		
		arr = S.toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		char pre = arr[0];
		int count=0;
		stack.push(arr[0]);
		
		for(int i=1;i<S.length();i++) {
			switch(arr[i]) {
			case '(':stack.push(arr[i]);break;
			case ')':
				if(pre=='(') {
					stack.pop();
					answer+=stack.size();
				}else {
					stack.pop();
					count++;
				}
			}
			pre=arr[i];
//			System.out.println(stack);
		}
		
		return answer+count;
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    String S = in.next();
 
    System.out.println(solution(S));
    
    
    return ;
  }
}
