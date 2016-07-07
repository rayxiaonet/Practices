package net.rayxiao;

import java.util.Stack;

/**
 * Created by rxiao on 7/5/16.
 */
public class NQueen {
    public int count = 0;

    public static class Pos {
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return this.x + "_" + this.y;
        }

        public int x;
        public int y;
    }

    public static int W = 8;
    public static int H = 8;
    public static int DEPTH = 8;

    public static void main(String[] args) {
        NQueen nq = new NQueen();
        nq.iterInternal(0, new Stack<Pos>());
        System.out.println("count is:" + nq.count);

    }

    private void iterInternal(int lineNo, Stack<Pos> currentQueens) {
        if (lineNo > W) {
            return;
        }
        for (int i = 0; i < H; i++) {
            Pos newPos = new Pos(lineNo, i);
            if (valid(currentQueens, newPos)) {
                if (currentQueens.size() >= DEPTH - 1) {
                    saveResult(currentQueens, newPos);
                } else {
                    currentQueens.push(newPos);
                    iterInternal(lineNo + 1, currentQueens);
                    currentQueens.pop();
                }
            } else {
                //not a valid position to place new queen, move to next
            }
        }


    }

    private String currentStack(Stack<Pos> currentQueens) {
        StringBuffer sb = new StringBuffer(currentQueens.size() + ":   ");
        for (Pos p : currentQueens) {
            sb.append(p).append(" , ");
        }
        ;
        return sb.toString();

    }

    private void saveResult(Stack<Pos> currentQueens, Pos last) {
        count++;
        System.out.println(currentStack(currentQueens) + "  ** " + last);
    }

    private boolean valid(Stack<Pos> currentQueens, Pos newQueen) {
        for (Pos p : currentQueens) {
            if (p.x == newQueen.x || p.y == newQueen.y ||
                    (p.x - newQueen.x) == (p.y - newQueen.y) ||
                    (p.x - newQueen.x) == (newQueen.y - p.y)
                    ) {
                //System.out.println("invalid position:"+p+"   "+newQueen);
                return false;
            }
        }
        //System.out.println("Found Valid position:"+currentStack(currentQueens)+"   "+newQueen);

        return true;
    }
}
