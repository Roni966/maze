package algorithms.search;
import algorithms.mazeGenerators.Position;

import java.io.*;
import java.util.*;

public class BestFirstSearch {

//    private LinkedList<Integer> adj[];
//
//    void BFS(Position pos, int n) {
//        // n is number of objects
//        // Mark all the vertices as not visited(By defaul tset as false)
//        boolean visited[] = new boolean[n];
//
//        // Create a queue for BFS
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//
//        // Mark the current node as visited and enqueue it
//        visited[s] = true;
//        queue.add(s);
//
//        while (queue.size() != 0) {
//            // Dequeue a vertex from queue and print it
//            s = queue.poll();
//            System.out.print(s + " ");
//
//            // Get all adjacent vertices of the dequeued vertex s
//            // If a adjacent has not been visited, then mark it
//            // visited and enqueue it
//            Iterator<Integer> i = adj[s].listIterator();
//            while (i.hasNext()) {
//                int n = i.next();
//                if (!visited[n]) {
//                    visited[n] = true;
//                    queue.add(n);
//                }
//            }
//        }
//    }
}
