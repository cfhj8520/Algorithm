package coding_test;

import java.util.*;
  
public class Main {
	public static String solution(String S) {
		String answer = "YES";
		
		char[] arr = new char[S.length()];
		
		arr = S.toCharArray();
		
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0;i<S.length();i++) {
			switch(arr[i]) {
			case '(' : stack.push('(');break;
			case ')' : 
				if(stack.empty())
					answer = "NO";
				else
					stack.pop();
			}
		}
		
		if(!stack.empty())
			answer= "NO";
		
		return answer;
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    String S = in.next();
 
    System.out.println(solution(S));
    
    
    return ;
  }
}
