package lab4.logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Logic {

    private int res = 0;

    private final ArrayList<ArrayList<String>> matrix = new ArrayList<>();

    public void readDocuments(String path) throws IOException {
        File file = new File(path);
        Scanner dataScanner = new Scanner(file);

        for(int i = -1; dataScanner.hasNextLine(); ++i) {
            String temp = dataScanner.nextLine();
            String[] data = temp.split("");
            if((int) data[0].charAt(0) < 58) {
                int count = Integer.parseInt(temp.split(" ")[0]);
                while (count-- > 0)
                    matrix.add(new ArrayList<>());
                continue;
            }
            for( int j = 0; j < data.length; ++j) {
                matrix.get(j).add(data[j]);
            }
        }
    }

    private void recursFun(int x, int y) {
        var nextSteps= getNextSteps(x, y);
        System.out.println(nextSteps);
        for(int i = 0; i < nextSteps.size(); ++i) {
            if(nextSteps.get(i).equals((matrix.size() - 1) + " " + (matrix.get(0).size() - 1)) ||
                    nextSteps.get(i).equals((matrix.size() - 1) + " " + 0)) {
                res++;
                continue;
            }
            List<Integer> cords = Arrays.stream(nextSteps.get(i).split(" ")).map(Integer::parseInt).toList();
            recursFun(cords.get(0), cords.get(1));
        }
    }

    private ArrayList<String> getNextSteps(int x, int y) {
        String letter = matrix.get(x).get(y);
        ArrayList<String> result = new ArrayList<>();
        for(int xT = x + 1; xT < matrix.size(); ++xT) {
            for (int yT = 0; yT < matrix.get(0).size(); ++yT) {
                if(matrix.get(xT).get(yT).equals(letter)) {
                    if(xT == matrix.size() - 1) {
                        if(yT == 0 || yT == matrix.get(0).size() - 1) {
                            result.add(xT + " " + yT);
                        }
                    } else {
                        result.add(xT + " " + yT);
                    }
                }
            }
        }
        if(!result.contains(x + 1 + " " + y)) {
            if(x + 1 == matrix.size() - 1) {
                if(y == matrix.get(0).size() - 1 || y == 0) {
                    result.add(x + 1 + " " + y);
                }
            } else {
                result.add(x + 1 + " " + y);
            }
        }
        return result;
    }

    public void getResult() throws IOException {
        for (int i = 0; i < matrix.get(0).size(); ++i) {
            recursFun(0, i);
        }
        safeRes();
    }

    private void safeRes() throws IOException {
        StringBuffer result = new StringBuffer();
        result.append(res);
        Files.write(Paths.get("D:/NAZIK/AlgoLabs/lab4/lab4/src/main/java/lab4/result/res.txt"),
                Collections.singleton(result));
        res = 0;
    }

}
