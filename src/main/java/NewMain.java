
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author אורח
 */
public class NewMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a numbers for the board:;");
        int minesCount;
        /*
        how many bombs
         */
        int rowCount;
        /*
        rows of the game borad(array[][])
         */
        int columnsCount;
        /*
        cols of the game borad(array[][])
         */
        int row;
        /*
        index on the board
         */
        int col;
        /*
        index on the board
         */
        String answer;
        /*yes or no for restart new game*/
        int freespace;

        rowCount = sc.nextInt();
        columnsCount = sc.nextInt();
        minesCount = sc.nextInt();
        Borde g1 = new Borde(minesCount, rowCount, columnsCount);
        g1.print();

        freespace = g1.getOpencellsCount();
        while (g1.getGameAlive() == true) {
            row = sc.nextInt();
            col = sc.nextInt();
            g1.click(row, col);
        }
        System.out.println("do you want a new game?");
        answer = sc.nextLine();
        g1.newnewgame(answer);
    }
}
