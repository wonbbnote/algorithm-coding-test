class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        
        
        for(int i = 0; i < babbling.length; i++){
            int n = 0;
            for(int j = 0; j < 4; j++){
                babbling[i] = babbling[i].replace(possible[j], "*");
            }
            
            boolean res = true;
            for(int j = 0; j < babbling[i].length(); j++){
                if(!babbling[i].substring(j, j+1).equals("*")){
                    res = false;
                }
            }
            if(res){
                answer++;
            }
        }
    
        
        return answer;
    }
}