class Solution {
    public String solution(String polynomial) {
        String answer = "";
        
        String[] input = polynomial.split(" ");
        
        int xNum = 0;
        int Num = 0;
        
        for(int i = 0; i < input.length; i++){
            System.out.println(input[i]);
            
            if(input[i].endsWith("x")){
                
                if(input[i].length() == 1){
                    xNum += 1;
                }else{
                    String num = input[i].substring(0, input[i].length() - 1);
                    xNum += Integer.parseInt(num);
                }
                
            }else if(input[i].equals("+")){
                continue;
                
            }else{
                Num += Integer.parseInt(input[i]);
            }
        }
        
        if(xNum > 1){
            answer += xNum + "x";
        }else if(xNum == 1){
            answer += "x";
        }
        
        if(xNum > 0 && Num != 0){
            answer += " + " + Num;
        }else if(xNum == 0 && Num != 0){
            answer += Num + "";
        }
        
        
        return answer;
    }
}