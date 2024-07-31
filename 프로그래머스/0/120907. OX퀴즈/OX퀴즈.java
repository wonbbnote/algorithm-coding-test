class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++){
            String[] strippedOne = quiz[i].split(" ");
            int X = Integer.parseInt(strippedOne[0]);
            int Y = Integer.parseInt(strippedOne[2]);
            int Z = Integer.parseInt(strippedOne[4]);
            
            int value = 0;
            if(strippedOne[1].equals("+")){
                value = X + Y;
            }else if(strippedOne[1].equals("-")){
                value = X - Y;
            }
            
            if(value == Z){
                answer[i] = "O";
            }else{
                answer[i] = "X";
            }
        }
        
        return answer;
    }
}