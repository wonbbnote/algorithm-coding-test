class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int[][] keyPad = new int[4][3];
        
        int[] leftCurr = {3, 0};
        int[] rightCurr = {3, 2};
        
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            
            if(num == 1 || num == 4 || num == 7){
                leftCurr = new int[] {num/3, 0};
                answer += "L";
                
            }else if(num == 3 || num == 6 || num == 9){
                rightCurr = new int[] {num/3 - 1, 2};
                answer += "R";
                
            }else{
                int[] numLoca = new int[2];
                
                if(num == 0){
                    numLoca[0] = 3;
                    numLoca[1] = 1;
                }else{
                    numLoca[0] = (num+1)/3 - 1;
                    numLoca[1] = 1;
                }
                                
                int leftDis = Math.abs(numLoca[0] - leftCurr[0]) + Math.abs(numLoca[1] - leftCurr[1]);
                int rightDis = Math.abs(numLoca[0] - rightCurr[0]) + Math.abs(numLoca[1] - rightCurr[1]);
                
                
                if(leftDis > rightDis){
                    rightCurr = new int[] {numLoca[0], numLoca[1]};
                    answer += "R";
                }else if(leftDis < rightDis){
                    leftCurr = new int[] {numLoca[0], numLoca[1]};
                    answer += "L";
                }else{
                    if(hand.equals("right")){
                        rightCurr = new int[] {numLoca[0], numLoca[1]};
                        answer += "R";
                    }else{
                        leftCurr = new int[] {numLoca[0], numLoca[1]};
                        answer += "L";
                    }
                } 
                
            }
        }
        
        return answer;
    }
}