
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
        int minesCount;  //how many bombs.
        int rowCount;    //row of the game borad(array[][])
        int columnsCount; //
        int row;
        int col;
       
            rowCount = sc.nextInt();
            columnsCount = sc.nextInt();
            minesCount = sc.nextInt();
            Borde g1 = new Borde(minesCount, rowCount, columnsCount);
            g1.print();
     
            while (g1.getGameAlive()) {
                row = sc.nextInt();
                col = sc.nextInt();
                g1.open(row, col);
            }
   
        }

    }
