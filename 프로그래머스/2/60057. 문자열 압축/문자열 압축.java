class Solution {
    public int solution(String s) {
        int answer = 0;
        
        // 1개부터 s의 길이 단위까지 자르기
        String[] resultArr = new String[s.length()];
        int[] lenArr = new int[s.length()];
        
        // 각 단위마다 반복되는 문자열에 따라 압축해보기
        for(int i = 1; i <= s.length(); i++){
            resultArr[i-1] = compressedStr(i, s);
            lenArr[i-1] = resultArr[i-1].length();
        }
        
        // 해당 압축된 문자열의 길이 비교하기
        int min = lenArr[0];
        for(int su: lenArr){
            if(su < min){
                min = su;
            }
        }
        answer = min;
        
        return answer;
    }
    
    public String compressedStr(int num, String s){
        
        String str = s.substring(0, num);
        int cnt = 0;
        String res = "";
        boolean confirm = false;
        int nth = 0;
        
        for(int i = 0; i < s.length(); i += num){
            nth++;
            
            if(i + num > s.length()){
                if(cnt > 1){
                    res += cnt + "";
                }
                res += str;
                break;
            }
            
            String caseS = s.substring(i, i+num);
            // System.out.println("i: " + i + ", caseS: "+caseS);

            if(str.equals(caseS)){ // 연속일 때 
                cnt++;
                
            }else if(cnt == 1){ // 하나뿐일 때
                res += str;
                str = caseS;
            
            }else{ // 연속으로 하다가 끝났을 때
                res += cnt + "";
                res += str;
                cnt = 1;
                str = caseS;
            }
            
            if(i + num == s.length()){
                if(cnt > 1){
                    res += cnt + "";
                }
                res += str;
                break;
            }
            
        }
        // System.out.println("res: "+ res);
        
        if(s.length() % num != 0){
            res += s.substring(s.length() - s.length() % num);
        }
        
        return res;
        
    }
}