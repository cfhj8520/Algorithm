package coding_test;

import java.util.*;
  
public class Main {
	public static String solution(String S) {
		String answer = "";
		
		char[] arr = new char[S.length()];
		
		arr = S.toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<S.length();i++) {
			switch(arr[i]) {
			case '(' : stack.push('(');break;
			case ')' : stack.pop(); break;
			default : 
				if(stack.empty()) {
					answer+=arr[i];
				}
			}
		}
		
		return answer;
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    String S = in.next();
 
    System.out.println(solution(S));
    
    
    return ;
  }
}
