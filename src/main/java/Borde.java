
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
    private int rowCount; //row of the game borad(array[][])
    private int columnsCount; //column of the game borad(array[][])
    int MAXRows = 50;//the range of the input of the borad 
    int MAXColumns = 50; //the range of the input of the borad
    private boolean isBoom = false;
    private int countBoom = 0;
    private int row1;  //loction on the board
    private int col1; // loction on the board
    private int row; //for random loction on the board
    private int col; //for random loction on the board
    private int opencellsCount;//all the cell thay are not mines
    Random rand = new Random(); //for the random order of the mines on the bord[][]

    /**
     * *
     * i did constructor to reduce the set\get for the board and just do it for
     * me
     *
     * @param minesCount-how much mines(bombs) we have
     * @param rowCount - rows of the game board
     * @param columnsCount- columns of the game board
     * @param opencellsCount-the clear cells without mines
     */
    public Borde(int minesCount, int rowCount, int columnsCount) {
        this.isBoom = false;
        this.opencellsCount = (this.rowCount * this.columnsCount) - this.minesCount;
        this.minesCount = minesCount;
        this.rowCount = rowCount;
        this.columnsCount = columnsCount;
        this.bord = new int[rowCount][columnsCount];
        for (int temp9 = 0; temp9 < minesCount; temp9++) {
            row1 = rand.nextInt(rowCount);
            col1 = rand.nextInt(columnsCount);
            bord[row1][col1] = 9; //the id of the mines
            print();
        }
    }

    public int getOpencellsCount() {

        return opencellsCount;
    }

    public void setOpencellsCount(int opencellsCount) {
        opencellsCount = rowCount * columnsCount - minesCount;
        this.opencellsCount = opencellsCount;
    }

    public void win(int row, int col) {
        if (opencellsCount == 0) {
            System.out.println("you win");
        }
    }




    public void Boom() {
        if (bord[row][col] == -99) {
            isBoom = true;
        }
    }

    /**
     * *
     * method that chack how much friends we have around the mines and count
     * them into te loction that te player pressed temp1-temp temp2-tmporary
     *
     *
     * @param row
     * @param col
     */
    public void nighboorBomb(int row, int col) {
        int temp1;
        int temp2;
        int count = 0;
        if (bord[row][col] == 9) {
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
                if (bord[row + temp1][col + temp2] == 9) {
                    count = count + 1;
                }
            }
        }
            print();
    }

    private void print() {
        int temp1;
        int temp2;
        for (temp1 = 0; temp1 < this.rowCount - 1; temp1++) {
            for (temp2 = 0; temp2 < this.columnsCount - 1; temp2++) {
                System.out.print(bord[rowCount][columnsCount]);
            }
            System.out.println();
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
