import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] clear = new int[N+1];
        int[] stay= new int[N+2];
        
        Arrays.fill(stay,0);
        Arrays.sort(stages);
        
        for(int i=stages.length-1;i>-1;i--){        //가장 진행도가 높은 순부터
            clear[stages[i]-1]=stages.length-i;     //정렬했기 때문에 인덱스 번호가 클리어한 사람 수가 된다
            stay[stages[i]]++;                      //해당 스테이지에 멈춘사람 카운트
        }
        
        for(int i=clear.length-1;i>-1;i--){        //다음 스테이지의 실패율 0퍼로 인해 발생하는 오류 보정
            if(i!=clear.length-1&&clear[i]==0)
                clear[i]=clear[i+1];
        }
        
        // for(int i=1;i<clear.length;i++)
        //     System.out.print(clear[i]+ " ");
        // System.out.println();
        // for(int i=1;i<stay.length;i++)
        //     System.out.print(stay[i]+" ");
        
        HashMap<Integer,Double> map = new HashMap<Integer,Double>();
        
        for(int i=1;i<N+1;i++){
            if((stay[i]+clear[i])==0){
                map.put(i,(double)0);
                continue;
            }
            map.put(i,(double)stay[i]/(stay[i]+clear[i]));
        }
        
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		
		// for(Integer key : keySetList) {
		// 	System.out.println("key : " + key + " / " + "value : " + map.get(key));
		// }
        
        Integer[] tmp=keySetList.toArray(new Integer[keySetList.size()]);
        
        int[] answer = Arrays.stream(tmp).mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
