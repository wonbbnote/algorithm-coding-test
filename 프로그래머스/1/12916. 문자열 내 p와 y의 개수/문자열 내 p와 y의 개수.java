class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int p_num = 0;
        int y_num = 0;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == 'P' || s.charAt(i) == 'p'){
                p_num += 1;
            }else if(s.charAt(i) == 'Y' || s.charAt(i) == 'y'){
                y_num += 1;
            }
        }
        if(p_num != y_num){
            answer = false;
        }

        return answer;
    }
}