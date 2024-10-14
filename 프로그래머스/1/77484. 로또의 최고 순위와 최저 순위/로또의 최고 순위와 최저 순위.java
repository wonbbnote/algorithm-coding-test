class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        int equalNum = 0;
        int unvisible = 0;
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    equalNum++;
                    continue;
                }else if(lottos[i] == 0){
                    unvisible++;
                    break;
                }
            }
        }
        
        System.out.println(equalNum);
        System.out.println(unvisible);
        
    
        
        if(7 - (equalNum + unvisible) > 6){
            answer[0] = 6;
        }else{
            answer[0] = 7 - (equalNum + unvisible);
        }
        
        if(7 - equalNum > 6){
            answer[1] = 6;
        }else{
            answer[1] = 7 - equalNum;
        }
        
        return answer;
    }
}