import java.util.Scanner;
import java.util.HashMap;


public class Sudoku {
    Scanner _scanner = new Scanner(System.in);
    Integer _userInputMenu = -1;
    int[] _userInputSudoku= new int[2];
    int[][] _grid = new int[9][9];

    //Overloading in java doesnt allow me to use the same methods for overloading maybe a template?
    public String ft_safeTryCatchString()
    {
        try
        {
            return _scanner.nextLine();
        }
        catch (Exception e)
        {
            System.out.println("Error\n");
            _scanner.nextLine();
            return null;
        }
    }

    public Integer ft_safeTryCatchInt()
    {
        try
        {
            int num = _scanner.nextInt();
            _scanner.nextLine();
            return num;
        }
        catch (Exception e)
        {
            System.out.println("Error\n");
            _scanner.nextLine();
            return null;
        }
    }

    public void ft_parseUserInput()
    {
        String strUserInput = ft_safeTryCatchString();
        if (strUserInput == null)
            return ;

        if (strUserInput.length() != 3 || !Character.isDigit(strUserInput.charAt(0)) ||
            strUserInput.charAt(1) != ' ' || !Character.isDigit(strUserInput.charAt(2)))
        {
            System.out.println("Error");
            return ;
        }
    }

    public void GQ()
    {
        _grid = new int[9][9];
        String line = "";
        String[] numbers = new String[9];
        System.out.println("Enter the grid values!");
        for (int i = 0; i < 9; i++)
        {
            line = _scanner.nextLine().trim();
            numbers = line.split(" ");
        }

        for (int i = 0; i < _grid.length; i++)
        {
            
            for (int x = 0; x < _grid[i].length; x++)
            {
                ;
            }
            System.out.printf("%s", numbers[i]);
        }
    }

    public boolean ft_userInputChoice()
    {
        switch (_userInputMenu) 
        {
            case 0:
                return false;
            default:
                return true;
        }
    }

    public boolean ft_menu()
    {
        System.err.println("Escolha opcao: \r\n" + //
                        "1. 0 - Sair \r\n" + //
                        "2. 1 - Aplicar permutacao de dois numeros \r\n" + //
                        "3. 2 - Aplicar permutacao de duas linhas de uma mesma faixa horizontal \r\n" + //
                        "4. 3 - Aplicar permutacao de duas colunas de uma mesma faixa vertical \r\n" + //
                        "5. 4 - Aplicar permutacao de duas faixas horizontais\r\n" + //
                        "6. 5 - Aplicar permutacao de duas faixas verticais \r\n" + //
                        "7. 6 - Aplicar reflexao horizontal \r\n" + //
                        "8. 7 - Aplicar reflexao vertical\r\n" + //
                        "9. 8 - Indicar quadricula");
        
        _userInputMenu = ft_safeTryCatchInt();
        if (_userInputMenu == null || _userInputMenu < 0 || _userInputMenu > 8)
            return true;
        return ft_userInputChoice();
    }

    public static void main(String[] args)
    {
        Sudoku sudokuGame = new Sudoku();
        boolean isrunning = true;
        while (isrunning)
        {
            isrunning = sudokuGame.ft_menu();
        }
        sudokuGame._scanner.close();
    }
}
