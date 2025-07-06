import java.util.*;
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {

        int num = code.length;

        List<String> result = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        map.put("electronics", new ArrayList<>());
        map.put("grocery", new ArrayList<>());
        map.put("pharmacy", new ArrayList<>());
        map.put("restaurant", new ArrayList<>());
        
        
        for(int i = 0; i < num; i++){
            // 1. code
            if(code[i].length() == 0 || !code[i].matches("^[\\w]*$")){
                continue;
            }

            // 3. isActive
            if(!isActive[i]){
                continue;
            }

            // 2. category
            if(!map.containsKey(businessLine[i])){
                continue;
            }else{
                map.get(businessLine[i]).add(code[i]);
            }
        }


        // 정렬
        String[] categories = new String[]{"electronics", "grocery", "pharmacy", "restaurant"};
        for(String c: categories){
            List<String> codesList = map.get(c);
            if(codesList.size() > 0){
                Collections.sort(codesList);
                for(String codeName: codesList){
                    result.add(codeName);
                }
            }
        }
    
        return result;
        
    }
}