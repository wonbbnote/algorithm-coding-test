class Solution {
    public boolean isValid(String s) {

        Stack<String> stack = new Stack<>();

        char[] char_arr = s.toCharArray();

        for(char c: char_arr){
            if(c == '('){
                stack.push(")");
            }else if(c == '{'){
                stack.push("}");
            }else if(c == '['){
                stack.push("]");
            }else{
                if(stack.size() != 0){
                    if(!Character.toString(c).equals(stack.pop())){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        if(stack.size() != 0){
            return false;
        }

        return true;
    }
}