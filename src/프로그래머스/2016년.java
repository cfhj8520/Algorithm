class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int y = 16;     //2016년
    
    String[] date = {
        "SAT",
        "SUN",
        "MON",
        "TUE",
        "WED",
        "THU",
        "FRI",
    };
    if(a<=2){       //첼러의 공식에서 1,2월은 13,14로 계산하기 때문에 1년을 빼고 12를 더해준다
        a += 12;
        y -= 1;
    }

    int h = (int)((b+Math.floor((13*(a+1))/5)+y+Math.floor(y/4)+Math.floor((20/4)-40)) % 7);
        
    if(h<0){        //음수가 나올경우 a mod b = a+b (a<0,a+b>0) 이므로 7을 더해준다
        h+=7;
    }
        
    answer = date[h];
    return answer;
    }
}
