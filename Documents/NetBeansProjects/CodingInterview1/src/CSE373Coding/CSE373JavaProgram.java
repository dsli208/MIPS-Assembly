package CSE373Coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSE373JavaProgram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edges = sc.nextInt();
        int vertices = sc.nextInt();
        ArrayList<Edge> edgeList = new ArrayList<Edge>();
        String placeholder = sc.nextLine();
        for (int n = 0; n < edges; n++) {
            String edgeBetweenVerticesString = sc.nextLine();
            String[] stringVertexPair = edgeBetweenVerticesString.split(" ");
            int[] vertexPair = new int[stringVertexPair.length];
            for (int i = 0; i < stringVertexPair.length; i++) {
                vertexPair[i] = Integer.parseInt(stringVertexPair[i]);
            }
            ArrayList<Integer> vertexPairList = new ArrayList<Integer>();
            for (int i = 0; i < vertexPair.length; i++) {
                vertexPairList.add(vertexPair[i]);
            }
            if (edgeList.isEmpty()) {
                edgeList.add(new Edge(vertexPairList));
            } else {
                for (int i = 0; i < vertexPair.length; i++) {
                    for (int j = 0; j < edgeList.size(); j++) {
                        if (edgeList.get(j).contains(vertexPair[i])) {
                            if (i == 0) {
                                edgeList.get(j).add(vertexPair[1]);
                            } else {
                                edgeList.get(j).add(vertexPair[0]);
                            }
                        } else {
                            Edge e = new Edge(vertexPairList);
                            edgeList.add(e);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < edgeList.size(); i++) {
            System.out.println(edgeList.get(i).toString());
        }
    }
}

class Edge {

    List<Integer> vertices;

    public Edge(List<Integer> vertexPair) {
        this.vertices = vertexPair;
    }

    public boolean contains(int i) {
        return this.vertices.contains(i);
    }

    public void add(int i) {
        this.vertices.add(i);
    }

    @Override
    public String toString() {
        return vertices.toString();
    }
}
