class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1단계 
        String step1 = new_id.toLowerCase();
        
        // 2단계
        String step2 = step1.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계
        String step3 = step2.substring(0, 1);
        for(int i = 1; i < step2.length(); i++){
            String s = step2.substring(i, i+1);
            String before = step2.substring(i-1, i);
            if(s.equals(".") && before.equals(".")){
                continue;
            }
            step3 += s;
        }
        
        
        // 4단계
        String step4 = step3;
        if(step4.length() >= 1 && step4.substring(0, 1).equals(".")){
            step4 = step4.substring(1, step4.length());
        }
        if(step4.length() >= 1 && step4.substring(step4.length()-1).equals(".")){
            step4 = step4.substring(0, step4.length()-1);
        }
        
        
        // 5단계
        String step5 = (step4.isEmpty()) ? "a" : step4;
        // String step5 = step4;
        // if(step5.equals("")){
        //     for(int i = 0; i < new_id.length(); i++){
        //         step5 += "a";
        //     }
        // }
        
        // 6단계
        String step6 = step5;
        if(step5.length() >= 16){
            step6 = step5.substring(0, 15);
            if(step6.substring(14).equals(".")){
                step6 = step6.substring(0, 14);
            }
        }

        
        // 7단계
        String step7 = step6;
        if(step7.length() <= 2 && step7.length() >= 1){
            String last = step7.substring(step7.length()-1);
            while(step7.length() < 3){
                step7 += last;
            }
        }
        
        
        return step7;
    }
}