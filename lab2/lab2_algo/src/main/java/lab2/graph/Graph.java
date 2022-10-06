package lab2.graph;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private final HashMap<String, ArrayList<String>> vertex = new HashMap<>();

    public void addVertex(String key, String value) {
        if(vertex.containsKey(key)) {
            vertex.get(key).add(value);
        } else {
            ArrayList<String> temp =  new ArrayList<>();
            temp.add(value);
            vertex.put(key, temp);
        }
        if(!vertex.containsKey(value)) {
            ArrayList<String> temp =  new ArrayList<>();
            vertex.put(value, temp);
        }
    }

    private void recursive2(String v, HashMap<String, Boolean> visited)
    {
        visited.put(v, Boolean.TRUE);
        for (String x : vertex.get(v)) {
            if(!visited.get(x)) {
                recursive2(x, visited);
                System.out.println(x);
            }
        }
    }

    public void getProperWay() {
        HashMap<String, Boolean> visited = new HashMap<>();
        for (String v: vertex.keySet()) {
            visited.put(v, Boolean.FALSE);
        }
        recursive2("visa", visited);
        System.out.println("visa");
    }
}
