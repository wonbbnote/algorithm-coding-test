class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        
        int max_step_width = (board[0] - 1) / 2;
        int max_step_height = (board[1] - 1) / 2;
        int[] loca = new int[] {0,0};
        
        for(String key: keyinput){
            switch(key){
                case "left":
                    if(loca[0] > -max_step_width){
                        loca[0]--;
                    }
                    break;
                case "right":
                    if(loca[0] < max_step_width){
                        loca[0]++;
                    }
                    break;
                case "up":
                    if(loca[1] < max_step_height){
                        loca[1]++;
                    }
                    break;
                case "down":
                    if(loca[1] > -max_step_height){
                        loca[1]--;
                    }
                    break;
            }
        }
        
        return loca;
    }
}