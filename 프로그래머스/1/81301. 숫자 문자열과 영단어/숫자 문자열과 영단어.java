import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Set<String> set = new HashSet<>();
        set.add("zero");
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("four");
        set.add("five");
        set.add("six");
        set.add("seven");
        set.add("eight");
        set.add("nine");
        
        Map<String, String> map = new HashMap<>();
        map.put("zero","0");
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
        
        String res = "";
        String str = "";
        for(int i = 0; i < s.length(); i++){
            
            if(Character.isDigit(s.charAt(i))){
                res += s.charAt(i);
            }else{
                str += s.charAt(i);
                if(set.contains(str)){
                    res += map.get(str);
                    str = "";
                }
            }
        }
        
        return Integer.parseInt(res);
    }
}