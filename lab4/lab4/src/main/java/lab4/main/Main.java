package lab4.main;

import lab4.logic.Logic;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        Logic algo = new Logic();

        algo.readDocuments("D:/NAZIK/AlgoLabs/lab4/lab4/src/main/java/lab4/examples/3.txt");
        algo.getResult();
    }
}
