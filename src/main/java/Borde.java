
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author אורח
 */
public class Borde {

    private int bord[][];    //the game bord basic
    private int minesCount; //how many bombs.
    private int rowCount;     //row of the game borad(array[][])
    private int columnsCount; //column of the game borad(array[][])
    private boolean isBoom = false;
    private int countBoom = 0;
    private int row; //for random loction on the board
    private int col; //for random loction on the board
    Random rand = new Random(); //for the random order of the mines on the bord[][]

    /**
     * *
     * i did constructor to reduce the set\get for the board and just do it for
     * me
     *
     * @param minesCount-how much mines(bombs) we have
     * @param rowCount-
     * @param columnsCount
     */
    public Borde(int minesCount, int rowCount, int columnsCount) {
        this.isBoom = false;
        this.minesCount = minesCount;
        this.rowCount = rowCount;
        this.columnsCount = columnsCount;
        this.bord = new int[rowCount][columnsCount];
        for (int temp9 = 0; temp9 < minesCount; temp9++) {
            row = rand.nextInt(rowCount);
            col = rand.nextInt(columnsCount);
            bord[row][col] = -99; //the id of the mines
            print();
        }
    }

    /**
     * *
     *
     */
    public void bomb() {

    }

    /**
     * *
     *
     */
    public void nighboorBomb() {
        int temp1;
        int temp2;
        int count = 0;
        if (bord[row][col] == -99) {
            isBoom = true;
            this.countBoom = countBoom + 1;
        }
        for (temp1 = -1; temp1 < 2; temp1++) {
            if (temp1 == -1 && rowCount == 0) {
                continue;
            }
            if (rowCount == bord.length - 1 && temp1 == 1) {
                continue;
            }

            for (temp2 = -1; temp2 < 2; temp2++) {

                if (temp2 == -1 && columnsCount == 0) {
                    continue;

                }
                if (columnsCount == bord[1].length - 1 && temp2 == 1) {
                    continue;
                }
                if (temp1 == 0 && temp2 == 0) {
                    continue;
                }
                count++;
            }
            bord[rowCount][columnsCount] = count;
            print();
        }
    }

    /**
     * *
     * print-that method for display the board more easy 
     * temp1,temp2-temporary variable for the "for"
     * 
     */
    public void print() {
        int temp1;
        int temp2;        
        for (temp1 = 0; temp1 < this.rowCount-1; temp1++) {
            for (temp2 = 0; temp2 < this.columnsCount-1; temp2++) {
                System.out.print(this.bord[temp1][temp2]);
            }

        }
    }
//set+get

    public int[][] getBord() {
        return bord;
    }

    public void setBord(int[][] bord) {
        this.bord = bord;
    }

    public int getMinesCount() {
        return minesCount;
    }

    public void setMinesCount(int minesCount) {
        this.minesCount = minesCount;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getColumnsCount() {
        return columnsCount;
    }

    public void setColumnsCount(int columnsCount) {
        this.columnsCount = columnsCount;
    }

    public boolean isIsBoom() {
        return isBoom;
    }

    public void setIsBoom(boolean isBoom) {
        this.isBoom = isBoom;
    }

    public int getCountBoom() {
        return countBoom;
    }

    public void setCountBoom(int countBoom) {
        this.countBoom = countBoom;
    }

}
