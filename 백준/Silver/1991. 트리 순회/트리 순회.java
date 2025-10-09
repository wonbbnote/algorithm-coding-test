
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static Node[] tree;

    static class Node{
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parentVal = st.nextToken().charAt(0);
            char leftVal = st.nextToken().charAt(0);
            char rightVal = st.nextToken().charAt(0);

            if(tree[parentVal - 'A'] == null){
                tree[parentVal - 'A'] = new Node(parentVal);
            }

            if(leftVal != '.'){
                tree[leftVal - 'A'] = new Node(leftVal);
                tree[parentVal - 'A'].left = tree[leftVal - 'A'];
            }

            if(rightVal != '.'){
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[parentVal - 'A'].right = tree[rightVal - 'A'];
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();

    }

    private static void postorder(Node node) {
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    private static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    private static void preorder(Node node) {
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }
}
