
import java.util.Random;
import java.util.Scanner;

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
    private int displaybord[][]; //the actual bord that the player will see
    private int minesCount; //how many bombs.
    private int rowCount; //row of the game borad(array[][])
    private int columnsCount; //column of the game borad(array[][])
    private boolean isBoom = false;
    private int countBoom = 0;
    private int row1;  //loction on the board
    private int col1; // loction on the board
    private int row; //for random loction on the board
    private int col; //for random loction on the board
    private boolean gameAlive = true;
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
     * @param opencellsCount - the clear cells without mines
     */
    public Borde(int minesCount, int rowCount, int columnsCount) {
        this.isBoom = false;
        this.opencellsCount = (this.rowCount * this.columnsCount) - this.minesCount;
        this.minesCount = minesCount;
        this.rowCount = rowCount;
        this.columnsCount = columnsCount;
        this.bord = new int[rowCount][columnsCount];
        this.displaybord = new int[rowCount][columnsCount];
        for (int temp9 = 0; temp9 < minesCount; temp9++) {
            row1 = rand.nextInt(rowCount);
            col1 = rand.nextInt(columnsCount);
            bord[row1][col1] = 9; //the id of the mines

        }
        notopen();
    }

    public void getOpencellsCount() {
        int sum;
        sum = (rowCount * columnsCount) - minesCount;
        System.out.println((sum));
    }

    public void setOpencellsCount(int opencellsCount) {
        this.opencellsCount = opencellsCount;
    }

    //method that check how much friends we have around the mines and count
    //them into the location that the player pressed temp1-temp temp2-temporary
    public int nighboorBomb(int row, int col) {
        int temp1;
        int temp2;
        int count = 0;
        if (boom(row, col)) {
            bord[row][col] = count;
            return 9;
        }
        for (temp1 = -1; temp1 < 2; temp1++) {
            if (temp1 == -1 && row == 0) {
                continue;
            }
            if (row == bord.length - 1 && temp1 == 1) {
                continue;
            }

            for (temp2 = -1; temp2 < 2; temp2++) {

                if (temp2 == -1 && col == 0) {
                    continue;
                }
                if (col == bord[1].length - 1 && temp2 == 1) {
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
        bord[row][col] = count;
        return count;
    }

    /**
     * *
     *
     * @param row- some index of row
     * @param col- some index of
     * @return
     */
    public boolean boom(int row, int col) {
        if (bord[row][col] == 9) {
            return true;
        }
        return false;
    }

    public void notopen() {
        int temp1;
        int temp2;
        for (temp1 = 0; temp1 < rowCount; temp1++) {
            for (temp2 = 0; temp2 < columnsCount; temp2++) {
                displaybord[temp1][temp2] = -1;
            }
        }
    }

    public void click(int row, int col) {
        if (bord[row][col] == 9) {
            finshed();
            return;
        }
        if (isWin()){
        }
        open(row, col);
    }

    public void open(int row, int col) {
        if (displaybord[row][col] != -1) {
            return;
        }

        displaybord[row][col] = nighboorBomb(row, col);
        opencellsCount = opencellsCount - 1;
        
        if (displaybord[row][col] == 0) {
            openempty(row, col);
        }
        print();

    }

    public void print() {
        int temp1;
        int temp2;
        for (temp1 = 0; temp1 < rowCount; temp1++) {
            for (temp2 = 0; temp2 < columnsCount; temp2++) {
                System.out.print(displaybord[temp1][temp2] + ",");
            }
            System.out.println();
        }
    }

    private void openempty(int row, int col) {

        for (int temp1 = -1; temp1 < 2; temp1++) {
            if (temp1 == -1 && row == 0) {
                continue;
            }
            if (row == bord.length - 1 && temp1 == 1) {
                continue;
            }

            for (int temp2 = -1; temp2 < 2; temp2++) {

                if (temp2 == -1 && col == 0) {
                    continue;
                }
                if (col == bord[1].length - 1 && temp2 == 1) {
                    continue;
                }
                if (temp1 == 0 && temp2 == 0) {
                    continue;
                }
                if (displaybord[row + temp1][col + temp2] != -1) {
                    continue;
                }
                open(row + temp1, col + temp2);

            }
        }
    }

    public boolean getGameAlive() {
        return gameAlive;
    }

    public void setGameAlive(boolean gameAlive) {
        this.gameAlive = gameAlive;

    }

    private void finshed() {
        if (isWin() == false) {
            System.out.println("you lose");
            rowCount = 0;
            columnsCount = 0;
            minesCount = 0;
            System.out.println("gameover my friend");
        }
        System.out.println("you win");
        rowCount = 0;
        columnsCount = 0;
        minesCount = 0;
        System.out.println("gameover my frind");
    }

    
    
    private boolean isWin() {
        if (opencellsCount == 0&& countBoom == 0) {
            return true;
        }
        return false;
    }
}
