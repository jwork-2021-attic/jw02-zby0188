package task3;

import java.util.*;

public class Matrix {

    private final int height;
    private final int width;
    private Line[] lines;

    public Matrix(int height,int width) {
        this.height=height;
        this.width=width;
        lines = new Line[height];
        for(int i=0;i<height;i++){
            lines[i]=new Line(width);
        }
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
            index = Math.abs(rd.nextInt() % len--);
            result[i] = source[index];
            source[index] = source[len];
        }

        for(int i=0;i<linables.length;i++)
        {
            int h=result[i]/width;
            int w=result[i]%width;
            lines[h].put(linables[i], w);
        }
    }


    public int[] getRanks(){
        int[] ranks=new int[width*height];
        int index=0;
        for(Line l:lines){
            for(Linable li:l.toArray()){
                ranks[index]=li.getValue();
                index++;
            }
        }
        return ranks;
    }

    @Override
    public String toString() {
        String res="";
        for(Line l:lines){
            res+=l.toString();
            res+="\n";
        }
        return res;
    }
    
}