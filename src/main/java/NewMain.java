
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

        int minesCount = 5;  //how many bombs.
        int rowCount = 5;    //row of the game borad(array[][])
        int columnsCount = 5; //

        Borde g1 = new Borde(minesCount, rowCount , columnsCount);
        g1.print();

    }
}
