
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<int[]> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings.add(new int[]{start, end});
        }

        System.out.println(maxMeetings(meetings));

    }

    public static int maxMeetings(List<int[]> meetings){
        meetings.sort((a, b) -> a[1] == b[1] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEndTime = 0;

        for (int[] meeting: meetings){
            int start = meeting[0];
            int end = meeting[1];
            if(start >= lastEndTime){
                count++;
                lastEndTime = end;
            }
        }
        return count;
    }
}
