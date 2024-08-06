class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] sArr = s.split(" ");
        for(int i = 0; i < sArr.length; i++){
            System.out.println(sArr[i]);
            
            if(sArr[i].equals(" ")){
                answer += " ";
                
            }else{
                
                for(int j = 0; j < sArr[i].length(); j++){
                    char c = sArr[i].charAt(j);
                    if(j == 0 && Character.isLowerCase(c)){
                        answer += Character.toUpperCase(c);
                    }else if(j > 0 && Character.isUpperCase(c)){
                        answer += Character.toLowerCase(c);
                    }else{
                        answer += c;
                    }
                }
            }
            
            if(i < sArr.length-1){
                answer += " ";
            }
            // System.out.println(answer);
        }
        
        if(answer.length() < s.length()){
            int num = s.length() - answer.length();
            for(int i = 0; i < num; i++){
                answer += " ";
            }
        }
        
        return answer;
    }
}