package task3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int num=64;

        int height=8;

        int width=8;

        Monster.generateMonsters(num);

        Matrix matrix=new Matrix(height, width);

        matrix.randomPut(Monster.getMonsters());

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new SelectionSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.matrixSort(matrix);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
