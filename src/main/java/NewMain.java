
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

            Scanner sc=new Scanner(System.in);
            
            int minesCount = 5;  //how many bombs.
            int rowCount = 5;    //row of the game borad(array[][])
            int columnsCount = 5;
            int row1;
            int col1;
            row1 =sc.nextInt();
            col1=sc.nextInt();
            Borde g1 = new Borde(minesCount, rowCount, columnsCount);
            g1.print();
   
        
        
        
    }
}
