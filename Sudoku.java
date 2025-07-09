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
    
    public boolean ft_isGridValid_Rows_Columns_Blocks(int[][] tempgrid)
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
                    return false;
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
                    return false;
                }
            }
        }
        for (int x = 0; x < 9; x+=3)
        {
            for (int i = 0; i < 9; i+=3)
            {
                HashMap<Integer, Integer> map = new HashMap<>();
                for (int x1 = 0; x1 < 3; x1++)
                {
                    for (int i1 = 0; i1 < 3; i1++)
                    {
                        map.put(tempgrid[x + x1][i + i1], map.getOrDefault(tempgrid[x + x1][i + i1], 0) + 1);
                    }
                }
                for (int key = 1; key <= 9; key++)
                {
                    if (map.getOrDefault(key, 0) == 0)
                    {
                        System.err.println("Error: Invalid Grid Blocks (3x3)");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void ft_userNewGrid()
    {
        int[][] tempgrid = new int[9][9];
        for (int i = 0; i < 9; i++)
        {
            String line = _scanner.nextLine().trim();
            String[] numbers = line.split("\\s+"); 

            if (numbers.length != 9)
            {
                System.err.println("Error: Invalid Grid Row Length");
                return;
            }

            for (int j = 0; j < 9; j++)
            {
                try
                {
                    tempgrid[i][j] = Integer.parseInt(numbers[j]);
                }
                catch (NumberFormatException e)
                {
                    System.err.println("Error: Invalid Integer Grid");
                    return;
                }
            }
        }
        if (ft_isGridValid_Rows_Columns_Blocks(tempgrid))
        {
            System.err.println("Success: Grid Valid");
            _grid = tempgrid;
        }
        else
            System.err.println("Error: Grid Invalid");
    }

    public boolean ft_parseUserInput()
    {
        String strUserInput = ft_safeTryCatchString();
        if (strUserInput == null)
            return false;

        if (strUserInput.length() != 3 || !Character.isDigit(strUserInput.charAt(0)) ||
            strUserInput.charAt(1) != ' ' || !Character.isDigit(strUserInput.charAt(2)))
        {
            System.err.println("Error: Input must be two numbers between 1 and 9, " + //
                "separated by a space, example:'2 6'\n");
            return false;
        }
        _userInputSudoku[0] = Character.getNumericValue(strUserInput.charAt(0));
        _userInputSudoku[1] = Character.getNumericValue(strUserInput.charAt(2));
        return true;
    }

    public void ft_permuteTwoColumns()
    {

    }

    public void ft_permuteTwoRows()
    {
        
    }

    public void ft_permuteTwoColumnsOfBand()
    {

    }

    public void ft_permuteTwoRowsOfBand()
    {

    }

    
    public void ft_permuteNumbersGrid()
    {
        int[][] tempgrid = new int[9][9];
        for (int i = 0; i < 9; i++)
        {
            System.arraycopy(_grid[i], 0, tempgrid[i], 0, 9);
        }

        for (int x = 0; x < tempgrid.length; x++)
        {
            for (int i = 0; i < tempgrid[x].length; i++)
            {
                if (tempgrid[x][i] == _userInputSudoku[0])
                    tempgrid[x][i] = _userInputSudoku[1];
                else if (tempgrid[x][i] == _userInputSudoku[1])
                    tempgrid[x][i] = _userInputSudoku[0];
            }
        }
        if (ft_isGridValid_Rows_Columns_Blocks(tempgrid))
            _grid = tempgrid;
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

    public boolean ft_userInputMenuChoice()
    {
        switch (_userInputMenu) 
        {
            case 0:
                System.out.println("Programm exiting");
                return false;
            case 1:
                if (ft_parseUserInput())
                    ft_permuteNumbersGrid();
                return true;
            case 2:
                if (ft_parseUserInput())
                    ft_permuteTwoRowsOfBand();
                return true;
            case 3:
                if (ft_parseUserInput())
                    ft_permuteTwoColumnsOfBand();
                return true;
            case 4:
                if (ft_parseUserInput())
                    ft_permuteTwoRows();
                return true;
            case 5:
                if (ft_parseUserInput())
                    ft_permuteTwoColumns();
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
        ft_printGrid();
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
        while (isrunning)
            isrunning = sudokuGame.ft_menu();

        sudokuGame._scanner.close();
    }
}
