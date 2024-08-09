class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int select = 0;
        int value = 0;
        
        // 맨 앞 3개로 등비수열인지 등차수열인지 결정하기
        if(common[0] + common[2] == 2 * common[1]){
            select = 1;
            value = common[1] - common[0];
        }else if(common[0] * common[2] == common[1] * common[1]){
            select = 2;
            value = common[1] / common[0];
        }

        
        // 같으면? 2, 3, 4번째로? 한번더 확인
        
        // 맨마지막 수로 계산하기
        if(select == 1){
            answer = common[common.length - 1] + value;
        }else if(select == 2){
            answer = common[common.length - 1] * value;
        }
        
        
        return answer;
    }
}