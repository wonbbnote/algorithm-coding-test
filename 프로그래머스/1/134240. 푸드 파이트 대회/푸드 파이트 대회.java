class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for(int i = 1; i < food.length; i++){
            int food_num = food[i] / 2;
            for(int j = 0; j < food_num; j++){
                answer += i;
            }
        }
        String reverse_str = new StringBuilder(answer).reverse().toString();
        answer += "0";
        answer += reverse_str;
        
        return answer;
    }
}