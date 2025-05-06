class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int currentPower = health;
        
        for(int i = 0; i < attacks.length - 1; i++){
            
            // 공격 받음
            int attackTime = attacks[i][0];
            int attackPower = attacks[i][1];
            currentPower -= attackPower;
            if(currentPower <= 0){
                return -1;
            }
            
            // 다음 공격 때까지 회복
            int afterRecovery = attacks[i+1][0] - attacks[i][0] - 1;
            if(afterRecovery > 0){
                currentPower += afterRecovery * bandage[1];
                if(afterRecovery >= bandage[0]){
                    currentPower += (afterRecovery / bandage[0]) * bandage[2];
                }
                if(currentPower > health){
                    currentPower = health;
                }
            }
        }
        
        // 마지막 공격 받기
        currentPower -= attacks[attacks.length - 1][1];
        
        if(currentPower <= 0){
            return -1;
        }
        
        return currentPower;
    }
}