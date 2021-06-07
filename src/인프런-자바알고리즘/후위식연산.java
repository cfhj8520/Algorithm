package coding_test;

import java.util.*;
  
public class Main {
	public static int solution(String S) {
		String answer = "";
		
		char[] arr = new char[S.length()];
		
		arr = S.toCharArray();
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<S.length();i++) {
			int a,b;
			switch(arr[i]) {
			case '+' :	a = stack.pop();
						b = stack.pop();
						stack.push(b+a);
						break;
			case '-' : 	a = stack.pop();
						b = stack.pop();
						stack.push(b-a);
						break;
			case '*' : 	a = stack.pop();
						b = stack.pop();
						stack.push(b*a);
						break;
			case '/' :	a = stack.pop();
						b = stack.pop();
						stack.push(b/a);
						break;
			default : 
				stack.push((int)(arr[i]-'0'));
			}
//			System.out.println(stack);
		}
		
		return stack.pop();
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    String S = in.next();
 
    System.out.println(solution(S));
    
    
    return ;
  }
}
