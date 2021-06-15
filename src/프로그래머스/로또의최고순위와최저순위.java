class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {0,0};
        int zero = 0;
        
        for(int i=0;i<6;i++){
            for(int j=0;j<6;j++){
                if(lottos[i]==win_nums[j])
                    zero++;
            }
        }
        answer[1]=Grade(zero);
        
        for(int i=0;i<6;i++){
            if(lottos[i]==0)
                zero++;
        }
        answer[0]=Grade(zero);
        
        return answer;
    }
    
    public int Grade(int n){
        switch (n){
                case 0:case 1: n=6; break;
                case 2: n=5; break;
                case 3: n=4; break;
                case 4: n=3; break;
                case 5: n=2; break;
                case 6: n=1;
        }
        return n;
    }
}
