package amazin.traversal;

import java.util.LinkedList;
import java.util.Stack;


//https://www.youtube.com/watch?v=bIA8HEEUxZI
//https://www.youtube.com/watch?v=ZM-sV9zQPEs
//https://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-binary-tree/
public class DepthFirstSearch {

    int vertex;
    LinkedList<Integer> list[];

    public DepthFirstSearch(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i <vertex ; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source, int destination){

        //add forward edge
        list[source].addFirst(destination);
    }

    public void DFS(){
        System.out.print("Depth First Traversal: ");
        boolean[] visited = new boolean[vertex];
        Stack<Integer> stack = new Stack<Integer>();

        for(int startIndex=0; startIndex<vertex; startIndex++){
            if(visited[startIndex]==false) {
                stack.push(startIndex);
                visited[startIndex] = true;
                while (stack.isEmpty() == false) {
                    int nodeIndex = stack.pop();
                    System.out.print(nodeIndex + " ");
                    LinkedList<Integer> nodeList = list[nodeIndex];
                    for (int i = 0; i < nodeList.size(); i++) {
                        int dest = nodeList.get(i);
                        if (visited[dest] == false) {
                            stack.push(dest);
                            visited[dest] = true;
                        }
                    }
                }
            }
        }
        System.out.println();
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            LinkedList<Integer> nodeList = list[i];
            if(nodeList.isEmpty()==false) {
                System.out.print("source = " + i + " is connected to nodes: ");
                for (int j = 0; j < nodeList.size(); j++) {
                    System.out.print(" " + nodeList.get(j));
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(6);
        depthFirstSearch.addEdge(0, 1);
        depthFirstSearch.addEdge(0, 2);
        depthFirstSearch.addEdge(1, 2);
        depthFirstSearch.addEdge(1, 3);
        depthFirstSearch.addEdge(3, 4);
        depthFirstSearch.addEdge(2, 3);
        depthFirstSearch.addEdge(4, 0);
        depthFirstSearch.addEdge(4, 1);
        depthFirstSearch.addEdge(4, 5);
        depthFirstSearch.printGraph();
        depthFirstSearch.DFS();
    }
}