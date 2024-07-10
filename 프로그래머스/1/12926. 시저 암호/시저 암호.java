class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        char[] charArr = s.toCharArray();
        
        for(int i = 0; i < charArr.length; i++){
            
            if(charArr[i] >= 65 && charArr[i] <= 90){
                int newInt =  charArr[i] + n;
                if(newInt > 90){
                    newInt -= 26;
                }
                answer += (char) newInt;
            }else if(charArr[i] >= 97 && charArr[i] <=122){
                int newInt = charArr[i] + n;
                if(newInt > 122){
                    newInt -= 26;
                }
                answer += (char) newInt;
            }else{
                answer += charArr[i];
            }
            
            
            
        }
        
        return answer;
    }
}