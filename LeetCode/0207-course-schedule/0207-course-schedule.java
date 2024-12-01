import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 인접리스트 맵으로 만들어보기
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            adj.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        // System.out.println(Arrays.toString(indegree));
        // System.out.println(adj);

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            count++;

            if(adj.containsKey(curr)){

                for(int next: adj.get(curr)){
                    indegree[next]--;
                    if(indegree[next] == 0){
                        queue.add(next);
                    }
                }
            }
        }
        
        return count == numCourses;
    }
}