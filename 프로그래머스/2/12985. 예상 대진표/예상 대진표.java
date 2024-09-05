class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int round = 2;
        while(a != b){
            answer++;
            a = (a % round == 0) ? a/round : a / round + 1;
            b = (b % round == 0) ? b/round : b / round + 1;
        }
        

        return answer;
    }
}