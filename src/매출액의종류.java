package coding_test;

import java.util.*;
  
public class Main {
	public static int[] solution(int n, int k, int[] arr) {
		int[] answer = new int[n-k+1];
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		for(int i=0;i<k;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
//		System.out.println(map);
		
		answer[0]=map.size();
		
		for(int i=0;i<answer.length-1;i++) {
			if(map.get(arr[i])==1) {
				map.remove(arr[i]);
			}else {
				map.replace(arr[i], map.get(arr[i])-1);
			}
			
			map.put(arr[i+k], map.getOrDefault(arr[i+k], 0)+1);
			
			answer[i+1]=map.size();
//			System.out.println(map);
		}
		
		return answer;
	}
	
  public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    
    int n = in.nextInt();
    int k = in.nextInt();
    int[] arr = new int[n];
    
    for(int i=0;i<n;i++) {
    	arr[i]=in.nextInt();
    }
    
//    System.out.println(solution(n,k,arr));
    
    for(int x : solution(n,k,arr)) {
    	System.out.print(x+" ");
    }
    
    
    return ;
  }
}
