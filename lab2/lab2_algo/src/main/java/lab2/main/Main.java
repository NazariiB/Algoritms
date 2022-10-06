package lab2.main;

import lab2.graph.Graph;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        boolean isNext = true;
        Scanner scanner = new Scanner(System.in);
        while (isNext) {
            System.out.println("Enter next documents:");
            String[] str = scanner.nextLine().split(" ");
            if(str.length == 1){
                System.out.println("the program no longer accepts data.\n");
                break;
            }
            graph.addVertex(str[0], str[1]);
        }
//        graph.addVertex("visa", "foreignpassport");
//        graph.addVertex("visa", "hotel");
//        graph.addVertex("visa", "bankstatement");
//        graph.addVertex("bankstatement", "nationalpassport");
//        graph.addVertex("hotel", "creditcard");
//        graph.addVertex("creditcard", "nationalpassport");
//        graph.addVertex("nationalpassport", "birthcertificate");
//        graph.addVertex("foreignpassport", "nationalpassport");
//        graph.addVertex("foreignpassport", "militarycertificate");
//        graph.addVertex("militarycertificate", "nationalpassport");

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