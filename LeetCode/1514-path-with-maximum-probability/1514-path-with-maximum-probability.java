import java.util.*;
class Solution {

    public class Node{
        int next;
        double succ;
        public Node(int next, double succ){
            this.next = next;
            this.succ = succ;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        ArrayList<Node>[] adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges.length; i++){
            adjList[edges[i][0]].add(new Node(edges[i][1], succProb[i]));
            adjList[edges[i][1]].add(new Node(edges[i][0], succProb[i]));
        }

        double[] success = new double[n+1];
        Arrays.fill(success, -1.0);
        success[start_node] = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Double.compare(o2.succ, o1.succ));
        pq.add(new Node(start_node, 1));

        while(!pq.isEmpty()){
            Node curr = pq.poll();

            if(success[curr.next] > curr.succ){
                continue;
            }

            for(Node next: adjList[curr.next]){
                if(success[next.next] < curr.succ * next.succ){
                    success[next.next] = curr.succ * next.succ;
                    pq.add(new Node(next.next, success[next.next]));
                }
            }

        }
        
        if(success[end_node] == -1.0){
            return 0;
        }

        return success[end_node];


        
    }
}