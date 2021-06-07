package coding_test;

import java.util.*;
  
public class Main {
	public static int solution(String S, String T) {
		int answer = 0;
		int S_len = S.length();
		int T_len = T.length();
		
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		Map<Character,Integer> sol = new HashMap<Character,Integer>();
		char[] arr = new char[S.length()];
		char[] brr = new char[T.length()];
		
		arr = S.toCharArray();
		brr = T.toCharArray();
		
		for(int i=0;i<T_len;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			sol.put(brr[i], sol.getOrDefault(brr[i], 0)+1);
		}
		
//		System.out.println("map : "+map);
//		System.out.println("sol : "+sol);
		
		if(sol.equals(map))
			answer++;
		
		for(int i=0;i<S_len-T_len;i++) {
			if(map.get(arr[i])==1) {
				map.remove(arr[i]);
			}else {
				map.replace(arr[i], map.get(arr[i])-1);
			}
			
			map.put(arr[i+T_len], map.getOrDefault(arr[i+T_len], 0)+1);
			
//			System.out.println("map : "+map);
			
			if(sol.equals(map))
				answer++;
		}
		
		return answer;
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    String S = in.next();
    String T = in.next();
 
    System.out.println(solution(S,T));
    
    
    return ;
  }
}
