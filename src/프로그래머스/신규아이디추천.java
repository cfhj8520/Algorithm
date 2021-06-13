class Solution {
    public String solution(String new_id) {
        String answer = new_id;
        
        answer=step1(answer);
        answer=step2(answer);
        answer=step3(answer);
        answer=step4(answer);
        answer=step5(answer);
        answer=step6(answer);
        answer=step7(answer);
        System.out.println(answer);
        
        return answer;
    }
    
    public String step1(String id){
        id = id.toLowerCase();
        
        return id;
    }
    
    public String step2(String id){
        id = id.replaceAll("[^a-z0-9_.-]","");
        
        return id;
    }
    
    public String step3(String id){
        do{
            id = id.replace("..",".");
        }while(id!=id.replace("..","."));
        
        return id;
    }
    
    public String step4(String id){
        if(id != null && id.length() > 0 && id.charAt(0) == '.'){
            id = id.substring(1,id.length());
        }
        if(id != null && id.length() > 0 && id.charAt(id.length()-1) == '.'){
            id = id.substring(0,id.length()-1);
        }
        return id;
    }
    
    public String step5(String id){
        if(id.equals(""))
            id="a";
        return id;
    }
    
    public String step6(String id){
        if(id.length()>=16){
            id = id.substring(0,15);
            id = step4(id);
        }
        return id;
    }
    
    public String step7(String id){
        if(id.length()==1)
            id = id+id+id;
        else if(id.length()==2)
            id = id+id.charAt(1);
            
        return id;
    }
}
