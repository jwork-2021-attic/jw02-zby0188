package task2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {

        int num=16;

        Monster.generateMonsters(num);

        Line line=new Line(num);

        line.randomPut(Monster.getMonsters());

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new SelectionSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.lineUp(line);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
