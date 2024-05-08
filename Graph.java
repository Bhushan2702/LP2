import java.util.*;
import java.io.*;

public class Graph {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w ;
        }
    }

    static void createGraph(ArrayList<Edge> graph[], String filename) {
        try {
            File file = new File(filename);
            Scanner sc = new Scanner(file);

            for (int i = 0; i < graph.length; i++) {
                graph[i] = new ArrayList<>();
            }

            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(" ");
                int src = Integer.parseInt(parts[0]);
                int dest = Integer.parseInt(parts[1]);
                int wt = Integer.parseInt(parts[2]);
                graph[src].add(new Edge(src, dest, wt));
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public static void bfs(ArrayList<Edge> graph[], int V, int start) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                System.out.print(curr + " ");
                visited[curr] = true;
                for (Edge e : graph[curr]) {
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        if (visited[curr]) {
            return;
        }
        System.out.print(curr + " ");
        visited[curr] = true;
        for (Edge e : graph[curr]) {
            dfs(graph, e.dest, visited);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];

        System.out.println("Enter the filename to read the graph data from:");
        String filename = sc.nextLine();
        createGraph(graph, filename);

        System.out.println("Choose traversal method:");
        System.out.println("1. BFS (Breadth-First Search)");
        System.out.println("2. DFS (Depth-First Search)");
        int choice = sc.nextInt();

        System.out.println("Enter starting node:");
        int start = sc.nextInt();
        
        
        if (choice == 1) {
            bfs(graph, V, start);
        } else if (choice == 2) {
            boolean visited[] = new boolean[V];
            dfs(graph, start, visited);
        } else {
            System.out.println("Invalid choice.");
        }
    
        sc.close();
    }
}
