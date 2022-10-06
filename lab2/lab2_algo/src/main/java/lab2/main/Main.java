package lab2.main;

import lab2.graph.Graph;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Graph graph = new Graph();
        graph.readDocuments("D:/NAZIK/AlgoLabs/lab2/lab2_algo/src/main/java/lab2/examples/1.txt");

        graph.getProperWay();
    }
}
//visa foreignpassport
//visa hotel
//visa bankstatement
//bankstatement nationalpassport
//hotel creditcard
//creditcard nationalpassport
//nationalpassport birthcertificate
//foreignpassport nationalpassport
//foreignpassport militarycertificate
//militarycertificate nationalpassport