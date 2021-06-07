class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] binary1 = new String[n];
        String[] binary2 = new String[n];

        for(int i=0;i<n;i++){
            String tmp="";

            while(arr1[i]>0){       //배열 arr1에 있는 정수를 2진수로 치환
                tmp = arr1[i]%2 + tmp;
                arr1[i]=arr1[i]/2;
            }

            binary1[i]=tmp;

            while(binary1[i].length()<n){  //n자리가 안되는 2진수의 앞자리 0으로 채움
                binary1[i]= "0" + binary1[i];
            }
        }

        for(int i=0;i<n;i++){
            String tmp="";

            while(arr2[i]>0){       //배열 arr1에 있는 정수를 2진수로 치환
                tmp = arr2[i]%2 + tmp;
                arr2[i]=arr2[i]/2;
            }

            binary2[i]=tmp;

            while(binary2[i].length()<n){  //n자리가 안되는 2진수의 앞자리 0으로 채움
                binary2[i]= "0" + binary2[i];
            }
        }

        // for(int i=0;i<n;i++){
        //     System.out.println(binary1[i]);
        // }
        // System.out.println();
        // for(int i=0;i<n;i++){
        //     System.out.println(binary2[i]);
        // }

        for(int i=0;i<n;i++){
            String tmp = "";
            for(int j=0;j<n;j++){   //2진수 숫자에서 맨앞 글자를 뽑아 둘다 0인지 확인
                if(binary1[i].charAt(j)=='0' && binary2[i].charAt(j) == '0'){
                    tmp+=" ";
                }else{
                    tmp+="#";
                }
            }
            answer[i]=tmp;
        }

        return answer;
    }
}