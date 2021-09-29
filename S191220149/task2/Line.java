package task2;

import java.util.*;

public class Line {

    public Line(int length) {
        this.positions = new Position[length];
    }

    private Position[] positions;

    public void put(Linable linable, int i) {
        if (this.positions[i] == null) {
            this.positions[i] = new Position(null);
        }
        this.positions[i].setLinable(linable);
    }

    public void randomPut(Linable[] linables){
        int len = linables.length;
        int[] source = new int[len];
        for (int i = 0; i < len; i++) {
            source[i] = i;
        }
        int[] result = new int[len];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < linables.length; i++) {
            index = Math.abs(rd.nextInt() % len);
            len--;
            result[i] = source[index];
            source[index] = source[len];
        }
        for(int i=0;i<linables.length;i++)
        {
            this.put(linables[i], result[i]);
        }
    }

    public Linable get(int i) {
        if ((i < 0) || (i > positions.length)) {
            return null;
        } else {
            return positions[i].linable;
        }
    }

    class Position {

        private Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    @Override
    public String toString() {
        String lineString = "\t";
        for (Position p : positions) {
            lineString += p.linable.toString();
        }
        return lineString;
    }

    public Linable[] toArray() {
        Linable[] linables = new Linable[this.positions.length];

        for (int i = 0; i < linables.length; i++) {
            linables[i] = positions[i].linable;
        }

        return linables;

    }

}
