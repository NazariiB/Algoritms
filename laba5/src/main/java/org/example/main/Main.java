package org.example.main;

import org.example.algotitm.RabinKarp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception
    {
        RabinKarp algo = new RabinKarp();
        System.out.println("______Worth_case______");
        String text = Main.getText("src/main/java/org/example/sample/3.txt") ;
        String pattern = "not";
        algo.match(pattern, text);
        System.out.println();

        System.out.println("______Best_case______");
        pattern = "text";
        algo.match(pattern, text);

        System.out.println();
        System.out.println("______Average_case______");
        text = Main.getText("src/main/java/org/example/sample/2.txt");
        algo.match("cataloguers", text);

        System.out.println();
        algo.match("waiting", text);

        System.out.println();
        algo.match("instantly", text);

    }

    private static String getText(String path) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String text = reader.lines().collect(Collectors.joining());
        reader.close();
        return text;
    }
}
