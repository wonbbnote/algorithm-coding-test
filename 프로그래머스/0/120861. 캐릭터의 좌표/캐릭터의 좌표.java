class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[] {0, 0};
        
        int verticalMax = (board[1] - 1) / 2;
        int verticalMin = 0 - verticalMax;
        int horizontalMax = (board[0] - 1) / 2;
        int horizontalMin = 0 - horizontalMax;
        
        for(String key: keyinput){
            
            switch(key){
                    
                case "up":
                    if(answer[1] != verticalMax){
                        answer[1]++;
                    }
                    break;
                case "down":
                    if(answer[1] != verticalMin){
                        answer[1]--;
                    }
                    break;
                case "left":
                    if(answer[0] != horizontalMin){
                        answer[0]--;
                    }
                    break;
                case "right":
                    if(answer[0] != horizontalMax){
                        answer[0]++;
                    }
                    break;
                    
                    
            }
        }
        
        
        
        
        
        return answer;
    }
}