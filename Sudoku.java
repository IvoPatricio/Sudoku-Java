import java.util.Scanner;
import java.util.HashMap;


public class Sudoku {
    Scanner _scanner = new Scanner(System.in);
    int[] _userInput= new int[2];

    public void ft_parseUserInput()
    {
        String strUserInput = "";

        try
        {
            strUserInput = _scanner.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Error\n");
            _scanner.nextLine();
            return ;
        }

        if (strUserInput.length() != 3 || !Character.isDigit(strUserInput.charAt(0)) ||
            strUserInput.charAt(1) != ' ' || !Character.isDigit(strUserInput.charAt(2)))
        {
            System.out.println("Error\n");
            return ;
        }
    }
    public static void main(String[] args)
    {
        Sudoku sudokuGame = new Sudoku();
        boolean isrunning = true;
        while (isrunning)
        {
            ;
        }
        sudokuGame._scanner.close();
    }
}
