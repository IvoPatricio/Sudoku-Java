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
            System.err.println("Error: Invalid String input\n");
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
            System.err.println("Error: Invalid Integer input\n");
            _scanner.nextLine();
            return null;
        }
    }
    
    public void ft_checkGrid_Rows_Columns(int[][] tempgrid)
    {
        for (int x = 0; x < tempgrid.length; x++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tempgrid[x].length; i++)
            {
                map.put(tempgrid[x][i], map.getOrDefault(tempgrid[x][i], 0) + 1);
            }
            for (int key = 1; key <= 9; key++)
            {
                if (map.getOrDefault(key, 0) == 0)
                {
                    System.err.println("Error: Invalid Grid Rows");
                    return ;
                }
            }
        }

        for (int x = 0; x < tempgrid.length; x++)
        {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < tempgrid.length; i++)
            {
                map.put(tempgrid[i][x], map.getOrDefault(tempgrid[i][x], 0) + 1);
            }
            for (int key = 1; key <= 9; key++)
            {
                if (map.getOrDefault(key, 0) == 0)
                {
                    System.err.println("Error: Invalid Grid Columns");
                    return ;
                }
            }
        }
    }

    public void ft_userNewGrid()
    {
        int[][] tempgrid = new int[9][9];
        String[] numbers = new String[9];
        String line = "";
        for (int i = 0; i < 9; i++)
        {
            line = _scanner.nextLine().trim();
            numbers = line.split(" ");
        }

        for (int i = 0; i < tempgrid.length; i++)
        {
            
            for (int x = 0; x < tempgrid.length; x++)
            {
                if (numbers[x].length() != 9)
                {
                    System.err.println("Error: Invalid grid length");
                    return ;
                }
                try
                {
                    tempgrid[i][x] = Integer.parseInt(numbers[x]);
                }
                catch (Exception e)
                {
                    System.err.println("Error: Invalid Grid Integer input");
                    _scanner.nextLine();
                    return ;
                }
            }
        }
        ft_checkGrid_Rows_Columns(tempgrid);
    }

    public void ft_parseUserInput()
    {
        String strUserInput = ft_safeTryCatchString();
        if (strUserInput == null)
            return ;

        if (strUserInput.length() != 3 || !Character.isDigit(strUserInput.charAt(0)) ||
            strUserInput.charAt(1) != ' ' || !Character.isDigit(strUserInput.charAt(2)))
        {
            System.err.println("Error: Input must be two numbers between 1 and 9, " + //
                "separated by a space, example:'2 6'\n");
            return ;
        }
    }

    public boolean ft_userInputMenuChoice()
    {
        switch (_userInputMenu) 
        {
            case 0:
                System.out.println("Programm exiting");
                return false;
            case 1:
                return true;
            case 2:
                return true;
            case 3:
                return true;
            case 4:
                return true;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return true;
            case 8:
                System.out.println("Enter the grid values >");
                ft_userNewGrid();
                return true;
        }
        return true;
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
        {
            System.err.println("Error: Menu option must be between 0 and 8\n");
            return true;
        }
        return ft_userInputMenuChoice();
    }

    public void ft_printGrid()
    {
        System.out.println("--------------------------");
        for (int i = 0; i < _grid.length; i++)
        {
            for (int x = 0; x < _grid[i].length; x++)
            {
                if (x % 3 == 0)
                    System.out.print(" |");
                System.out.printf(" %d", _grid[i][x]);
                if (x == 8)
                    System.out.print(" |\n");
            }
        }
        System.out.println("--------------------------");
    }

    public void ft_startStandardGrid()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                _grid[i][j] = (i / 3 + 3 * (i % 3) + j) % 9 + 1;
            }
        }
    }

    public static void main(String[] args)
    {
        Sudoku sudokuGame = new Sudoku();
        boolean isrunning = true;

        sudokuGame.ft_startStandardGrid();
        sudokuGame.ft_printGrid();
        while (isrunning)
            isrunning = sudokuGame.ft_menu();

        sudokuGame._scanner.close();
    }
}
