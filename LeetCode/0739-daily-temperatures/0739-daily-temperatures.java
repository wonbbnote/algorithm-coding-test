class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];

        ArrayDeque<int[]> stack = new ArrayDeque<>();
        //stack.push(new int[] {temperatures[0], 0}); // {온도, idx}

        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];

            while(!stack.isEmpty() && stack.peek()[0] < temp){
                int[] popped = stack.pop();
                answer[popped[1]] = i - popped[1];
            }

            stack.push(new int[] {temp, i}); 
        }

        return answer;




        
    }
}