import java.util.*;
class Solution {
    
    public static final String[] wordArr = {"A", "E", "I", "O", "U"};
    // public static final String[] wordArr = {"A", "E"};
    public static List<String> answerList;
    // public static int answer;
    
    public int solution(String word) {
        // word = "AAAAE";
        answerList = new ArrayList<>();
        combination(word, 0, new StringBuilder());
        
        // System.out.println("answer:" + answerList.size());
        
        for(int i = 0; i < answerList.size(); i++){
            if(answerList.get(i).equals(word)){
                return i;
            }
        }
        
        return -1;
    
    }
    
    public boolean combination(String word, int start, StringBuilder wordCase){
        
        answerList.add(wordCase.toString());
        System.out.println(wordCase.toString());
        
        if(wordCase.length() == 5){
            return false;
        }
        
        for(int i = start; i < wordArr.length; i++){
            wordCase.append(wordArr[i]);
            if(!combination(word, start, wordCase)){
                wordCase.deleteCharAt(wordCase.length()-1);
            }else{
                break;
            }
        }
        
        return false;
        
    }
}