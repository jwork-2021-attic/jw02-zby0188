package task3;

import java.util.*;

import task3.Line.Position;

public class Monster implements Linable {

    private final int r;
    private final int g;
    private final int b;
    private final int rank;
    private static Monster[] monsters;

    static { monsters = null;}

    private Position position;

    Monster(int r, int g, int b,int rank) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.rank=rank;
    }

    private static int[] randomList(int num) {
        int len = 256;
        int[] result = new int[num];
        Random rd = new Random();
        int source= 0;
        source=len-num-1;
        int index = 0;
        index = Math.abs(rd.nextInt() % source);
        for (int i = 0; i < num; i++) {
            result[i] = index+i;
        }
        return result;
    }

    public static void generateMonsters(int num) {
        Monster.monsters = new Monster[num];
        int[] rs = Monster.randomList(num);
        int[] gs = Monster.randomList(num);
        int[] bs = Monster.randomList(num);
        for (int i = 0; i < num; i++) {
            Monster.monsters[i] = new Monster(rs[i], gs[i], bs[i],i);
        }
    }

    public static Monster[] getMonsters() {
        return monsters;
    }

    public static Monster getMonsterByRank(int rank) {
        return Monster.monsters[rank-1];
    }

    public int rank() {
        return this.rank+ 1;
    }

    @Override
    public String toString() {
         return "\033[48;2;" + this.r + ";" + this.g + ";" + this.b + ";38;2;0;0;0m     " +"  \033[0m";
        
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void swapPosition(Monster another) {
        Position p = another.position;
        this.position.setLinable(another);
        p.setLinable(this);
    }

    @Override
    public int getValue() {
        return this.rank();
    }

}