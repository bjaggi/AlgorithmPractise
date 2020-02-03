package amazin.traversal;
import java.util.LinkedList;


public class GraphDFSRecursion {

    static class Graph{
        int vertices;
        LinkedList<Integer>[] adjList;

        Graph(int vertices){
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i <vertices ; i++) {
                adjList[i] = new LinkedList<Integer>();
            }
        }
        public void addEgde(int source, int destination){
            adjList[source].addFirst(destination);
        }

        public void printGraph(){
            for (int i = 0; i <vertices ; i++) {
                if(adjList[i].size()>0) {
                    System.out.println("Vertex " + i + " is connected to: ");
                    for (int j = 0; j < adjList[i].size(); j++) {
                        System.out.print(adjList[i].get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }

        public void DFSRecursion(int startVertex){
            boolean [] visited = new boolean[vertices];
            dfs(startVertex, visited);
        }

        public void dfs(int start, boolean [] visited){
            visited[start] = true;
            System.out.print(start + " ");
            for (int i = 0; i <adjList[start].size() ; i++) {
                int destination = adjList[start].get(i);
                if(!visited[destination])
                    dfs(destination,visited);
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 6;
        Graph graph = new Graph(vertices);
        graph.addEgde(0, 1);
        graph.addEgde(0, 2);
        graph.addEgde(1, 2);
        graph.addEgde(1, 3);
        graph.addEgde(3, 4);
        graph.addEgde(2, 3);
        graph.addEgde(4, 0);
        graph.addEgde(4, 1);
        graph.addEgde(4, 5);
        graph.DFSRecursion(0);
    }
}