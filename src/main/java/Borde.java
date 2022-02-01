
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
    private final int minRow=2;//The minimum can be entered on the board   
    private final int minCol=2;//The minimum can be entered on the board   
    private final int minCMines=1; //The minimum can be entered on the board   
    private final int maxRow = 50; //The maximum can be entered on the board
    private final int maxcol = 50; // The maximum can be entered on the board
    private final int maxmines=49; //The maximum can be entered on the board   
    private int row1;  //loction on the board for input mines on board 
    private int col1; // loction on the board for input mines on board
    private int row; //input of loction on the board
    private int col; //input of loction on the board
    private boolean gameAlive = true;
    private int opencellsCount = 0;//all the cell thay are not mines
    private String answer; //for restart game
    Random rand = new Random(); //for the random order of the mines on the bord[][]

    /**
     * *
     * i did constructor to reduce the set+get for the board and just do it for
     * me
     *
     * @param minesCount-how much mines(bombs) we have
     * @param rowCount - rows of the game board
     * @param columnsCount- columns of the game board
     * @param opencellsCount - the clear cells without mines
     */
    public Borde(int minesCount, int rowCount, int columnsCount) {
        isValid(rowCount,columnsCount,minesCount); //Checks the information the player has entered if it is correct
     
        creategame(rowCount, columnsCount, minesCount);//method who really create the board 
        notopen(rowCount,columnsCount); // for display ,what the player will see 
    }
    
    private void creategame(int rowCount,int columnsCount,int minesCount) {
        this.rowCount = rowCount;
        this.columnsCount = columnsCount;
        this.minesCount = minesCount;
        this.isBoom = false;
        this.bord = new int[rowCount][columnsCount];
        this.displaybord = new int[rowCount][columnsCount];
        for (int temp9 = 0; temp9 < minesCount; temp9++) {
            row1 = rand.nextInt(rowCount);
            col1 = rand.nextInt(columnsCount);
            bord[row1][col1] = 9;
        }
    }

    /**
     * *
     * how the player will see the board
     *
     * @param temp1-temporary
     * @param temp2-temporary
     */
    public final void notopen(int rowCount,int columnsCount) {
        int temp1;
        int temp2;
        for (temp1 = 0; temp1 < rowCount; temp1++) {
            for (temp2 = 0; temp2 < columnsCount; temp2++) {

                displaybord[temp1][temp2] = -1;
            }
        }
    }

    public int getOpencellsCount() {
        opencellsCount = (rowCount * columnsCount) - minesCount;
        return opencellsCount;
    }

    public void setOpencellsCount(int opencellsCount) {
        this.opencellsCount = opencellsCount;
    }

    /**
     * *
     * method that check how much friends we have around the mines and count
     * them into the location that the player pressed temp1-temp temp2-temporary
     *
     * @param row-some index on the board
     * @param col-some index on the board
     * @param temp1- Temporary variable
     * @param temp2- Temporary variable
     * @return
     */
    //borad of the admin
    public int nighboorBomb(int row, int col) {
        int temp1;
        int temp2;
        int count = 0;
        if (bord[row][col] == 9) {
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
     * this function check if the location is mine
     *
     * @param row- some index of row
     * @param col- some index of column
     * @return - false or true if this location a bomb
     */
    public boolean boom(int row, int col) {
        if (displaybord[row][col] == 9) {
            isBoom = true;
            return true;
        }
        return false;
    }

    /**
     * *
     *
     * @param row- location the player
     * @param col- location that the player take
     */
    public void click(int row, int col) {
        open(row, col);
        if (boom(row, col) == true) {
            openall(isBoom);
            return;
        }
        if (isWin() == true) {
            System.out.println("you win");
            gameAlive = false;
            return;
        }

    }

    /**
     *
     *
     * @param row
     * @param col
     */
    public void open(int row, int col) {
        if (displaybord[row][col] != -1 && bord[row][col] == 9 && displaybord[row][col] == bord[row][col]) {
            return;
        }
        displaybord[row][col] = nighboorBomb(row, col);
        this.opencellsCount = opencellsCount - 1;

        if (displaybord[row][col] == 0) {
            openEmptyCells(row, col);
        }
    }

    /**
     * *
     * the method display the game board
     *
     * @temp1- Temporary variable
     * @temp2 -Temporary variable
     */
    public void print() {
        int temp1;
        int temp2;
        for (temp1 = 0; temp1 < rowCount; temp1++) {
            for (temp2 = 0; temp2 < columnsCount; temp2++) {
                System.out.print(displaybord[temp1][temp2] + ",");
                //System.out.print(bord[temp1][temp2]);
            }
            System.out.println();
        }
    }

    /**
     * *
     *
     * @param row
     * @param col
     */
    private void openEmptyCells(int row, int col) {
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
            return;
        }
    }

    public boolean getGameAlive() {
        return gameAlive;
    }

    public void setGameAlive(boolean gameAlive) {
        this.gameAlive = gameAlive;

    }

    /**
     * *
     * @param
     */
    private void openall(boolean isBoom) {
        for (int temp1 = 0; temp1 < rowCount; temp1++) {
            for (int temp2 = 0; temp2 < columnsCount; temp2++) {
                if (isBoom == true) {
                    displaybord[temp1][temp2] = nighboorBomb(row, col);
                    System.out.println("you lose game over");
                    gameAlive = false;
                    return;
                }
            }
        }

    }

    public void newnewgame(String answer) {
        if (answer.equals("no")) {
            System.out.println("goodbye my friend");
            return;
        }

        if (answer.equals("yes")) {
            System.out.println("let gooooo");
            gameAlive = true;
            rowCount = 0;
            columnsCount = 0;
            minesCount = 0;

        }

    }

    /**
     * *
     * this function check if after that one step the player won
     *
     * @return true or false
     */
    private boolean isWin() {
        if (this.opencellsCount == 0) {
            return true;
        }
        return false;
    }
    private void isValid(int rowCount,int columnsCount,int minesCount) {
        boolean isvalid = true;
        String error = "";
         if(rowCount<minRow){        
             error = error + "\n" + "your size of rows is bigger than" + minRow;
            isvalid = false;
         }
        if (rowCount > maxRow) {
            error = error + "\n" + "your size of rows is below than" + maxRow;
            isvalid = false;
        }
        if (columnsCount < minCol) {
          error=error+"your size of columns is below then " + minCol;
          isvalid=false;
        }
         if (columnsCount > maxcol) {
            error = error + "\n" + " your size of columns is bigger than" + maxcol;
            isvalid = false;
        }
        if (minesCount < minCMines) {
            error = error + "\n" + "You have no bombs or you have entered a number Below"+ minCMines;
            isvalid = false;
        }
        if (minesCount >= columnsCount * rowCount) {
            error = error + "you have too much mines its above the number of cells in the board";
            isvalid = false;
        }
        
        if (!isvalid) {
            throw new ArithmeticException(error);
        }
    }
}
