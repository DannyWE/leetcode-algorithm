package dataStructure.tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(comparator);
        int Q = sc.nextInt(); // the number of queries
        int queryType = 0;
        int element = 0;
        while(Q-->0) {
            queryType = sc.nextInt();
            switch(queryType){
                case 1:
                    element = sc.nextInt();
                    minHeap.add(element);
                    break;
                case 2:
                    element = sc.nextInt();
                    minHeap.remove(element);
                    break;
                case 3:
                    System.out.println(minHeap.peek());
            }
        }
    }
}
