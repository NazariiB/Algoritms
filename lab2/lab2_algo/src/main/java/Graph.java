import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Graph {
    private final ArrayList<ArrayList<Integer>> vertex = new ArrayList<>();

    public void readGraph(String path) throws IOException {
        File file = new File(path);
        Scanner dataScanner = new Scanner(file);
        for(int x = 0; dataScanner.hasNextLine(); ++x) {
            vertex.add(new ArrayList<>());
            String data = dataScanner.nextLine();
            String[] temp = data.split("");
            for (int i = 0; i < temp.length; ++i) {
                int e = Integer.parseInt(temp[i]);
                if(e != 0)
                    vertex.get(x).add(i);
            }
        }
    }

    private void recursive(ArrayList<ArrayList<Integer> > g, int v, boolean[] visited)
    {
        visited[v] = true;
        for (int x : g.get(v)) {
            if (!visited[x]) {
                recursive(g, x, visited);
            }
        }
    }

    private int safeRes(int res) throws IOException {
        Files.write(Paths.get("D:/NAZIK/AlgoLabs/lab2/lab2_algo/src/main/java/examples/res.txt"),
                res != -1 ? ("The rooted vertex is: " + res).getBytes(): "There is no rooted vertex".getBytes());
        return res;
    }

    public int rootedVertex() throws IOException {
        int vertexCounter = vertex.size();

        boolean[] entered = new boolean[vertexCounter];
        int v = -1;

        for (int i = 0; i < vertexCounter; i++) {
            if (!entered[i]) {
                recursive(vertex, i, entered);
                v = i;
            }
        }

        boolean[] check = new boolean[vertexCounter];
        recursive(vertex, v, check);
        for (boolean val : check) {
            if (!val) {
                return safeRes(-1);
            }
        }
        return safeRes(v);
    }

    public void printVertex() {
        vertex.forEach(elem -> {
            elem.forEach(System.out::print);
            System.out.println();
        });
    }

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.readGraph("D:/NAZIK/AlgoLabs/lab2/lab2_algo/src/main/java/examples/2.txt");
        graph.printVertex();
        System.out.println("res: " + graph.rootedVertex());
    }

}
