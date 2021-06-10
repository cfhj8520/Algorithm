class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        String[] score = new String[3];
        char tmp;
        
        for(int count=0;count<2;count++){               //문자열을 3개의 문자열로 분리
            int i=2;
            
            while(i<dartResult.length()){               //문자열을 초과하여 탐색 못하게 방지
                // System.out.println("i : "+i);
                tmp = dartResult.charAt(i);
                if(tmp>='0' && tmp<='9'){               //뽑은 문자가 숫자면 앞에서 자름
                    score[count] = dartResult.substring(0,i);   //자른 문자열 저장
                    dartResult= dartResult.substring(i);        //나머지 문자열 저장
                    break;
                }
                i++;
                // System.out.println("dartREsult : "+dartResult);
            }
        }
        score[2] = dartResult;          //마지막 문자열은 참조할 숫자가 없으니 따로 저장
        
        // for(int j=0;j<3;j++){        //문자가 제대로 분리됐는지 확인
        //     System.out.println(score[j]);
        // }
        
        int[] result = new int[3];
        
        for(int i=0;i<3;i++){           //3개의 문자열 점수 계산
            if(score[i]==null)          //왜인지는 모르겠으나 예외처리 안하면 nullpoint 발생
                break;
            for(int j=1;j<score[i].length();j++){
                switch(score[i].charAt(j)){ //S,D,T 만나면 앞부분은 숫자로 입력
                    case 'S' : result[i]= Integer.parseInt(score[i].substring(0,j)); break;
                    case 'D' : result[i]= Integer.parseInt(score[i].substring(0,j)); result[i]*=result[i]; break;
                    case 'T' : result[i]= Integer.parseInt(score[i].substring(0,j)); result[i]*=result[i]*result[i]; break;
                    case '*' : 
                        if(i==0){       //첫 점수부터 스타상이면 별도로 계산
                            result[i]*=2;
                        }else{
                            result[i]*=2;
                            result[i-1]*=2;
                        }
                        break;
                    case '#' : result[i]*=-1; break;
                    default : break;
                }
            }
        }
        
        for(int i=0;i<3;i++){
            answer+=result[i];
            // System.out.println(result[i]);
        }
        
        
        return answer;
    }
}
